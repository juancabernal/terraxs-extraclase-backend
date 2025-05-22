package co.edu.uco.terraxs.data.dao.entity.unidad.impl.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.unidad.UnidadDAO;
import co.edu.uco.terraxs.entity.UnidadEntity;

public class UnidadPostgreSQLDAO implements UnidadDAO {

    private Connection conexion;

    public UnidadPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(UnidadEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO Unidad(id, nombre) VALUES (?, ?)");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getNombre());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la información de la nueva unidad.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla Unidad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información de la nueva unidad.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla Unidad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<UnidadEntity> listALL() throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre FROM Unidad");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {
                List<UnidadEntity> listaResultados = new java.util.ArrayList<>();

                while (cursorResultados.next()) {
                	UnidadEntity entity = new UnidadEntity();
                    entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    entity.setNombre(cursorResultados.getString("nombre"));
                  

                    listaResultados.add(entity);
                }

                return listaResultados;
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar todas las unidades.";
            var mensajeTecnico = "Se presentó una SQLException ejecutando un SELECT general en la tabla Unidad.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO consultando todas las unidades.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA ejecutando un SELECT general en la tabla Unidad.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<UnidadEntity> listByFilter(UnidadEntity filter) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre FROM Unidad WHERE 1=1 ");

        List<Object> parametros = new java.util.ArrayList<>();

        if (filter.getId() != null) {
            sentenciaSQL.append("AND id = ? ");
            parametros.add(filter.getId());
        }
        if (filter.getNombre() != null && !filter.getNombre().isBlank()) {
			sentenciaSQL.append(" AND nombre ILIKE ?");
			parametros.add("%" + filter.getNombre().trim() + "%");
		}
      
        

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaPreparada.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {
                List<UnidadEntity> listaResultados = new java.util.ArrayList<>();

                while (cursorResultados.next()) {
                	UnidadEntity entity = new UnidadEntity();
                    entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    entity.setNombre(cursorResultados.getString("nombre"));
                

                    listaResultados.add(entity);
                }

                return listaResultados;
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las unidades por filtro.";
            var mensajeTecnico = "Se presentó una SQLException ejecutando un SELECT filtrado en la tabla Unidad.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO consultando las unidades por filtro.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA ejecutando un SELECT filtrado en la tabla Unidad.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
    @Override
    public UnidadEntity listById(UUID id) throws TerraxsException {
        UnidadEntity unidadEntityRetorno = new UnidadEntity();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre FROM Unidad WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);
            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {

                if (cursorResultados.next()) {
                    unidadEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    unidadEntityRetorno.setNombre(cursorResultados.getString("nombre"));
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de la unidad con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla Unidad por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de la unidad con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla Unidad por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return unidadEntityRetorno;
    }

    @Override
    public void update(UUID id, UnidadEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE Unidad SET nombre = ? WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entity.getNombre());
            sentenciaPreparada.setObject(2, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información de la unidad.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla Unidad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información de la unidad.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla Unidad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID id) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Unidad WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información de la unidad.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla Unidad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información de la unidad.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla Unidad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
