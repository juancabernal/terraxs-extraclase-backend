package co.edu.uco.terraxs.data.dao.entity.departamento.impl.postgresql;

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
import co.edu.uco.terraxs.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.terraxs.entity.DepartamentoEntity;
import co.edu.uco.terraxs.entity.PaisEntity;

public class DepartamentoPostgreSQLDAO implements DepartamentoDAO {
	
	private Connection conexion;
	
	public DepartamentoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}


	@Override
	public void create(DepartamentoEntity entity) throws TerraxsException {
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("INSERT INTO Departamento(id,nombre) VALUES (?,?)");
		
		try(var sentenciaPreparada=conexion.prepareStatement(sentenciaSQL.toString())){
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getNombre());
			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de registrar la información del nuevo departamento";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla departamento. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo departamento";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla departamento. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
		
	}	@Override
	public List<DepartamentoEntity> listByFilter(final DepartamentoEntity filter) throws TerraxsException {

	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT d.id, d.nombre, p.id AS pais_id, p.nombre AS pais_nombre ")
	                .append("FROM departamento d ")
	                .append("JOIN pais p ON d.id_pais = p.id ")
	                .append("WHERE 1=1 ");

	    final List<DepartamentoEntity> departamentos = new ArrayList<>();
	    final List<Object> parametros = new ArrayList<>();

	    if (filter != null) {
	        if (filter.getId() != null) {
	            sentenciaSQL.append(" AND d.id = ?");
	            parametros.add(filter.getId());
	        }
	        if (filter.getNombre() != null && !filter.getNombre().isBlank()) {
	            sentenciaSQL.append(" AND d.nombre ILIKE ?");
	            parametros.add("%" + filter.getNombre().trim() + "%");
	        }
	        if (filter.getPais() != null && filter.getPais().getId() != null) {
	            sentenciaSQL.append(" AND p.id = ?");
	            parametros.add(filter.getPais().getId());
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
	                departamento.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
	                departamento.setNombre(resultado.getString("nombre"));
	                departamento.setPais(pais);

	                departamentos.add(departamento);
	            }
	        }
	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar los departamentos con los filtros deseados";
	        var mensajeTecnico = "SQLException al consultar la tabla departamento con filtros. Revise la sintaxis SQL o parámetros.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar los departamentos con los filtros deseados";
	        var mensajeTecnico = "Excepción NO CONTROLADA al consultar la tabla departamento con filtros.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return departamentos;
	}
	
	@Override
	public List<DepartamentoEntity> listALL() throws TerraxsException {

	    final List<DepartamentoEntity> departamentos = new ArrayList<>();
	    final String sentenciaSQL = "SELECT d.id, d.nombre, p.id AS pais_id, p.nombre AS pais_nombre FROM departamento d JOIN pais p ON d.id_pais = p.id ";

	    try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
	         ResultSet resultado = sentenciaPreparada.executeQuery()) {

	        while (resultado.next()) {
	            var pais = new PaisEntity();
	            pais.setId(UtilUUID.convertirAUUID(resultado.getString("pais_id")));
	            pais.setNombre(resultado.getString("pais_nombre"));

	            var departamento = new DepartamentoEntity();
	            departamento.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
	            departamento.setNombre(resultado.getString("nombre"));
	            departamento.setPais(pais);

	            departamentos.add(departamento);
	        }
	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar todos los departamentos";
	        var mensajeTecnico = "SQLException al ejecutar SELECT en la tabla departamento. Revise la conexión o estructura.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar todos los departamentos";
	        var mensajeTecnico = "Excepción NO CONTROLADA al consultar todos los registros de la tabla departamento.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return departamentos;
	}



	@Override
	public DepartamentoEntity listById(UUID id) throws TerraxsException {
		var departamentoEntityRetorno=new DepartamentoEntity();
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("SELECT id,nombre FROM departamento WHERE id=?");
		
		try(var sentenciaPreparada=conexion.prepareStatement(sentenciaSQL.toString())){
			sentenciaPreparada.setObject(1,id);
			try(var cursorResultados=sentenciaPreparada.executeQuery()){
				
				if(cursorResultados.next()) {
					departamentoEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					departamentoEntityRetorno.setNombre(cursorResultados.getString("nombre"));
					
				}
			}
			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de consultar la información del departamento con el identificador deseado";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla departamento por id. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información del departamento con el identificador deseado";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla departamento por id. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
		return departamentoEntityRetorno;
		
		
	}

	@Override
	public void update(UUID id, DepartamentoEntity entity) throws TerraxsException {
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("UPDATE departamento SET nombre = ? WHERE id =?");
		
		try(var sentenciaPreparada=conexion.prepareStatement(sentenciaSQL.toString())){
			sentenciaPreparada.setObject(2, entity.getNombre());
			sentenciaPreparada.setObject(1, id);

			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de modificar la información del nuevo departamento";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla departamento. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información del nuevo departamento";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla departamento. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}

		
	}

	@Override
	public void delete(UUID id) throws TerraxsException {
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("DELETE FROM pais WHERE id = ? ");
		
		try(var sentenciaPreparada=conexion.prepareStatement(sentenciaSQL.toString())){
			sentenciaPreparada.setObject(1,id);
			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información del nuevo departamento";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla departamento. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información del nuevo departamento";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla departamento. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}

		
	}


	

}
