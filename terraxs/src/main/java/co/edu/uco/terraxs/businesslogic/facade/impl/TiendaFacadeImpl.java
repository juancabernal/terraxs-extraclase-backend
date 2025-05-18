package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TiendaBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.TiendaBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.CanalFacade;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.CanalDTO;

public class TiendaFacadeImpl implements CanalFacade{
	
	private DAOFactory daoFactory;
	private TiendaBusinessLogic tiendaBusinessLogic;
	
	
	public TiendaFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		tiendaBusinessLogic = new TiendaBusinessLogicImpl(daoFactory);
	}




	@Override
	public CanalDTO consultarCanalPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CanalDTO> consultarCanales(CanalDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}
}