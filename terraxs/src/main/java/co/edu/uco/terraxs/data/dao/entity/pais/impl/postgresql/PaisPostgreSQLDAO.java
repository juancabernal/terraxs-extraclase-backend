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
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
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
		var sentenciaSQL = new StringBuilder();

		sentenciaSQL.append("INSERT INTO pais (id, nombre) VALUES (?,?)");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getNombre());

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
			
		final List<PaisEntity> listaResultados = new ArrayList<>();
	    final StringBuilder sentenciaSQL = new StringBuilder();
	    final List<Object> parametros = new ArrayList<>();

	    sentenciaSQL.append("SELECT id, nombre FROM pais WHERE 1=1");

	    if (!UtilUUID.esValorDefecto(filter.getId())) {
	        sentenciaSQL.append(" AND id = ?");
	        parametros.add(filter.getId());
	    }

	    if (!UtilTexto.getInstance().estaVacia(filter.getNombre())) {
	        sentenciaSQL.append(" AND LOWER(nombre) LIKE LOWER(?)");
	        parametros.add("%" + UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(filter.getNombre()) + "%");
	    }

	    sentenciaSQL.append(" ORDER BY nombre ASC");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

	        for (int i = 0; i < parametros.size(); i++) {
	            sentenciaPreparada.setObject(i + 1, parametros.get(i));
	        }

	        try (var cursorResultados = sentenciaPreparada.executeQuery()) {
	            while (cursorResultados.next()) {
	                var paisEntityRetorno = new PaisEntity();
	                paisEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
	                paisEntityRetorno.setNombre(cursorResultados.getString("nombre"));
	                listaResultados.add(paisEntityRetorno);
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

			return listaResultados;

			
		}



	
	public List<PaisEntity> listALL() throws TerraxsException {
		
		var listaResultados = new ArrayList<PaisEntity>();
		var sentenciaSQL = new StringBuilder();
		sentenciaSQL.append("SELECT id, nombre FROM pais ORDER BY nombre ASC");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

			try (var cursorResultados = sentenciaPreparada.executeQuery()) {

				while (cursorResultados.next()) {

					var paisEntityRetorno = new PaisEntity();

					paisEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					paisEntityRetorno.setNombre(cursorResultados.getString("nombre"));

					listaResultados.add(paisEntityRetorno);

				}

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

		return listaResultados;
		
		
		
	}
		

	@Override
	public PaisEntity listById(UUID id) throws TerraxsException {
		
		var paisEntityRetorno = new PaisEntity();
		var sentenciaSQL = new StringBuilder();

		sentenciaSQL.append("SELECT id, nombre FROM pais WHERE id = ?");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

			sentenciaPreparada.setObject(1, id.toString());

			try (var cursorResultados = sentenciaPreparada.executeQuery()) {

				if (cursorResultados.next()) {
					paisEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					paisEntityRetorno.setNombre(cursorResultados.getString("nombre"));
				}

			}
			
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
		var sentenciaSQL = new StringBuilder();

		sentenciaSQL.append("UPDATE pais SET nombre = ? WHERE id = ?");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setObject(2, id.toString());

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
		var sentenciaSQL = new StringBuilder();

		sentenciaSQL.append("DELETE FROM pais WHERE id = ?");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, id.toString());

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