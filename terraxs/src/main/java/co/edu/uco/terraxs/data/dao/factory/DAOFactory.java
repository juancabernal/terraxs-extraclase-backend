package co.edu.uco.terraxs.data.dao.factory;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.terraxs.data.dao.entity.estado.EstadoDAO;
import co.edu.uco.terraxs.data.dao.entity.notificacion.NotificacionDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.PaisDAO;
import co.edu.uco.terraxs.data.dao.entity.proveedor.ProveedorDAO;
import co.edu.uco.terraxs.data.dao.entity.tipodocumento.TipoDocumentoDAO;
import co.edu.uco.terraxs.data.dao.entity.tipoestado.TipoEstadoDAO;
import co.edu.uco.terraxs.data.dao.entity.tiponotificacion.TipoNotificacionDAO;
import co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.TokenConfirmacionDAO;
import co.edu.uco.terraxs.data.dao.factory.postgresql.PostgreSQLDAOFactory;


public abstract class DAOFactory {
	
	public static DAOFactory getFactory(Factory factory) throws TerraxsException {
		switch (factory) {
		case POSTGRE_SQL: {
			return new PostgreSQLDAOFactory();
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + factory);
		}
	}
	
	
	protected abstract void abrirConexion() throws TerraxsException;
	
	public abstract void iniciarTransaccion() throws TerraxsException;
	
	public abstract void confirmarTransaccion() throws TerraxsException;
	
	public abstract void cancelarTransaccion() throws TerraxsException;
	
	public abstract void cerrarConexion() throws TerraxsException;

	public abstract PaisDAO getPaisDAO() throws TerraxsException;
	
	public abstract DepartamentoDAO getDepartamentoDAO() throws TerraxsException;
	
	public abstract CiudadDAO getCiudadDAO() throws TerraxsException;

	public abstract ProveedorDAO getProveedorDAO() throws TerraxsException;
	
	public abstract TokenConfirmacionDAO getTokenConfirmacionDAO() throws TerraxsException;
	
	public abstract EstadoDAO getEstadoDAO() throws TerraxsException;

	public abstract TipoEstadoDAO getTipoEstadoDAO() throws TerraxsException;
	
	public abstract NotificacionDAO getNotificacionDAO() throws TerraxsException;
	
	public abstract TipoNotificacionDAO getTipoNotificacionDAO() throws TerraxsException;
	
	public abstract TipoDocumentoDAO getTipoDocumentoDAO() throws TerraxsException;


}
