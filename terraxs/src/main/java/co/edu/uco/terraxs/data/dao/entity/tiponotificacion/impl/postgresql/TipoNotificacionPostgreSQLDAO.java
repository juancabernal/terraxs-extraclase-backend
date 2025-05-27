package co.edu.uco.terraxs.data.dao.entity.tiponotificacion.impl.postgresql;

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
import co.edu.uco.terraxs.data.dao.entity.tiponotificacion.TipoNotificacionDAO;
import co.edu.uco.terraxs.entity.TipoNotificacionEntity;

public class TipoNotificacionPostgreSQLDAO implements TipoNotificacionDAO {

    private Connection conexion;

    public TipoNotificacionPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(TipoNotificacionEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO tipo_notificacion(id, nombre, mensaje) VALUES (?, ?, ?)");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getNombre());
            sentenciaPreparada.setString(3, entity.getMensaje());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la información del nuevo tipo de notificación.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla TipoNotificacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo tipo de notificación.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla TipoNotificacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<TipoNotificacionEntity> listALL() throws TerraxsException {
        var listaResultados = new ArrayList<TipoNotificacionEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, mensaje FROM tipo_notificacion ORDER BY nombre ASC");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {

                while (cursorResultados.next()) {
                    var tipoNotificacionEntityRetorno = new TipoNotificacionEntity();

                    tipoNotificacionEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    tipoNotificacionEntityRetorno.setNombre(cursorResultados.getString("nombre"));
                    tipoNotificacionEntityRetorno.setMensaje(cursorResultados.getString("mensaje"));

                    listaResultados.add(tipoNotificacionEntityRetorno);
                }

            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar todos los tipos de notificación.";
            var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT * en la tabla TipoNotificacion. Revise la conexión o la estructura de la tabla.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar todos los tipos de notificación.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar todos los registros de la tabla TipoNotificacion.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaResultados;
    }

    @Override
    public List<TipoNotificacionEntity> listByFilter(TipoNotificacionEntity filter) throws TerraxsException {
        final List<TipoNotificacionEntity> listaResultados = new ArrayList<>();
        final StringBuilder sentenciaSQL = new StringBuilder();
        final List<Object> parametros = new ArrayList<>();

        sentenciaSQL.append("SELECT id, nombre, mensaje FROM tipo_notificacion WHERE 1=1");

        if (!UtilUUID.esValorDefecto(filter.getId())) {
            sentenciaSQL.append(" AND id = ?");
            parametros.add(filter.getId());
        }

        if (!co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto.getInstance().estaVacia(filter.getNombre())) {
            sentenciaSQL.append(" AND LOWER(nombre) LIKE LOWER(?)");
            parametros.add("%" + UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(filter.getNombre()) + "%");
        }

        if (!co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto.getInstance().estaVacia(filter.getMensaje())) {
            sentenciaSQL.append(" AND LOWER(mensaje) LIKE LOWER(?)");
            parametros.add("%" + UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(filter.getMensaje()) + "%");
        }

        sentenciaSQL.append(" ORDER BY nombre ASC");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            for (int i = 0; i < parametros.size(); i++) {
                sentenciaPreparada.setObject(i + 1, parametros.get(i));
            }

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {
                while (cursorResultados.next()) {
                    var tipoNotificacionEntityRetorno = new TipoNotificacionEntity();
                    tipoNotificacionEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    tipoNotificacionEntityRetorno.setNombre(cursorResultados.getString("nombre"));
                    tipoNotificacionEntityRetorno.setMensaje(cursorResultados.getString("mensaje"));
                    listaResultados.add(tipoNotificacionEntityRetorno);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los tipos de notificación con los filtros deseados.";
            var mensajeTecnico = "Se presentó una SQLException al consultar la tabla TipoNotificacion usando filtros. Revise la sintaxis SQL o los parámetros.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar los tipos de notificación con los filtros deseados.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar la tabla TipoNotificacion usando filtros.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaResultados;
    }


    @Override
    public TipoNotificacionEntity listById(UUID id) throws TerraxsException {
        TipoNotificacionEntity tipoNotificacionEntityRetorno = new TipoNotificacionEntity();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, mensaje FROM tipo_notificacion WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);
            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {

                if (cursorResultados.next()) {
                    tipoNotificacionEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    tipoNotificacionEntityRetorno.setNombre(cursorResultados.getString("nombre"));
                    tipoNotificacionEntityRetorno.setMensaje(cursorResultados.getString("mensaje"));
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información del tipo de notificación con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla TipoNotificacion por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del tipo de notificación con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla TipoNotificacion por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return tipoNotificacionEntityRetorno;
    }

    @Override
    public void update(UUID id, TipoNotificacionEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE tipo_notificacion SET nombre = ?, mensaje = ? WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entity.getNombre());
            sentenciaPreparada.setString(2, entity.getMensaje());
            sentenciaPreparada.setObject(3, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del tipo de notificación.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla TipoNotificacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información del tipo de notificación.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla TipoNotificacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID id) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM tipo_notificacion WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del tipo de notificación.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla TipoNotificacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información del tipo de notificación.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla TipoNotificacion. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
