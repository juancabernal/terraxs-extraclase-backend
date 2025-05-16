package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.EstadoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class EstadoBusinessLogicImpl implements EstadoBusinessLogic{
	
	private DAOFactory factory;
	
	public EstadoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public EstadoDomain consultarEstadoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadoDomain> consultarEstados(EstadoDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
