package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.EstadoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.EstadoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.EstadoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class EstadoFacadeImpl implements EstadoFacade{
	
	private DAOFactory daoFactory;
	private EstadoBusinessLogic estadoBusinessLogic;
	
	
	public EstadoFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		estadoBusinessLogic = new EstadoBusinessLogicImpl(daoFactory);
	}

	@Override
	public EstadoDTO consultarEstadoPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadoDTO> consultarEstados(EstadoDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

}
