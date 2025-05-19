package co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.impl.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; // Importar Timestamp para LocalDateTime
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.TokenConfirmacionDAO;
import co.edu.uco.terraxs.entity.NotificacionEntity; // Asumiendo que existe NotificacionEntity
import co.edu.uco.terraxs.entity.TokenConfirmacionEntity;

public class TokenConfirmacionPostgreSQLDAO implements TokenConfirmacionDAO {

    private Connection conexion;

    public TokenConfirmacionPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(TokenConfirmacionEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO TokenConfirmacion(id, token, fechaSolicitud, fechaExpiracion, usado, notificacion_id) VALUES (?, ?, ?, ?, ?, ?)");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getToken());
            sentenciaPreparada.setTimestamp(3, Timestamp.valueOf(entity.getFechaSolicitud())); // Usar Timestamp para LocalDateTime
            sentenciaPreparada.setTimestamp(4, Timestamp.valueOf(entity.getFechaExpiracion())); // Usar Timestamp para LocalDateTime
            sentenciaPreparada.setBoolean(5, entity.isUsado()); // Usar isUsado
            sentenciaPreparada.setObject(6, entity.getNotificacion().getId()); // Asumiendo que NotificacionEntity tiene un ID

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
    public List<TokenConfirmacionEntity> listByFilter(TokenConfirmacionEntity filter) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TokenConfirmacionEntity> listALL() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TokenConfirmacionEntity listById(UUID id) throws TerraxsException {
        TokenConfirmacionEntity tokenConfirmacionEntityRetorno = new TokenConfirmacionEntity();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, token, fechaSolicitud, fechaExpiracion, usado, notificacion_id FROM TokenConfirmacion WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);
            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {

                if (cursorResultados.next()) {
                    tokenConfirmacionEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    tokenConfirmacionEntityRetorno.setToken(cursorResultados.getString("token"));
                    tokenConfirmacionEntityRetorno.setFechaSolicitud(cursorResultados.getTimestamp("fechaSolicitud").toLocalDateTime()); // Usar getTimestamp
                    tokenConfirmacionEntityRetorno.setFechaExpiracion(cursorResultados.getTimestamp("fechaExpiracion").toLocalDateTime()); // Usar getTimestamp
                    tokenConfirmacionEntityRetorno.setUsado(cursorResultados.getBoolean("usado")); // Usar isUsado

                    NotificacionEntity notificacion = new NotificacionEntity(); // Asumiendo que NotificacionEntity existe
                    notificacion.setId(UtilUUID.convertirAUUID(cursorResultados.getString("notificacion_id")));
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
        sentenciaSQL.append("UPDATE TokenConfirmacion SET token = ?, fechaSolicitud = ?, fechaExpiracion = ?, usado = ?, notificacion_id = ? WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entity.getToken());
            sentenciaPreparada.setTimestamp(2, Timestamp.valueOf(entity.getFechaSolicitud()));
            sentenciaPreparada.setTimestamp(3, Timestamp.valueOf(entity.getFechaExpiracion()));
            sentenciaPreparada.setBoolean(4, entity.isUsado());
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