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
		sentenciaSQL.append("INSERT INTO proveedor(id,tipo_documento_id,numero_identificacion,nombres,apellidos,correo,telefono,correo_confirmado,telefono_confirmado, ciudad, password) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		
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
			sentenciaPreparada.setObject(10, entity.getCiudad());
			sentenciaPreparada.setObject(11, entity.getPassword());

			
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

	    sentenciaSQL.append("SELECT pd.id, td.nombre, pd.numero_identificacion, pd.nombres, pd.apellidos, pd.correo, pd.telefono, pd.correo_confirmado, pd.telefono_confirmado, c.nombre ")
	                .append("FROM proveedor pd ")
	                .append("JOIN tipo_documento td ON pd.tipo_documento_id = td.id ")
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
	public List<ProveedorEntity> listALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProveedorEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, ProveedorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
