package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CanalBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CanalDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class CanalBusinessLogicImpl implements CanalBusinessLogic{
	
	private DAOFactory factory;
	
	public CanalBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public CanalDomain consultarCanalPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CanalDomain> consultarCanales(CanalDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
