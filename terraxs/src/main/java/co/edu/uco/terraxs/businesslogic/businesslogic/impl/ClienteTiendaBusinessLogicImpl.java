package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ClienteTiendaBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ClienteTiendaDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class ClienteTiendaBusinessLogicImpl implements ClienteTiendaBusinessLogic {
	
	private DAOFactory factory;
	
	public ClienteTiendaBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void crearClienteTienda(ClienteTiendaDomain clienteTienda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LocalDate consultarFechaIngreso(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteTiendaDomain> consultarClientesTienda(ClienteTiendaDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
