
package co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.impl.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; // Importar Timestamp para LocalDateTime
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.TokenConfirmacionDAO;
import co.edu.uco.terraxs.entity.EstadoEntity;
import co.edu.uco.terraxs.entity.NotificacionEntity; // Asumiendo que existe NotificacionEntity
import co.edu.uco.terraxs.entity.ProductoProveedorEntity;
import co.edu.uco.terraxs.entity.TokenConfirmacionEntity;

public class TokenConfirmacionPostgreSQLDAO implements TokenConfirmacionDAO {

    private Connection conexion;

    public TokenConfirmacionPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(TokenConfirmacionEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO TokenConfirmacion(id, token, fecha_hora_creacion, fecha_hora_expiracion,estado, notificacion) VALUES (?, ?, ?, ?, ?, ?, ?)");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getToken());
            sentenciaPreparada.setTimestamp(3, Timestamp.valueOf(entity.getFechaSolicitud())); 
            sentenciaPreparada.setTimestamp(4, Timestamp.valueOf(entity.getFechaExpiracion())); 
            sentenciaPreparada.setObject(5, entity.getEstado().getId()); 
            sentenciaPreparada.setObject(6, entity.getNotificacion().getId()); 

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la información del nuevo token de confirmación.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla TokenConfirmacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo token de confirmación.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla TokenConfirmacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<TokenConfirmacionEntity> listByFilter(TokenConfirmacionEntity filter) throws TerraxsException {
        var listaResultados = new ArrayList<TokenConfirmacionEntity>();
        var parametros = new ArrayList<Object>();
        var sentenciaSQL = new StringBuilder();
        
        sentenciaSQL.append("SELECT id, token, fecha_hora_creacion, fecha_hora_expiracion, estado, notificacion ");
        sentenciaSQL.append("FROM token_confirmacion ");
        sentenciaSQL.append("WHERE 1=1 ");
        
        if (filter != null) {
            if (!UtilUUID.esValorDefecto(filter.getId())) {
                sentenciaSQL.append("AND id = ? ");
                parametros.add(filter.getId());
            }
            if (filter.getToken() != null && !filter.getToken().isBlank()) {
                sentenciaSQL.append("AND token = ? ");
                parametros.add(filter.getToken());
            }
            if (filter.getFechaSolicitud() != null) {
                sentenciaSQL.append("AND fecha_hora_creacion = ? ");
                parametros.add(Timestamp.valueOf(filter.getFechaSolicitud()));
            }
            if (filter.getFechaExpiracion() != null) {
                sentenciaSQL.append("AND fecha_hora_expiracion = ? ");
                parametros.add(Timestamp.valueOf(filter.getFechaExpiracion()));
            }
            if (filter.getEstado() != null && !UtilUUID.esValorDefecto(filter.getEstado().getId())) {
                sentenciaSQL.append("AND estado = ? ");
                parametros.add(filter.getEstado().getId());
            }
            if (filter.getNotificacion() != null && !UtilUUID.esValorDefecto(filter.getNotificacion().getId())) {
                sentenciaSQL.append("AND notificacion = ? ");
                parametros.add(filter.getNotificacion().getId());
            }
        }

        sentenciaSQL.append("ORDER BY token ASC");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaPreparada.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {
                while (cursorResultados.next()) {
                    var tokenConfirmacionEntityRetorno = new TokenConfirmacionEntity();

                    EstadoEntity estado = new EstadoEntity();
                    estado.setId(UtilUUID.convertirAUUID(cursorResultados.getString("estado")));
                    tokenConfirmacionEntityRetorno.setEstado(estado);

                    NotificacionEntity notificacion = new NotificacionEntity();
                    notificacion.setId(UtilUUID.convertirAUUID(cursorResultados.getString("notificacion")));
                    tokenConfirmacionEntityRetorno.setNotificacion(notificacion);

                    tokenConfirmacionEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    tokenConfirmacionEntityRetorno.setToken(cursorResultados.getString("token"));
                    tokenConfirmacionEntityRetorno.setFechaSolicitud(cursorResultados.getTimestamp("fecha_hora_creacion").toLocalDateTime());
                    tokenConfirmacionEntityRetorno.setFechaExpiracion(cursorResultados.getTimestamp("fecha_hora_expiracion").toLocalDateTime());

                    listaResultados.add(tokenConfirmacionEntityRetorno);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los tokens de confirmación con los filtros deseados.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT con filtros en la tabla TokenConfirmacion.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar los tokens de confirmación con los filtros deseados.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al hacer SELECT con filtros en la tabla TokenConfirmacion.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaResultados;
    }


    @Override
    public List<TokenConfirmacionEntity> listALL() throws TerraxsException {
		var listaResultados=new ArrayList<TokenConfirmacionEntity>();
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("SELECT id, token , fecha_hora_creacion, fecha_hora_expiracion, estado,notificacion  FROM tokenConfirmacion ORDER BY token ASC");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			
			try(var cursorResultados = sentenciaPreparada.executeQuery()){
				
				while(cursorResultados.next()) {
					var tokenConfirmacionEntityRetorno = new TokenConfirmacionEntity();
					
                    EstadoEntity estado = new EstadoEntity();
                    estado.setId(UtilUUID.convertirAUUID(cursorResultados.getString("estado")));
                    tokenConfirmacionEntityRetorno.setEstado(estado);
                    
                    NotificacionEntity notificacion = new NotificacionEntity();
                    notificacion.setId(UtilUUID.convertirAUUID(cursorResultados.getString("notificacion")));
                    tokenConfirmacionEntityRetorno.setNotificacion(notificacion);
					
                    
					tokenConfirmacionEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					tokenConfirmacionEntityRetorno.setToken(cursorResultados.getString("token"));
					tokenConfirmacionEntityRetorno.setFechaSolicitud(cursorResultados.getTimestamp("fecha_hora_creacion").toLocalDateTime());
					tokenConfirmacionEntityRetorno.setFechaExpiracion(cursorResultados.getTimestamp("fecha_hora_expiracion").toLocalDateTime());
					tokenConfirmacionEntityRetorno.setEstado(estado);
					tokenConfirmacionEntityRetorno.setNotificacion(notificacion);		
					
					
					listaResultados.add(tokenConfirmacionEntityRetorno);
				}
				
				
			}
			
		} catch(SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar todos los token de confirmacion";
			var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT * en la tabla token confirmacion. Revise la conexión o la estructura de la tabla.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar todos los token de confirmacion";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar todos los registros de la tabla token confirmacion.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return listaResultados;
	}
    
  

    @Override
    public TokenConfirmacionEntity listById(UUID id) throws TerraxsException {
        TokenConfirmacionEntity tokenConfirmacionEntityRetorno = new TokenConfirmacionEntity();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, token, fecha_hora_creacion, fecha_hora_expiracion,estado, notificacion FROM TokenConfirmacion WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);
            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {

                if (cursorResultados.next()) {
                	
                    EstadoEntity estado = new EstadoEntity(); 
                    estado.setId(UtilUUID.convertirAUUID(cursorResultados.getString("estado")));
                    tokenConfirmacionEntityRetorno.setEstado(estado);

                    NotificacionEntity notificacion = new NotificacionEntity(); 
                    notificacion.setId(UtilUUID.convertirAUUID(cursorResultados.getString("notificacion")));
                    tokenConfirmacionEntityRetorno.setNotificacion(notificacion);
                	
                    tokenConfirmacionEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    tokenConfirmacionEntityRetorno.setToken(cursorResultados.getString("token"));
                    tokenConfirmacionEntityRetorno.setFechaSolicitud(cursorResultados.getTimestamp("fecha_hora_creacion").toLocalDateTime()); 
                    tokenConfirmacionEntityRetorno.setFechaExpiracion(cursorResultados.getTimestamp("fecha_hora_expiracion").toLocalDateTime()); 
            		tokenConfirmacionEntityRetorno.setEstado(estado);
					tokenConfirmacionEntityRetorno.setNotificacion(notificacion);
                    
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información del token de confirmación con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla TokenConfirmacion por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del token de confirmación con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla TokenConfirmacion por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return tokenConfirmacionEntityRetorno;
    }

    @Override
    public void update(UUID id, TokenConfirmacionEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE TokenConfirmacion SET token = ?, fecha_hora_creacion = ?, fecha_hora_expiracion = ?, estado= ?, notificacion = ? WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entity.getToken());
            sentenciaPreparada.setTimestamp(2, Timestamp.valueOf(entity.getFechaSolicitud()));
            sentenciaPreparada.setTimestamp(3, Timestamp.valueOf(entity.getFechaExpiracion()));
            sentenciaPreparada.setObject(4, entity.getEstado().getId());
            sentenciaPreparada.setObject(5, entity.getNotificacion().getId());
            sentenciaPreparada.setObject(6, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del token de confirmación.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla TokenConfirmacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información del token de confirmación.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla TokenConfirmacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID id) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM TokenConfirmacion WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del token de confirmación.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla TokenConfirmacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información del token de confirmación.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla TokenConfirmacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}