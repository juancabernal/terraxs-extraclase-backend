package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProveedorTiendaBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.ProveedorTiendaBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.ProveedorTiendaFacade;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.ProveedorTiendaDTO;

public class ProveedorTiendaFacadeImpl implements ProveedorTiendaFacade{
	
	private DAOFactory daoFactory;
	private ProveedorTiendaBusinessLogic proveedorTiendaBusinessLogic;
	
	
	public ProveedorTiendaFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		proveedorTiendaBusinessLogic = new ProveedorTiendaBusinessLogicImpl(daoFactory);
	}


	@Override
	public ProveedorTiendaDTO consultarFechaIngreso(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
