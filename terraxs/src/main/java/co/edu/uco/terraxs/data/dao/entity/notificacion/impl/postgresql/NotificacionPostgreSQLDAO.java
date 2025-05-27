package co.edu.uco.terraxs.data.dao.entity.notificacion.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.notificacion.NotificacionDAO;
import co.edu.uco.terraxs.entity.NotificacionEntity;
import co.edu.uco.terraxs.entity.TipoNotificacionEntity;
import co.edu.uco.terraxs.entity.UsuarioEntity;

public class NotificacionPostgreSQLDAO implements NotificacionDAO {

	private Connection conexion;

	public NotificacionPostgreSQLDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void create(NotificacionEntity entity) throws TerraxsException {
		var sentenciaSQL = new StringBuilder();
		sentenciaSQL.append("INSERT INTO notificacion (id, codigo_referencia, tipo_notificacion_id, mensaje_adicional, fecha_hora_expiracion, usuario_receptor_id ) ");
		sentenciaSQL.append("VALUES (?, ?, ?, ?, ?, ?)");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getCodigoReferencia());
			sentenciaPreparada.setObject(3, entity.getTipoNotificacion().getId());
			sentenciaPreparada.setString(4, entity.getMensajeAdicional());
			sentenciaPreparada.setObject(5, entity.getFechaHoraEnvio());
			sentenciaPreparada.setObject(6, entity.getUsuarioReceptor().getId());

			sentenciaPreparada.executeUpdate();

		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la información de la notificación";
			var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla notificacion. Para tener más detalles revise el log de errores.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información de la notificación";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla notificacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

	@Override
	public List<NotificacionEntity> listByFilter(NotificacionEntity filter) throws TerraxsException {
		final List<NotificacionEntity> listaResultados = new ArrayList<>();
		final StringBuilder sentenciaSQL = new StringBuilder();
		final List<Object> parametros = new ArrayList<>();

		sentenciaSQL.append("SELECT id, codigo_referencia, tipo_notificacion_id, mensaje_adicional, fecha_hora_expiracion, usuario_receptor_id ");
		sentenciaSQL.append("FROM notificacion WHERE 1=1");

		if (!UtilUUID.esValorDefecto(filter.getId())) {
			sentenciaSQL.append(" AND id = ?");
			parametros.add(filter.getId());
		}

		if (!UtilTexto.getInstance().estaVacia(filter.getCodigoReferencia())) {
			sentenciaSQL.append(" AND LOWER(codigoreferencia) LIKE LOWER(?)");
			parametros.add("%" + UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(filter.getCodigoReferencia()) + "%");
		}

		sentenciaSQL.append(" ORDER BY fecha_hora_expiracion DESC");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

			for (int i = 0; i < parametros.size(); i++) {
				sentenciaPreparada.setObject(i + 1, parametros.get(i));
			}

			try (var cursorResultados = sentenciaPreparada.executeQuery()) {
				while (cursorResultados.next()) {
					var notificacion = new NotificacionEntity();
					
					notificacion.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					notificacion.setCodigoReferencia(cursorResultados.getString("codigo_referencia"));
					notificacion.setTipoNotificacion(new TipoNotificacionEntity(UtilUUID.convertirAUUID(cursorResultados.getString("tipo_notificacion_id"))));
					notificacion.setMensajeAdicional(cursorResultados.getString("mensaje_adicional"));
                    notificacion.setFechaHoraEnvio(cursorResultados.getTimestamp("fecha_hora_expiracion").toLocalDateTime()); 

					notificacion.setUsuarioReceptor(new UsuarioEntity(UtilUUID.convertirAUUID(cursorResultados.getString("usuario_receptor_id"))));
					listaResultados.add(notificacion);
					
					
					
				}
			}

		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar las notificaciones con los filtros deseados";
			var mensajeTecnico = "Se presentó una SQLException al consultar la tabla notificacion usando filtros.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar las notificaciones con los filtros deseados";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar la tabla notificacion usando filtros.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}

		return listaResultados;
	}

	public List<NotificacionEntity> listALL() throws TerraxsException {
		final List<NotificacionEntity> listaResultados = new ArrayList<>();
		final StringBuilder sentenciaSQL = new StringBuilder();

		sentenciaSQL.append("SELECT id, codigo_referencia, tipo_notificacion_id, mensaje_adicional, fecha_hora_expiracion, usuario_receptor_id FROM notificacion ORDER BY fecha_hora_expiracion DESC");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			try (var cursorResultados = sentenciaPreparada.executeQuery()) {
				while (cursorResultados.next()) {
					var notificacion = new NotificacionEntity();
					
					notificacion.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					notificacion.setCodigoReferencia(cursorResultados.getString("codigo_referencia"));
					notificacion.setTipoNotificacion(new TipoNotificacionEntity(UtilUUID.convertirAUUID(cursorResultados.getString("tipo_notificacion_id"))));
					notificacion.setMensajeAdicional(cursorResultados.getString("mensaje_adicional"));
                    notificacion.setFechaHoraEnvio(cursorResultados.getTimestamp("fecha_hora_expiracion").toLocalDateTime()); 

					notificacion.setUsuarioReceptor(new UsuarioEntity(UtilUUID.convertirAUUID(cursorResultados.getString("usuario_receptor_id"))));
					listaResultados.add(notificacion);
					
					
				}
			}
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar todas las notificaciones";
			var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT en la tabla notificacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar todas las notificaciones";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar todos los registros de la tabla notificacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}

		return listaResultados;
	}

	@Override
	public NotificacionEntity listById(UUID id) throws TerraxsException {
		var notificacion = new NotificacionEntity();
		var sentenciaSQL = new StringBuilder();

		sentenciaSQL.append("SELECT id, codigo_referencia, tipo_notificacion_id, mensaje_adicional, fecha_hora_expiracion, usuario_receptor_id  FROM notificacion WHERE id = ?");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, id.toString());

			try (var cursorResultados = sentenciaPreparada.executeQuery()) {
				if (cursorResultados.next()) {
					notificacion.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					notificacion.setCodigoReferencia(cursorResultados.getString("codigo_referencia"));
					notificacion.setTipoNotificacion(new TipoNotificacionEntity(UtilUUID.convertirAUUID(cursorResultados.getString("tipo_notificacion_id"))));
					notificacion.setMensajeAdicional(cursorResultados.getString("mensaje_adicional"));
                    notificacion.setFechaHoraEnvio(cursorResultados.getTimestamp("fecha_hora_expiracion").toLocalDateTime()); 

					notificacion.setUsuarioReceptor(new UsuarioEntity(UtilUUID.convertirAUUID(cursorResultados.getString("usuario_receptor_id"))));
				}
			}
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar la notificación con el ID indicado";
			var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT por id en la tabla notificacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la notificación con el ID indicado";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al ejecutar SELECT por id en la tabla notificacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}

		return notificacion;
	}

	@Override
	public void update(UUID id, NotificacionEntity entity) throws TerraxsException {
		var sentenciaSQL = new StringBuilder();

		sentenciaSQL.append("UPDATE notificacion SET codigo_referencia = ?, tipo_notificacion_id = ?, mensaje_adicional = ?, fecha_hora_expiracion = ?, usuario_receptor_id = ? WHERE id = ?");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setString(1, entity.getCodigoReferencia());
			sentenciaPreparada.setObject(2, entity.getTipoNotificacion().getId());
			sentenciaPreparada.setString(3, entity.getMensajeAdicional());
			sentenciaPreparada.setObject(4, entity.getFechaHoraEnvio());
			sentenciaPreparada.setObject(5, entity.getUsuarioReceptor().getId());
			sentenciaPreparada.setObject(6, id.toString());

			sentenciaPreparada.executeUpdate();

		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de actualizar la notificación";
			var mensajeTecnico = "Se presentó una SQLException al ejecutar UPDATE en la tabla notificacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de actualizar la notificación";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al ejecutar UPDATE en la tabla notificacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

	@Override
	public void delete(UUID id) throws TerraxsException {
		var sentenciaSQL = new StringBuilder();
		sentenciaSQL.append("DELETE FROM notificacion WHERE id = ?");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, id.toString());
			sentenciaPreparada.executeUpdate();
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la notificación";
			var mensajeTecnico = "Se presentó una SQLException al ejecutar DELETE en la tabla notificacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la notificación";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al ejecutar DELETE en la tabla notificacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}
}


