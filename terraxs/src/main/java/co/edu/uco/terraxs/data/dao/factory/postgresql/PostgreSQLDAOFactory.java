package co.edu.uco.terraxs.data.dao.factory.postgresql;


import java.sql.Connection;

import co.edu.uco.terraxs.data.dao.factory.DAOFactory;



public class PostgreSQLDAOFactory extends DAOFactory {
	
	private Connection conexion;
	
	public PostgreSQLDAOFactory() {
		abrirConexion();
	}
	
	
	


	@Override
	protected void abrirConexion() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cerrarConexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PaisPostgreSQLDAO(conexion);
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new DepartamentoPostgreSQLDAO(conexion);
	}

	@Override
	public PaisDAO getCiudadDAO() {
		return new CiudadPostgreSQLDAO(conexion);
	}

}