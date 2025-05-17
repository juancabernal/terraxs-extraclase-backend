package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoNotificacionDomain;

public interface TipoNotificacionBusinessLogic {
	
	TipoNotificacionDomain consultarTipoNotificacionPorId(UUID id);
	
	List<TipoNotificacionDomain> consultarTiposNotificacion(TipoNotificacionDomain filtro);

}

