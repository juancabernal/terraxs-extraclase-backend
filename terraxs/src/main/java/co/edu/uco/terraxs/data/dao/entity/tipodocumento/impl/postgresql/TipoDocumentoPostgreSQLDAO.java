package co.edu.uco.terraxs.data.dao.entity.tipodocumento.impl.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.tipodocumento.TipoDocumentoDAO;
import co.edu.uco.terraxs.entity.TipoDocumentoEntity;

public class TipoDocumentoPostgreSQLDAO implements TipoDocumentoDAO {

	private Connection conexion;

	public TipoDocumentoPostgreSQLDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void create(TipoDocumentoEntity entity) throws TerraxsException {
		var sentenciaSQL = new StringBuilder();
		sentenciaSQL.append("INSERT INTO tipo_documento (id, nombre) VALUES (?, ?)");

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getNombre());

			sentenciaPreparada.executeUpdate();
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar el nuevo tipo de documento";
			var mensajeTecnico = "SQLException en INSERT a tabla tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Error inesperado al registrar el nuevo tipo de documento";
			var mensajeTecnico = "Exception inesperada en INSERT a tabla tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

	@Override
	public List<TipoDocumentoEntity> listByFilter(TipoDocumentoEntity filter) throws TerraxsException {
		final List<TipoDocumentoEntity> listaResultados = new ArrayList<>();
		final StringBuilder sentenciaSQL = new StringBuilder();
		final List<Object> parametros = new ArrayList<>();

		sentenciaSQL.append("SELECT id, nombre FROM tipo_documento WHERE 1=1");

		if (!UtilUUID.esValorDefecto(filter.getId())) {
			sentenciaSQL.append(" AND id = ?");
			parametros.add(filter.getId());
		}

		if (!UtilTexto.getInstance().estaVacia(filter.getNombre())) {
			sentenciaSQL.append(" AND LOWER(nombre) LIKE LOWER(?)");
			parametros.add("%" + UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(filter.getNombre()) + "%");
		}

		sentenciaSQL.append(" ORDER BY nombre ASC");

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			for (int i = 0; i < parametros.size(); i++) {
				sentenciaPreparada.setObject(i + 1, parametros.get(i));
			}

			try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {
				while (cursorResultados.next()) {
					var entity = new TipoDocumentoEntity();
					entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					entity.setNombre(cursorResultados.getString("nombre"));
					listaResultados.add(entity);
				}
			}
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema consultando los tipos de documento con los filtros";
			var mensajeTecnico = "SQLException en SELECT con filtros en tabla tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Error inesperado consultando los tipos de documento con filtros";
			var mensajeTecnico = "Exception inesperada en SELECT con filtros en tabla tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}

		return listaResultados;
	}

	@Override
	public List<TipoDocumentoEntity> listALL() throws TerraxsException {
		var listaResultados = new ArrayList<TipoDocumentoEntity>();
		var sentenciaSQL = new StringBuilder("SELECT id, nombre FROM tipo_documento ORDER BY nombre ASC");

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {
				while (cursorResultados.next()) {
					var entity = new TipoDocumentoEntity();
					entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					entity.setNombre(cursorResultados.getString("nombre"));
					listaResultados.add(entity);
				}
			}
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema consultando todos los tipos de documento";
			var mensajeTecnico = "SQLException al hacer SELECT * en tabla tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Error inesperado al consultar todos los tipos de documento";
			var mensajeTecnico = "Exception inesperada al consultar todos los registros de tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}

		return listaResultados;
	}

	@Override
	public TipoDocumentoEntity listById(UUID id) throws TerraxsException {
		var entity = new TipoDocumentoEntity();
		var sentenciaSQL = new StringBuilder("SELECT id, nombre FROM tipo_documento WHERE id = ?");

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, id.toString());

			try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {
				if (cursorResultados.next()) {
					entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					entity.setNombre(cursorResultados.getString("nombre"));
				}
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema consultando el tipo de documento por ID";
			var mensajeTecnico = "SQLException al hacer SELECT por ID en tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Error inesperado al consultar el tipo de documento por ID";
			var mensajeTecnico = "Exception inesperada al hacer SELECT por ID en tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}

		return entity;
	}

	@Override
	public void update(UUID id, TipoDocumentoEntity entity) throws TerraxsException {
		var sentenciaSQL = new StringBuilder("UPDATE tipo_documento SET nombre = ? WHERE id = ?");

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setObject(2, id.toString());

			sentenciaPreparada.executeUpdate();
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema modificando el tipo de documento";
			var mensajeTecnico = "SQLException en UPDATE de tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Error inesperado al modificar el tipo de documento";
			var mensajeTecnico = "Exception inesperada en UPDATE de tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

	@Override
	public void delete(UUID id) throws TerraxsException {
		var sentenciaSQL = new StringBuilder("DELETE FROM tipo_documento WHERE id = ?");

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, id.toString());

			sentenciaPreparada.executeUpdate();
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema eliminando el tipo de documento";
			var mensajeTecnico = "SQLException al hacer DELETE en tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Error inesperado al eliminar el tipo de documento";
			var mensajeTecnico = "Exception inesperada al hacer DELETE en tipo_documento";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}
}

