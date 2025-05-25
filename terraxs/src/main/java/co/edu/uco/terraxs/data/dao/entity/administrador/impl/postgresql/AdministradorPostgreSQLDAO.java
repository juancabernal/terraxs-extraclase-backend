package co.edu.uco.terraxs.data.dao.entity.administrador.impl.postgresql;

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
import co.edu.uco.terraxs.data.dao.entity.administrador.AdministradorDAO;
import co.edu.uco.terraxs.entity.AdministradorEntity;
import co.edu.uco.terraxs.entity.TipoDocumentoEntity;

public class AdministradorPostgreSQLDAO implements AdministradorDAO {
	
	private Connection conexion;
	
	public AdministradorPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(AdministradorEntity entity) throws TerraxsException {
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("INSERT INTO administrador(id,tipo_documento_id,numero_identificacion,nombres,apellidos,correo,telefono,correo_confirmado,telefono_confirmado,password) VALUES (?,?,?,?,?,?,?,?,?,?)");
		
		try(var sentenciaPreparada=conexion.prepareStatement(sentenciaSQL.toString())){
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getTipoDocumento());
			sentenciaPreparada.setObject(3, entity.getNumeroIdentificacion());
			sentenciaPreparada.setObject(4, entity.getNombres());
			sentenciaPreparada.setObject(5, entity.getApellidos());
			sentenciaPreparada.setObject(6, entity.getCorreo());
			sentenciaPreparada.setObject(7, entity.getTelefono());
			sentenciaPreparada.setObject(8, entity.isCorreoConfirmado());
			sentenciaPreparada.setObject(9, entity.isTelefonoConfirmado());
			sentenciaPreparada.setObject(10, entity.getPassword());

			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {

    		var mensajeUsuario="Se ha presentado un problema tratando de registrar la información del nuevo administrador";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla administrador. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo administrador";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla administrador. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
		
		
	}

	@Override
	public List<AdministradorEntity> listByFilter(AdministradorEntity filter) throws TerraxsException {
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT ad.id, td.nombre, ad.numero_identificacion, ad.nombres, ad.apellidos, ad.correo, ad.telefono, ad.correo_confirmado, ad.telefono_confirmado ")
	                .append("FROM administrador ad ")
	                .append("JOIN tipo_documento td ON ad.tipo_documento_id = td.id ")
	                .append("WHERE 1=1 ");

	    final List<AdministradorEntity> administradores = new ArrayList<>();
	    final List<Object> parametros = new ArrayList<>();

	    if (filter != null) {
	        if (filter.getId() != null) {
	            sentenciaSQL.append(" AND ad.id = ?");
	            parametros.add(filter.getId());
	        }
	        if (filter.getTipoDocumento() != null && filter.getTipoDocumento().getId() != null) {
	            sentenciaSQL.append(" AND td.id = ?");
	            parametros.add(filter.getTipoDocumento().getId());
	        }
	        if (filter.getNumeroIdentificacion() != null && !filter.getNumeroIdentificacion().isBlank()) {
	            sentenciaSQL.append(" AND ad.numero_identificacion ILIKE ?");
	            parametros.add("%" + filter.getNumeroIdentificacion().trim() + "%");
	        }
	        if (filter.getNombres() != null && !filter.getNombres().isBlank()) {
	            sentenciaSQL.append(" AND ad.nombres ILIKE ?");
	            parametros.add("%" + filter.getNombres().trim() + "%");
	        }
	        if (filter.getApellidos() != null && !filter.getApellidos().isBlank()) {
	            sentenciaSQL.append(" AND ad.apellidos ILIKE ?");
	            parametros.add("%" + filter.getApellidos().trim() + "%");
	        }
	        if (filter.getCorreo() != null && !filter.getCorreo().isBlank()) {
	            sentenciaSQL.append(" AND ad.correo ILIKE ?");
	            parametros.add("%" + filter.getCorreo().trim() + "%");
	        }
	        if (filter.getTelefono() != null && !filter.getTelefono().isBlank()) {
	            sentenciaSQL.append(" AND ad.telefono ILIKE ?");
	            parametros.add("%" + filter.getTelefono().trim() + "%");
	        }
	    }

	    try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
	        for (int i = 0; i < parametros.size(); i++) {
	            sentenciaPreparada.setObject(i + 1, parametros.get(i));
	        }

	        try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
	            while (resultado.next()) {
	                var tipoDocumento = new TipoDocumentoEntity();
	                tipoDocumento.setId(UtilUUID.convertirAUUID(resultado.getString("tipo_documento_id")));
	                tipoDocumento.setNombre(resultado.getString("tipo_documento"));

	                var administrador = new AdministradorEntity();
	                administrador.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
	                administrador.setTipoDocumento(tipoDocumento);
	                administrador.setNumeroIdentificacion(resultado.getString("numero_identificacion"));
	                administrador.setNombres(resultado.getString("nombres"));
	                administrador.setApellidos(resultado.getString("apellidos"));
	                administrador.setCorreo(resultado.getString("correo"));
	                administrador.setTelefono(resultado.getString("telefono"));
	                administrador.setCorreoConfirmado(resultado.getBoolean("correo_confirmado"));
	                administrador.setTelefonoConfirmado(resultado.getBoolean("telefono_confirmado"));

	                administradores.add(administrador);
	            }
	        }
	    } catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar los administradores con los filtros deseados";
			var mensajeTecnico = "Se presentó una SQLException al consultar la tabla administrador. Verifique sintaxis o conexión.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar los administradores con los filtros deseados";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar administradores con filtros.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	    return administradores;
	}

	@Override
	public List<AdministradorEntity> listALL() throws TerraxsException {
		final List<AdministradorEntity> administradores = new ArrayList<>();
		final String sentenciaSQL = "SELECT ad.id, td.nombre, ad.numero_identificacion, ad.nombres, ad.apellidos, ad.correo, ad.telefono, ad.correo_confirmado, ad.telefono_confirmado, ad.password FROM administrador ad JOIN tipo_documento td ON ad.tipo_documento_id = td.id";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
		     ResultSet resultado = sentenciaPreparada.executeQuery()) {

			while (resultado.next()) {
	            var tipoDocumento = new TipoDocumentoEntity();
	            tipoDocumento.setId(UtilUUID.convertirAUUID(resultado.getString("tipo_documento_id")));
	            tipoDocumento.setNombre(resultado.getString("tipo_documento"));

	            var administrador = new AdministradorEntity();
	            administrador.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
	            administrador.setTipoDocumento(tipoDocumento);
	            administrador.setNumeroIdentificacion(resultado.getString("numero_identificacion"));
	            administrador.setNombres(resultado.getString("nombres"));
	            administrador.setApellidos(resultado.getString("apellidos"));
	            administrador.setCorreo(resultado.getString("correo"));
	            administrador.setTelefono(resultado.getString("telefono"));
	            administrador.setCorreoConfirmado(resultado.getBoolean("correo_confirmado"));
	            administrador.setTelefonoConfirmado(resultado.getBoolean("telefono_confirmado"));

	            administradores.add(administrador);
	        }
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar todos los administradores";
			var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT * en la tabla administrador. Revise la conexión o la estructura de la tabla.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar todos los administradores";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar todos los registros de la tabla administrador.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}

		return administradores;
	}

	@Override
	public AdministradorEntity listById(UUID id) throws TerraxsException {
	    var administradorEntityRetorno = new AdministradorEntity();
	    var sentenciaSQL = new StringBuilder();
	    sentenciaSQL.append("SELECT ad.id, ad.tipo_documento_id, td.nombre AS tipo_documento, ad.numero_identificacion, ad.nombres, ad.apellidos, ad.correo, ad.telefono, ad.correo_confirmado, ad.telefono_confirmado ")
	                .append("FROM administrador ad ")
	                .append("JOIN tipo_documento td ON ad.tipo_documento_id = td.id ")
	                .append("WHERE ad.id = ?");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
	        sentenciaPreparada.setObject(1, id);

	        try (var cursorResultados = sentenciaPreparada.executeQuery()) {
	            if (cursorResultados.next()) {
	                var tipoDocumento = new TipoDocumentoEntity();
	                tipoDocumento.setId(UtilUUID.convertirAUUID(cursorResultados.getString("tipo_documento_id")));
	                tipoDocumento.setNombre(cursorResultados.getString("tipo_documento"));

	                administradorEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
	                administradorEntityRetorno.setTipoDocumento(tipoDocumento);
	                administradorEntityRetorno.setNumeroIdentificacion(cursorResultados.getString("numero_identificacion"));
	                administradorEntityRetorno.setNombres(cursorResultados.getString("nombres"));
	                administradorEntityRetorno.setApellidos(cursorResultados.getString("apellidos"));
	                administradorEntityRetorno.setCorreo(cursorResultados.getString("correo"));
	                administradorEntityRetorno.setTelefono(cursorResultados.getString("telefono"));
	                administradorEntityRetorno.setCorreoConfirmado(cursorResultados.getBoolean("correo_confirmado"));
	                administradorEntityRetorno.setTelefonoConfirmado(cursorResultados.getBoolean("telefono_confirmado"));
	            }
	        }
	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información del administrador con el identificador deseado";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla administrador por id. Para tener más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del administrador con el identificador deseado";
	        var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla administrador por id. Para tener más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return administradorEntityRetorno;
	}
	
	
	@Override
	public void update(UUID id, AdministradorEntity entity) throws TerraxsException {
	    var sentenciaSQL = new StringBuilder();
	    sentenciaSQL.append("UPDATE administrador SET tipo_documento_id = ?, numero_identificacion = ?, nombres = ?, apellidos = ?, correo = ?, telefono = ?, correo_confirmado = ?, telefono_confirmado = ?, password = ? WHERE id = ?");
	        
	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
	        sentenciaPreparada.setObject(1, entity.getTipoDocumento().getId());
	        sentenciaPreparada.setObject(2, entity.getNumeroIdentificacion());
	        sentenciaPreparada.setObject(3, entity.getNombres());
	        sentenciaPreparada.setObject(4, entity.getApellidos());
	        sentenciaPreparada.setObject(5, entity.getCorreo());
	        sentenciaPreparada.setObject(6, entity.getTelefono());
	        sentenciaPreparada.setObject(7, entity.isCorreoConfirmado());
	        sentenciaPreparada.setObject(8, entity.isTelefonoConfirmado());
	        sentenciaPreparada.setObject(9, entity.getPassword());
	        sentenciaPreparada.setObject(10, id);

	        sentenciaPreparada.executeUpdate();
	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del administrador";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla administrador. Para más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información del administrador";
	        var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla administrador. Para más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }
	}

	@Override
	public void delete(UUID id) throws TerraxsException {
	    var sentenciaSQL = new StringBuilder();
	    sentenciaSQL.append("DELETE FROM administrador WHERE id = ?");
	        
	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
	        sentenciaPreparada.setObject(1, id);
	        sentenciaPreparada.executeUpdate();
	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del administrador";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla administrador. Para más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
         var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información del administrador";
	        var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla administrador. Para más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }
	}


}
