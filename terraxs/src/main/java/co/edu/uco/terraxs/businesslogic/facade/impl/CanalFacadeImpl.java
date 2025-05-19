package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CanalBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.CanalBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.CanalFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CanalDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class CanalFacadeImpl implements CanalFacade{
	
	private DAOFactory daoFactory;
	private CanalBusinessLogic canalBusinessLogic;
	
	
	public CanalFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		canalBusinessLogic = new CanalBusinessLogicImpl(daoFactory);
	}

	@Override
	public CanalDTO consultarCanalPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CanalDTO> consultarCanales(CanalDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

}
