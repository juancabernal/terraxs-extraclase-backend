package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CanalNotificacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.CanalNotificacionBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.CanalNotificacionFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CanalNotificacionDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;


public class CanalNotificacionFacadeImpl implements CanalNotificacionFacade{
	
	private DAOFactory daoFactory;
	private CanalNotificacionBusinessLogic canalNotificacionBusinessLogic;
	
	
	public CanalNotificacionFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		canalNotificacionBusinessLogic = new CanalNotificacionBusinessLogicImpl(daoFactory);
	}

	@Override
	public void crearNotificacionPorCanal(CanalNotificacionDTO canalNotificaion) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public CanalNotificacionDTO consultarCanalNotificacionPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CanalNotificacionDTO> consultarCanalesNotificacion(CanalNotificacionDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

}
