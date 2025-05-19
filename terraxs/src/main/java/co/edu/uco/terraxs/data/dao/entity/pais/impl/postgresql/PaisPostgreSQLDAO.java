package co.edu.uco.terraxs.data.dao.entity.pais.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.pais.PaisDAO;
import co.edu.uco.terraxs.entity.PaisEntity;

public class PaisPostgreSQLDAO implements PaisDAO {
	
	
	private Connection conexion;
	
	public PaisPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(PaisEntity entity) throws TerraxsException {
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("INSERT INTO Pais(id,nombre) VALUES (?,?)");
		
		try(var sentenciaPreparada=conexion.prepareStatement(sentenciaSQL.toString())){
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getNombre());
			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de registrar un pais .";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un insert en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema inesperado  tratando de registrar un pais .";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de iniciar la transacción sobre la conexión con la base de datos. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
		
		
		
	}

	@Override
	public List<PaisEntity> listByFilter(PaisEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisEntity> listALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisEntity listById(UUID id) throws TerraxsException {
		
		var paisEntityRetorno=new PaisEntity();
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("SELECT id,nombre FROM Pais WHERE id=?");
		
		try(var sentenciaPreparada=conexion.prepareStatement(sentenciaSQL.toString())){
			sentenciaPreparada.setObject(1,id);
			try(var cursorResultados=sentenciaPreparada.executeQuery()){
				
				if(cursorResultados.next()) {
					paisEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					paisEntityRetorno.setNombre(cursorResultados.getString("nombre"));
					
				}
			}
			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema inesperado  tratando de realizar una busqueda dentro la tabla pais.";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema inesperado  tratando de realizar una busqueda dentro la tabla pais.";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
		return paisEntityRetorno;
		
		
		

	}

	@Override
	public void update(UUID id, PaisEntity entity) throws TerraxsException {
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("UPDATE Pais SET nombre = ? WHERE id =?");
		
		try(var sentenciaPreparada=conexion.prepareStatement(sentenciaSQL.toString())){
			sentenciaPreparada.setObject(2, entity.getNombre());
			sentenciaPreparada.setObject(1, id);

			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de actualizar un pais .";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO  tratando de actualizar un pais .";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de realizar un UPDATE en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}

		
	}

	@Override
	public void delete(UUID id) throws TerraxsException {
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("DELETE FROM Pais WHERE id = ? ");
		
		try(var sentenciaPreparada=conexion.prepareStatement(sentenciaSQL.toString())){
			sentenciaPreparada.setObject(1,id);
			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de eliminar un pais .";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema inesperado  tratando de eliminar un pais .";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla pais en la base de datos. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}

		
		
	}
	
	

}