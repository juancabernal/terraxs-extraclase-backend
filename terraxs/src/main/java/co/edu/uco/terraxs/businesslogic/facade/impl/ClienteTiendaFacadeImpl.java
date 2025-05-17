package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ClienteTiendaBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.ClienteTiendaBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.ClienteTiendaFacade;
import co.edu.uco.terraxs.dto.ClienteTiendaDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class ClienteTiendaFacadeImpl implements ClienteTiendaFacade {
	
	private DAOFactory daoFactory;
	private ClienteTiendaBusinessLogic clienteTiendaBusinessLogic;
	
	
	public ClienteTiendaFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		clienteTiendaBusinessLogic = new ClienteTiendaBusinessLogicImpl(daoFactory);
	}

	@Override
	public LocalDate consultarFechaIngreso(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteTiendaDTO> consultarClientesTienda(ClienteTiendaDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
