package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.NotificacionDomain;

public interface NotificacionBusinessLogic {
	
	void crearNotificacion(NotificacionDomain notificacion);
	
	void enviarNotificacion(UUID id, NotificacionDomain notificacion);
	

}
