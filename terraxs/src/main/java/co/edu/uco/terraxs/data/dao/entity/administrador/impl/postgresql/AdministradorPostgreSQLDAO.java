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
import co.edu.uco.terraxs.entity.PaisEntity;

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
	public List<AdministradorEntity> listByFilter(AdministradorEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdministradorEntity> listALL() {
		final List<AdministradorEntity> administradores = new ArrayList<>();
		final String sentenciaSQL = "SELECT ad.id, td.tipo_documento_id, ad.numero_identificacion, ad.nombres, ad.apellidos, ad.correo,telefono, ad.correo_confirmado, ad.telefono_confirmado, ad.password FROM administrador ad JOIN tipo_documento td ON ad.tipo_documento_id = td.id";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
		     ResultSet resultado = sentenciaPreparada.executeQuery()) {

			while (resultado.next()) {
				var administrador = new AdministradorEntity();
				administrador.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
				administrador.setTipoDocumento(resultado.getString("tipo_documento_id"));
				administrador.setNumeroIdentificacion(resultado.getString("numero_identificacion"));
				administrador.setTipoDocumento(resultado.getTipoDocumento("tipo_documento_id"));
				administrador.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
				administrador.setTipoDocumento(resultado.getTipoDocumento("tipo_documento_id"));
				administrador.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
				administrador.setTipoDocumento(resultado.getTipoDocumento("tipo_documento_id"));
				administrador.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
				administrador.setTipoDocumento(resultado.getTipoDocumento("tipo_documento_id"));

				administradores.add(administrador);
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
	public AdministradorEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, AdministradorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
