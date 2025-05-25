package co.edu.uco.terraxs.data.dao.entity.proveedor.impl.postgresql;

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
import co.edu.uco.terraxs.data.dao.entity.proveedor.ProveedorDAO;
import co.edu.uco.terraxs.entity.AdministradorEntity;
import co.edu.uco.terraxs.entity.CiudadEntity;
import co.edu.uco.terraxs.entity.DepartamentoEntity;
import co.edu.uco.terraxs.entity.PaisEntity;
import co.edu.uco.terraxs.entity.ProveedorEntity;
import co.edu.uco.terraxs.entity.TipoDocumentoEntity;

public class ProveedorPostgreSQLDAO implements ProveedorDAO{
	
	
	private Connection conexion;
	
	public ProveedorPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(ProveedorEntity entity) throws TerraxsException {
		var sentenciaSQL= new StringBuilder();
		sentenciaSQL.append("INSERT INTO proveedor(id,tipo_documento_id,numero_identificacion,nombres,apellidos,correo,telefono,correo_confirmado,telefono_confirmado, direccion_residencia, ciudad, password) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		
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
			sentenciaPreparada.setObject(10, entity.getDireccionResidencia());
			sentenciaPreparada.setObject(11, entity.getCiudad());
			sentenciaPreparada.setObject(12, entity.getPassword());

			
			sentenciaPreparada.executeUpdate();
		}catch(SQLException exception) {

    		var mensajeUsuario="Se ha presentado un problema tratando de registrar la información del nuevo proveedor";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla proveedor. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo proveedor";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla proveedor. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
		
		
	}

	@Override
	public List<ProveedorEntity> listByFilter(ProveedorEntity filter) throws TerraxsException{
		var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT pd.id, td.nombre, pd.numero_identificacion, pd.nombres, pd.apellidos, pd.correo, pd.telefono, pd.correo_confirmado, pd.telefono_confirmado, pd.direccion_residencia, c.nombre ")
	                .append("FROM proveedor pd ")
	                .append("JOIN tipo_documento td ON pd.tipo_documento_id = td.id")
	                .append("JOIN ciudad c ON pd.ciudad_id = c.id ")
	                .append("JOIN departamento d ON c.departamento_id = d.id ")
	                .append("JOIN pais p ON d.pais_id = p.id ")
	                .append("WHERE 1=1 ");

	    final List<ProveedorEntity> proveedores = new ArrayList<>();
	    final List<Object> parametros = new ArrayList<>();

	    if (filter != null) {
	        if (filter.getId() != null) {
	            sentenciaSQL.append(" AND pd.id = ?");
	            parametros.add(filter.getId());
	        }
	        if (filter.getTipoDocumento() != null && filter.getTipoDocumento().getId() != null) {
	            sentenciaSQL.append(" AND td.id = ?");
	            parametros.add(filter.getTipoDocumento().getId());
	        }
	        if (filter.getNumeroIdentificacion() != null && !filter.getNumeroIdentificacion().isBlank()) {
	            sentenciaSQL.append(" AND pd.numero_identificacion ILIKE ?");
	            parametros.add("%" + filter.getNumeroIdentificacion().trim() + "%");
	        }
	        if (filter.getNombres() != null && !filter.getNombres().isBlank()) {
	            sentenciaSQL.append(" AND pd.nombres ILIKE ?");
	            parametros.add("%" + filter.getNombres().trim() + "%");
	        }
	        if (filter.getApellidos() != null && !filter.getApellidos().isBlank()) {
	            sentenciaSQL.append(" AND pd.apellidos ILIKE ?");
	            parametros.add("%" + filter.getApellidos().trim() + "%");
	        }
	        if (filter.getCorreo() != null && !filter.getCorreo().isBlank()) {
	            sentenciaSQL.append(" AND pd.correo ILIKE ?");
	            parametros.add("%" + filter.getCorreo().trim() + "%");
	        }
	        if (filter.getTelefono() != null && !filter.getTelefono().isBlank()) {
	            sentenciaSQL.append(" AND pd.telefono ILIKE ?");
	            parametros.add("%" + filter.getTelefono().trim() + "%");
	        }
	        if (filter.getDireccionResidencia() != null && !filter.getDireccionResidencia().isBlank()) {
	            sentenciaSQL.append(" AND pd.apellidos ILIKE ?");
	            parametros.add("%" + filter.getDireccionResidencia().trim() + "%");
	        }
	        if (filter.getCiudad() != null && filter.getCiudad().getId() != null) {
	            sentenciaSQL.append(" AND c.id = ?");
	            parametros.add(filter.getCiudad().getId());
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
	                
	                var pais = new PaisEntity();
	                pais.setId(UtilUUID.convertirAUUID(resultado.getString("pais_id")));
	                pais.setNombre(resultado.getString("pais"));

	                var departamento = new DepartamentoEntity();
	                departamento.setId(UtilUUID.convertirAUUID(resultado.getString("departamento_id")));
	                departamento.setNombre(resultado.getString("departamento"));
	                departamento.setPais(pais);

	                var ciudad = new CiudadEntity();
	                ciudad.setId(UtilUUID.convertirAUUID(resultado.getString("ciudad_id")));
	                ciudad.setNombre(resultado.getString("ciudad"));
	                ciudad.setDepartamento(departamento);

	                var proveedor = new ProveedorEntity();
	                proveedor.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
	                proveedor.setTipoDocumento(tipoDocumento);
	                proveedor.setNumeroIdentificacion(resultado.getString("numero_identificacion"));
	                proveedor.setNombres(resultado.getString("nombres"));
	                proveedor.setApellidos(resultado.getString("apellidos"));
	                proveedor.setCorreo(resultado.getString("correo"));
	                proveedor.setTelefono(resultado.getString("telefono"));
	                proveedor.setCorreoConfirmado(resultado.getBoolean("correo_confirmado"));
	                proveedor.setTelefonoConfirmado(resultado.getBoolean("telefono_confirmado"));
	                proveedor.setDireccionResidencia(resultado.getString("direccion_residencia"));
	                proveedor.setCiudad(ciudad);

	                proveedores.add(proveedor);
	            }
	        }
	    } catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar los proveedores con los filtros deseados";
			var mensajeTecnico = "Se presentó una SQLException al consultar la tabla proveedor. Verifique sintaxis o conexión.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar los proveedores con los filtros deseados";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar proveedores con filtros.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	    return proveedores;

	}

	@Override
	public List<ProveedorEntity> listALL() throws TerraxsException {
		final List<ProveedorEntity> proveedores = new ArrayList<>();
		final String sentenciaSQL = "SELECT pd.id, td.nombre, pd.numero_identificacion, pd.nombres, pd.apellidos, pd.correo, pd.telefono, pd.correo_confirmado, pd.telefono_confirmado, pd.direccion_residencia, c.nombre FROM proveedor pd JOIN tipo_documento td ON pd.tipo_documento_id = td.id JOIN ciudad c ON pd.ciudad_id = c.id JOIN departamento d ON c.departamento_id = d.id JOIN pais p ON d.pais_id = p.id ";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
		     ResultSet resultado = sentenciaPreparada.executeQuery()) {

			while (resultado.next()) {
				var tipoDocumento = new TipoDocumentoEntity();
                tipoDocumento.setId(UtilUUID.convertirAUUID(resultado.getString("tipo_documento_id")));
                tipoDocumento.setNombre(resultado.getString("tipo_documento"));
                
                var pais = new PaisEntity();
                pais.setId(UtilUUID.convertirAUUID(resultado.getString("pais_id")));
                pais.setNombre(resultado.getString("pais"));

                var departamento = new DepartamentoEntity();
                departamento.setId(UtilUUID.convertirAUUID(resultado.getString("departamento_id")));
                departamento.setNombre(resultado.getString("departamento"));
                departamento.setPais(pais);

                var ciudad = new CiudadEntity();
                ciudad.setId(UtilUUID.convertirAUUID(resultado.getString("ciudad_id")));
                ciudad.setNombre(resultado.getString("ciudad"));
                ciudad.setDepartamento(departamento);

                var proveedor = new ProveedorEntity();
                proveedor.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                proveedor.setTipoDocumento(tipoDocumento);
                proveedor.setNumeroIdentificacion(resultado.getString("numero_identificacion"));
                proveedor.setNombres(resultado.getString("nombres"));
                proveedor.setApellidos(resultado.getString("apellidos"));
                proveedor.setCorreo(resultado.getString("correo"));
                proveedor.setTelefono(resultado.getString("telefono"));
                proveedor.setCorreoConfirmado(resultado.getBoolean("correo_confirmado"));
                proveedor.setTelefonoConfirmado(resultado.getBoolean("telefono_confirmado"));
                proveedor.setDireccionResidencia(resultado.getString("direccion_residencia"));
                proveedor.setCiudad(ciudad);

                proveedores.add(proveedor);

	        }
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar todos los proveedores";
			var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT * en la tabla proveedor. Revise la conexión o la estructura de la tabla.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar todos los proveedores";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception al consultar todos los registros de la tabla proveedor.";
			throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}

		return proveedores;
	}

	@Override
	public ProveedorEntity listById(UUID id) throws TerraxsException {
	    var proveedorEntityRetorno = new ProveedorEntity();
	    var sentenciaSQL = new StringBuilder();
	    sentenciaSQL.append("SELECT pd.id, td.nombre, pd.numero_identificacion, pd.nombres, pd.apellidos, pd.correo, pd.telefono, pd.correo_confirmado, pd.telefono_confirmado, pd.direccion_residencia, c.nombre ")
			        .append("FROM proveedor pd ")
			        .append("JOIN tipo_documento td ON pd.tipo_documento_id = td.id")
			        .append("JOIN ciudad c ON pd.ciudad_id = c.id ")
			        .append("JOIN departamento d ON c.departamento_id = d.id ")
			        .append("JOIN pais p ON d.pais_id = p.id ")
			        .append("WHERE 1=1 ")
	                .append("WHERE pd.id = ?");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
	        sentenciaPreparada.setObject(1, id);

	        try (var cursorResultados = sentenciaPreparada.executeQuery()) {
	            if (cursorResultados.next()) {
	               
	                var tipoDocumento = new TipoDocumentoEntity();
	                tipoDocumento.setId(UtilUUID.convertirAUUID(cursorResultados.getString("tipo_documento_id")));
	                tipoDocumento.setNombre(cursorResultados.getString("tipo_documento"));
	                
	                var pais = new PaisEntity();
	                pais.setId(UtilUUID.convertirAUUID(cursorResultados.getString("pais_id")));
	                pais.setNombre(cursorResultados.getString("pais"));

	                var departamento = new DepartamentoEntity();
	                departamento.setId(UtilUUID.convertirAUUID(cursorResultados.getString("departamento_id")));
	                departamento.setNombre(cursorResultados.getString("departamento"));
	                departamento.setPais(pais);

	                var ciudad = new CiudadEntity();
	                ciudad.setId(UtilUUID.convertirAUUID(cursorResultados.getString("ciudad_id")));
	                ciudad.setNombre(cursorResultados.getString("ciudad"));
	                ciudad.setDepartamento(departamento);

	                proveedorEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
	                proveedorEntityRetorno.setTipoDocumento(tipoDocumento);
	                proveedorEntityRetorno.setNumeroIdentificacion(cursorResultados.getString("numero_identificacion"));
	                proveedorEntityRetorno.setNombres(cursorResultados.getString("nombres"));
	                proveedorEntityRetorno.setApellidos(cursorResultados.getString("apellidos"));
	                proveedorEntityRetorno.setCorreo(cursorResultados.getString("correo"));
	                proveedorEntityRetorno.setTelefono(cursorResultados.getString("telefono"));
	                proveedorEntityRetorno.setCorreoConfirmado(cursorResultados.getBoolean("correo_confirmado"));
	                proveedorEntityRetorno.setTelefonoConfirmado(cursorResultados.getBoolean("telefono_confirmado"));
	                proveedorEntityRetorno.setDireccionResidencia(cursorResultados.getString("direccion_residencia"));
	                proveedorEntityRetorno.setCiudad(ciudad);
	            }
	        }
	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información del proveedor con el identificador deseado";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla proveedor por id. Para tener más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del proveedor con el identificador deseado";
	        var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla proveedor por id. Para tener más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return proveedorEntityRetorno;
	}

	@Override
	public void update(UUID id, ProveedorEntity entity) throws TerraxsException {
		
		var sentenciaSQL = new StringBuilder();
	    sentenciaSQL.append("UPDATE proveedor SET tipo_documento_id = ?, numero_identificacion = ?, nombres = ?, apellidos = ?, correo = ?, telefono = ?, correo_confirmado = ?, telefono_confirmado = ?, direccion_residencia = ?, ciudad = ? password = ? WHERE id = ?");
	        
	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
	        sentenciaPreparada.setObject(1, entity.getTipoDocumento().getId());
	        sentenciaPreparada.setObject(2, entity.getNumeroIdentificacion());
	        sentenciaPreparada.setObject(3, entity.getNombres());
	        sentenciaPreparada.setObject(4, entity.getApellidos());
	        sentenciaPreparada.setObject(5, entity.getCorreo());
	        sentenciaPreparada.setObject(6, entity.getTelefono());
	        sentenciaPreparada.setObject(7, entity.isCorreoConfirmado());
	        sentenciaPreparada.setObject(8, entity.isTelefonoConfirmado());
	        sentenciaPreparada.setObject(9, entity.getDireccionResidencia());
	        sentenciaPreparada.setObject(10, entity.getPassword());
	        sentenciaPreparada.setObject(11, id);

	        sentenciaPreparada.executeUpdate();
	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del proveedor";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla proveedor. Para más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información del proveedor";
	        var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla proveedor. Para más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	}

	@Override
	public void delete(UUID id) throws TerraxsException {
		var sentenciaSQL = new StringBuilder();
	    sentenciaSQL.append("DELETE FROM proveedor WHERE id = ?");
	        
	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
	        sentenciaPreparada.setObject(1, id);
	        sentenciaPreparada.executeUpdate();
	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del proveedor";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla proveedor. Para más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
         var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información del proveedor";
	        var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla proveedor. Para más detalles revise el log de errores.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }
	}

}
