package co.edu.uco.terraxs.data.dao.entity.ciudad.impl.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.terraxs.entity.CiudadEntity;
import co.edu.uco.terraxs.entity.DepartamentoEntity;
import co.edu.uco.terraxs.entity.PaisEntity;

public class CiudadPostgreSQLDAO implements CiudadDAO {

    private Connection conexion;

    public CiudadPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(CiudadEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO Ciudad(id, nombre, departamento_id) VALUES (?, ?, ?)"); // Added departamento_id
        
        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getNombre());
            sentenciaPreparada.setObject(3, entity.getDepartamento().getId()); //Set departamento ID

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la información de la nueva ciudad.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla Ciudad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información de la nueva ciudad.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla Ciudad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<CiudadEntity> listByFilter(final CiudadEntity filter) throws TerraxsException {

        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("""
            SELECT c.id AS ciudad_id, c.nombre AS ciudad_nombre,
                   d.id AS departamento_id, d.nombre AS departamento_nombre,
                   p.id AS pais_id, p.nombre AS pais_nombre
            FROM ciudad c
            JOIN departamento d ON c.departamento = d.id
            JOIN pais p ON d.pais = p.id
            WHERE 1=1
        """);

        final List<CiudadEntity> ciudades = new ArrayList<>();
        final List<Object> parametros = new ArrayList<>();

        if (filter != null) {
            if (filter.getId() != null) {
                sentenciaSQL.append(" AND c.id = ?");
                parametros.add(filter.getId());
            }
            if (filter.getNombre() != null && !filter.getNombre().isBlank()) {
                sentenciaSQL.append(" AND c.nombre ILIKE ?");
                parametros.add("%" + filter.getNombre().trim() + "%");
            }
            if (filter.getDepartamento() != null && filter.getDepartamento().getId() != null) {
                sentenciaSQL.append(" AND d.id = ?");
                parametros.add(filter.getDepartamento().getId());
            }
        }

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaPreparada.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
                while (resultado.next()) {
                    var pais = new PaisEntity();
                    pais.setId(UtilUUID.convertirAUUID(resultado.getString("pais_id")));
                    pais.setNombre(resultado.getString("pais_nombre"));

                    var departamento = new DepartamentoEntity();
                    departamento.setId(UtilUUID.convertirAUUID(resultado.getString("departamento_id")));
                    departamento.setNombre(resultado.getString("departamento_nombre"));
                    departamento.setPais(pais);

                    var ciudad = new CiudadEntity();
                    ciudad.setId(UtilUUID.convertirAUUID(resultado.getString("ciudad_id")));
                    ciudad.setNombre(resultado.getString("ciudad_nombre"));
                    ciudad.setDepartamento(departamento);

                    ciudades.add(ciudad);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades con los filtros deseados";
            var mensajeTecnico = "Se presentó una SQLException al consultar la tabla ciudad usando filtros. Revise la sintaxis SQL o los parámetros.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar las ciudades con los filtros deseados";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar la tabla ciudad usando filtros.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return ciudades;
    }

    @Override
    public List<CiudadEntity> listALL() throws TerraxsException {

        final List<CiudadEntity> ciudades = new ArrayList<>();
        final String sentenciaSQL = """
            SELECT c.id AS ciudad_id, c.nombre AS ciudad_nombre,
                   d.id AS departamento_id, d.nombre AS departamento_nombre,
                   p.id AS pais_id, p.nombre AS pais_nombre
            FROM ciudad c
            JOIN departamento d ON c.departamento = d.id
            JOIN pais p ON d.pais = p.id
        """;

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
             ResultSet resultado = sentenciaPreparada.executeQuery()) {

            while (resultado.next()) {
                var pais = new PaisEntity();
                pais.setId(UtilUUID.convertirAUUID(resultado.getString("pais_id")));
                pais.setNombre(resultado.getString("pais_nombre"));

                var departamento = new DepartamentoEntity();
                departamento.setId(UtilUUID.convertirAUUID(resultado.getString("departamento_id")));
                departamento.setNombre(resultado.getString("departamento_nombre"));
                departamento.setPais(pais);

                var ciudad = new CiudadEntity();
                ciudad.setId(UtilUUID.convertirAUUID(resultado.getString("ciudad_id")));
                ciudad.setNombre(resultado.getString("ciudad_nombre"));
                ciudad.setDepartamento(departamento);

                ciudades.add(ciudad);
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar todas las ciudades";
            var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT * en la tabla ciudad.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar todas las ciudades";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar todas las ciudades.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return ciudades;
    }



    @Override
    public CiudadEntity listById(UUID id) throws TerraxsException {
        CiudadEntity ciudadEntityRetorno = new CiudadEntity();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, departamento_id FROM Ciudad WHERE id = ?"); // Added departamento_id

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);
            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {

                if (cursorResultados.next()) {
                    ciudadEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    ciudadEntityRetorno.setNombre(cursorResultados.getString("nombre"));
                    
                    //Create a DepartamentoEntity and set the id.
                    DepartamentoEntity departamento = new DepartamentoEntity();
                    departamento.setId(UtilUUID.convertirAUUID(cursorResultados.getString("departamento_id")));
                    ciudadEntityRetorno.setDepartamento(departamento); // Set departamento
    

                }
            }


        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de la ciudad con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla Ciudad por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de la ciudad con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla Ciudad por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return ciudadEntityRetorno;
    }

    @Override
    public void update(UUID id, CiudadEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE Ciudad SET nombre = ?, departamento_id = ? WHERE id = ?"); // Added departamento_id
        
        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getNombre());
            sentenciaPreparada.setObject(2, entity.getDepartamento().getId()); //Set Departamento Id
            sentenciaPreparada.setObject(3, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información de la ciudad.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla Ciudad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información de la ciudad.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla Ciudad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID id) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Ciudad WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información de la ciudad.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla Ciudad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información de la ciudad.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla Ciudad. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
