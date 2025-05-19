package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.MetodoPagoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.MetodoPagoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class MetodoPagoBusinessLogicImpl implements MetodoPagoBusinessLogic{
	private DAOFactory factory;

	public MetodoPagoBusinessLogicImpl( DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public MetodoPagoDomain consultarMetodoPagoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MetodoPagoDomain> consultarMetodosPago(MetodoPagoDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
