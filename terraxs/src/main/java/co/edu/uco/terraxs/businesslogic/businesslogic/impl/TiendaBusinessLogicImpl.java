package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TiendaBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TiendaDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class TiendaBusinessLogicImpl implements TiendaBusinessLogic{
	
	private DAOFactory factory;
	
	public TiendaBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public void ingresarTienda(UsuarioDomain usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salirTienda(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TiendaDomain verInformacionTienda(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
