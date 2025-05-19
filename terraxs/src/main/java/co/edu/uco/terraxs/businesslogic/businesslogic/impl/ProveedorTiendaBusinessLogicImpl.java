package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProveedorTiendaBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorTiendaDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class ProveedorTiendaBusinessLogicImpl implements ProveedorTiendaBusinessLogic{

	private DAOFactory factory;
	
	public ProveedorTiendaBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}	

	@Override
	public ProveedorTiendaDomain consultarFechaIngreso(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}



}
