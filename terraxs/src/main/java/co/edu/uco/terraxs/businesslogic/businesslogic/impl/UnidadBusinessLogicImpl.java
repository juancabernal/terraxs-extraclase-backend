package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.UnidadBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UnidadDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class UnidadBusinessLogicImpl implements UnidadBusinessLogic{
	
	
	private DAOFactory factory;
	
	public UnidadBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}
	@Override
	public UnidadDomain consultarUnidadPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UnidadDomain> consultarUnidades(UnidadDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}


}
