package co.edu.uco.terraxs.data.dao.factory.azuresql;


import java.sql.Connection;



public class AzureSQLDAOFactory extends DAOFactory {
	
	private Connection conexion;
	
	public AzureSQLDAOFactory() {
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
		return new PaisAzureSQLDAO(conexion);
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new DepartamentoAzureSQLDAO(conexion);
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		return new CiudadAzureSQLDAO(conexion);
	}

}