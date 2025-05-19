package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface NotificacionBusinessLogic {
	
	void crearNotificacion(NotificacionDomain notificacion) throws TerraxsException;
	
	void enviarNotificacion(UUID id, NotificacionDomain notificacion) throws TerraxsException;
	

}
