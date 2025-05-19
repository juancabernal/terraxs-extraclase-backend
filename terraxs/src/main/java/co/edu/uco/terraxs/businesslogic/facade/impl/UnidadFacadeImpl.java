package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.UnidadBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.UnidadBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.UnidadFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.UnidadDTO;

public class UnidadFacadeImpl implements UnidadFacade{
	
	private DAOFactory daoFactory;
	private UnidadBusinessLogic unidadBusinessLogic;
	
	
	public UnidadFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		unidadBusinessLogic = new UnidadBusinessLogicImpl(daoFactory);
	}


	@Override
	public UnidadDTO consultarUnidadPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UnidadDTO> consultarUnidades(UnidadDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}



}
