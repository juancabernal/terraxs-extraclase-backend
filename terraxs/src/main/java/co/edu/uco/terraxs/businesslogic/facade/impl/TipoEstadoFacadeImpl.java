package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TipoEstadoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.TipoEstadoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.TipoEstadoFacade;
import co.edu.uco.terraxs.dto.TipoEstadoDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class TipoEstadoFacadeImpl implements TipoEstadoFacade{
	
	private DAOFactory daoFactory;
	private TipoEstadoBusinessLogic tipoEstadoBusinessLogic;
	
	
	public TipoEstadoFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		tipoEstadoBusinessLogic = new TipoEstadoBusinessLogicImpl(daoFactory);
	}

	@Override
	public TipoEstadoDTO consultarTipoEstadoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoEstadoDTO> consultarEstados(TipoEstadoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
