package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TipoEstadoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoEstadoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class TipoEstadoBusinessLogicImpl implements TipoEstadoBusinessLogic{
	
	private DAOFactory factory;
	
	public TipoEstadoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public TipoEstadoDomain consultarTipoEstadoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoEstadoDomain> consultarEstados(TipoEstadoDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
