package co.edu.uco.terraxs.data.dao.entity.pais.impl.postgresql;

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

    		var mensajeUsuario="Se ha presentado un problema tratando de registrar la información del nuevo país";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo país";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
		
		
		
	}
	
	@Override
	public List<PaisEntity> listByFilter(final PaisEntity filter) throws TerraxsException {
			
			var sentenciaSQL = new StringBuilder();
			
			sentenciaSQL.append("SELECT id, nombre FROM pais WHERE 1=1");
			
			final List<PaisEntity> paises = new ArrayList<>();
			final List<Object> parametros = new ArrayList<>();

			if (filter != null) {
				if (filter.getId() != null) {
					sentenciaSQL.append(" AND id = ?");
					parametros.add(filter.getId());
				}
				if (filter.getNombre() != null && !filter.getNombre().isBlank()) {
					sentenciaSQL.append(" AND nombre ILIKE ?");
					parametros.add("%" + filter.getNombre().trim() + "%");
				}
			}

			try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
				for (int i = 0; i < parametros.size(); i++) {
					sentenciaPreparada.setObject(i + 1, parametros.get(i));
				}

				try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
					while (resultado.next()) {
						var pais = new PaisEntity();
						pais.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
						pais.setNombre(resultado.getString("nombre"));
						paises.add(pais);
					}
				}
			} catch (SQLException exception) {
				var mensajeUsuario = "Se ha presentado un problema tratando de consultar los países con los filtros deseados";
				var mensajeTecnico = "Se presentó una SQLException al consultar la tabla pais usando filtros. Revise la sintaxis SQL o los parámetros.";
				throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
			} catch (Exception exception) {
				var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar los países con los filtros deseados";
				var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar la tabla pais usando filtros.";
				throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
			}

			return paises;

			
		}



	
	public List<PaisEntity> listALL() throws TerraxsException {
		
		final List<PaisEntity> paises = new ArrayList<>();
		final String sentenciaSQL = "SELECT id, nombre FROM pais";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
		     ResultSet resultado = sentenciaPreparada.executeQuery()) {

			while (resultado.next()) {
				var pais = new PaisEntity();
				pais.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
				pais.setNombre(resultado.getString("nombre"));
				paises.add(pais);
			}
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar todos los países";
			var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT * en la tabla pais. Revise la conexión o la estructura de la tabla.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar todos los países";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar todos los registros de la tabla pais.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}

		return paises;
		
		
		
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
    		var mensajeUsuario="Se ha presentado un problema tratando de consultar la información del país con el identificador deseado";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla pais por id. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información del país con el identificador deseado";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla pais por id. Para tener más detalles revise el log de errores.";
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
    		var mensajeUsuario="Se ha presentado un problema tratando de modificar la información del nuevo país";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información del nuevo país";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla pais. Para tener más detalles revise el log de errores.";
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
    		var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información del nuevo país";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información del nuevo país";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla pais. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}

		
		
	}
	
	

}