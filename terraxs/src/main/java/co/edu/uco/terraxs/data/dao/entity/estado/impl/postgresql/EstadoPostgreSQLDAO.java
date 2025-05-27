package co.edu.uco.terraxs.data.dao.entity.estado.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.estado.EstadoDAO;
import co.edu.uco.terraxs.entity.EstadoEntity;
import co.edu.uco.terraxs.entity.TipoEstadoEntity;

public class EstadoPostgreSQLDAO implements EstadoDAO {

    private Connection conexion;

    public EstadoPostgreSQLDAO(final Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(EstadoEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO estado (id, nombre, tipo_estado) VALUES (?, ?, ?)");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getNombre());
            sentenciaPreparada.setObject(3, entity.getTipoEstado().getId());

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la información del nuevo estado";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla estado. Para más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo estado";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla estado. Para más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<EstadoEntity> listByFilter(final EstadoEntity filter) throws TerraxsException {
        final List<EstadoEntity> listaResultados = new ArrayList<>();
        final StringBuilder sentenciaSQL = new StringBuilder();
        final List<Object> parametros = new ArrayList<>();

        sentenciaSQL.append("SELECT id, nombre, tipo_estado FROM estado WHERE 1=1");

        if (!UtilUUID.esValorDefecto(filter.getId())) {
            sentenciaSQL.append(" AND id = ?");
            parametros.add(filter.getId());
        }

        if (!UtilTexto.getInstance().estaVacia(filter.getNombre())) {
            sentenciaSQL.append(" AND LOWER(nombre) LIKE LOWER(?)");
            parametros.add("%" + UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(filter.getNombre()) + "%");
        }

        if (filter.getTipoEstado() != null && !UtilUUID.esValorDefecto(filter.getTipoEstado().getId())) {
            sentenciaSQL.append(" AND tipo_estado = ?");
            parametros.add(filter.getTipoEstado().getId());
        }

        sentenciaSQL.append(" ORDER BY nombre ASC");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            for (int i = 0; i < parametros.size(); i++) {
                sentenciaPreparada.setObject(i + 1, parametros.get(i));
            }

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {
                while (cursorResultados.next()) {
                    var estadoEntityRetorno = new EstadoEntity();
                    estadoEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    estadoEntityRetorno.setNombre(cursorResultados.getString("nombre"));
                    var tipoEstado = new TipoEstadoEntity();
                    tipoEstado.setId(UtilUUID.convertirAUUID(cursorResultados.getString("tipo_estado")));
                    estadoEntityRetorno.setTipoEstado(tipoEstado);
                    listaResultados.add(estadoEntityRetorno);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los estados con los filtros deseados";
            var mensajeTecnico = "Se presentó una SQLException al consultar la tabla estado usando filtros. Revise la sintaxis SQL o los parámetros.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar los estados con los filtros deseados";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar la tabla estado usando filtros.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaResultados;
    }

    @Override
    public List<EstadoEntity> listALL() throws TerraxsException {
        var listaResultados = new ArrayList<EstadoEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, tipo_estado FROM estado ORDER BY nombre ASC");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {

                while (cursorResultados.next()) {

                    var estadoEntityRetorno = new EstadoEntity();

                    estadoEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    estadoEntityRetorno.setNombre(cursorResultados.getString("nombre"));
                    var tipoEstado = new TipoEstadoEntity();
                    tipoEstado.setId(UtilUUID.convertirAUUID(cursorResultados.getString("tipo_estado")));
                    estadoEntityRetorno.setTipoEstado(tipoEstado);

                    listaResultados.add(estadoEntityRetorno);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar todos los estados";
            var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT * en la tabla estado. Revise la conexión o la estructura de la tabla.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar todos los estados";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar todos los registros de la tabla estado.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaResultados;
    }

    @Override
    public EstadoEntity listById(UUID id) throws TerraxsException {
        var estadoEntityRetorno = new EstadoEntity();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre, tipo_estado FROM estado WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            sentenciaPreparada.setObject(1, id.toString());

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {

                if (cursorResultados.next()) {
                    estadoEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    estadoEntityRetorno.setNombre(cursorResultados.getString("nombre"));
                    var tipoEstado = new TipoEstadoEntity();
                    tipoEstado.setId(UtilUUID.convertirAUUID(cursorResultados.getString("tipo_estado")));
                    estadoEntityRetorno.setTipoEstado(tipoEstado);
                }
            }

        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información del estado con el identificador deseado";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla estado por id. Para más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del estado con el identificador deseado";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla estado por id. Para más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return estadoEntityRetorno;
    }

    @Override
    public void update(UUID id, EstadoEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE estado SET nombre = ?, tipo_estado = ? WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entity.getNombre());
            sentenciaPreparada.setObject(2, entity.getTipoEstado().getId());
            sentenciaPreparada.setObject(3, id.toString());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del estado";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla estado. Para más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información del estado";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla estado. Para más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID id) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("DELETE FROM estado WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id.toString());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del estado";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla estado. Para más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de elimianr la información del estado";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un Delete en la tabla estado. Para más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}

