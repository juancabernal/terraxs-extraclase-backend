package co.edu.co.onlinetest.data.dao.factory.azuresql;


import java.sql.Connection;

import co.edu.co.onlinetest.data.dao.entity.ciudad.CiudadDAO;
import co.edu.co.onlinetest.data.dao.entity.ciudad.impl.azuresql.CiudadAzureSQLDAO;
import co.edu.co.onlinetest.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.co.onlinetest.data.dao.entity.departamento.impl.azuresql.DepartamentoAzureSQLDAO;
import co.edu.co.onlinetest.data.dao.entity.pais.PaisDAO;
import co.edu.co.onlinetest.data.dao.entity.pais.impl.azuresql.PaisAzureSQLDAO;
import co.edu.co.onlinetest.data.dao.factory.DAOFactory;

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
