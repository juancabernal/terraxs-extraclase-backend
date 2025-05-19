package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.NotificacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class NotificacionBusinessLogicImpl implements NotificacionBusinessLogic{
	private DAOFactory factory;
	
	public NotificacionBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public void crearNotificacion(NotificacionDomain notificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enviarNotificacion(UUID id, NotificacionDomain notificacion) {
		// TODO Auto-generated method stub
		
	}



	
}
