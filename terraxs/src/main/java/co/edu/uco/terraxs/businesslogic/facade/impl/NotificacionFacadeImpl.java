package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.NotificacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.NotificacionBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.NotificacionFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.NotificacionDTO;

public class NotificacionFacadeImpl implements NotificacionFacade{
	
	private DAOFactory daoFactory;
	private NotificacionBusinessLogic notificacionBusinessLogic;
	
	
	public NotificacionFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		notificacionBusinessLogic = new NotificacionBusinessLogicImpl(daoFactory);
	}


	@Override
	public void crearNotificacion(NotificacionDTO notificacion) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void enviarNotificacion(UUID id, NotificacionDTO notificacion) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}

}
