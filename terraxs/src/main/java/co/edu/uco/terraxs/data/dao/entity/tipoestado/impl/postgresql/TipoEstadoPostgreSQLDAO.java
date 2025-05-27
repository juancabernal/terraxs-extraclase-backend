package co.edu.uco.terraxs.data.dao.entity.tipoestado.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.tipoestado.TipoEstadoDAO;
import co.edu.uco.terraxs.entity.TipoEstadoEntity;

public class TipoEstadoPostgreSQLDAO implements TipoEstadoDAO {

    private final Connection conexion;

    public TipoEstadoPostgreSQLDAO(final Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(TipoEstadoEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO tipo_estado (id, nombre) VALUES (?, ?)");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getNombre());
            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar el nuevo tipo de estado.";
            var mensajeTecnico = "Ocurrió una SQLException al intentar insertar en la tabla tipo_estado. Revise la conexión o los datos enviados.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar el nuevo tipo de estado.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al insertar en la tabla tipo_estado.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<TipoEstadoEntity> listByFilter(TipoEstadoEntity filter) throws TerraxsException {
        final List<TipoEstadoEntity> resultados = new ArrayList<>();
        final var sentenciaSQL = new StringBuilder("SELECT id, nombre FROM tipo_estado WHERE 1=1 ");
        final var parametros = new ArrayList<Object>();

        if (!UtilUUID.esValorDefecto(filter.getId())) {
            sentenciaSQL.append("AND id = ? ");
            parametros.add(filter.getId());
        }

        if (!UtilTexto.getInstance().estaVacia(filter.getNombre())) {
            sentenciaSQL.append("AND LOWER(nombre) LIKE LOWER(?) ");
            parametros.add("%" + UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(filter.getNombre()) + "%");
        }

        sentenciaSQL.append("ORDER BY nombre ASC");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaPreparada.setObject(i + 1, parametros.get(i));
            }

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {
                while (cursorResultados.next()) {
                    var entity = new TipoEstadoEntity();
                    entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    entity.setNombre(cursorResultados.getString("nombre"));
                    resultados.add(entity);
                }
            }

        } catch (SQLException exception) {
            var mensajeUsuario = "Se presentó un problema al consultar los tipos de estado con los filtros indicados.";
            var mensajeTecnico = "SQLException al hacer SELECT en tipo_estado con filtros.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO al consultar los tipos de estado.";
            var mensajeTecnico = "Excepción no controlada al filtrar la tabla tipo_estado.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return resultados;
    }

    @Override
    public List<TipoEstadoEntity> listALL() throws TerraxsException {
        var resultados = new ArrayList<TipoEstadoEntity>();
        var sentenciaSQL = "SELECT id, nombre FROM tipo_estado ORDER BY nombre ASC";

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
             var cursorResultados = sentenciaPreparada.executeQuery()) {

            while (cursorResultados.next()) {
                var entity = new TipoEstadoEntity();
                entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                entity.setNombre(cursorResultados.getString("nombre"));
                resultados.add(entity);
            }

        } catch (SQLException exception) {
            var mensajeUsuario = "Se presentó un problema al consultar todos los tipos de estado.";
            var mensajeTecnico = "SQLException al hacer SELECT * en tipo_estado.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO al consultar todos los tipos de estado.";
            var mensajeTecnico = "Excepción no controlada al hacer SELECT * en tipo_estado.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return resultados;
    }

    @Override
    public TipoEstadoEntity listById(UUID id) throws TerraxsException {
        var entity = new TipoEstadoEntity();
        var sentenciaSQL = "SELECT id, nombre FROM tipo_estado WHERE id = ?";

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL)) {
            sentenciaPreparada.setObject(1, id.toString());

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {
                if (cursorResultados.next()) {
                    entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    entity.setNombre(cursorResultados.getString("nombre"));
                }
            }

        } catch (SQLException exception) {
            var mensajeUsuario = "Se presentó un problema al consultar el tipo de estado por su ID.";
            var mensajeTecnico = "SQLException al hacer SELECT en tipo_estado por ID.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO al consultar el tipo de estado por su ID.";
            var mensajeTecnico = "Excepción no controlada al hacer SELECT en tipo_estado por ID.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return entity;
    }

    @Override
    public void update(UUID id, TipoEstadoEntity entity) throws TerraxsException {
        var sentenciaSQL = "UPDATE tipo_estado SET nombre = ? WHERE id = ?";

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL)) {
            sentenciaPreparada.setString(1, entity.getNombre());
            sentenciaPreparada.setObject(2, id.toString());

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "Se presentó un problema al actualizar la información del tipo de estado.";
            var mensajeTecnico = "SQLException al hacer UPDATE en tipo_estado.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO al actualizar el tipo de estado.";
            var mensajeTecnico = "Excepción no controlada al hacer UPDATE en tipo_estado.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID id) throws TerraxsException {
        var sentenciaSQL = "DELETE FROM tipo_estado WHERE id = ?";

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL)) {
            sentenciaPreparada.setObject(1, id.toString());
            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "Se presentó un problema al eliminar el tipo de estado.";
            var mensajeTecnico = "SQLException al hacer DELETE en tipo_estado.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO al eliminar el tipo de estado.";
            var mensajeTecnico = "Excepción no controlada al hacer DELETE en tipo_estado.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
