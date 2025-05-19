package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.dto.NotificacionDTO;

public interface NotificacionFacade {
	
	void crearNotificacion(NotificacionDTO notificacion);
	
	void enviarNotificacion(UUID id, NotificacionDTO notificacion);
	

}
