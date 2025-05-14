package co.edu.uco.terraxs.data.dao.factory;

import co.edu.uco.terraxs.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.PaisDAO;
import co.edu.uco.terraxs.data.dao.factory.postgresql.PostgreSQLDAOFactory;

public abstract class DAOFactory {
	
	public static DAOFactory getFactory(Factory factory) {
		switch (factory) {
		case POSTGRE_SQL: {
			return new PostgreSQLDAOFactory();
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + factory);
		}
	}
	
	
	protected abstract void abrirConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion();
	
	public abstract void cerrarConexion();

	public abstract PaisDAO getPaisDAO();
	
	public abstract DepartamentoDAO getDepartamentoDAO();
	
	public abstract CiudadDAO getCiudadDAO();


	

}
