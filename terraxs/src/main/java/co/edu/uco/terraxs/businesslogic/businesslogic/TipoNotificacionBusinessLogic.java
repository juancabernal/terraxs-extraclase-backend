package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface TipoNotificacionBusinessLogic {
	
	TipoNotificacionDomain consultarTipoNotificacionPorId(UUID id) throws TerraxsException;
	
	List<TipoNotificacionDomain> consultarTiposNotificacion(TipoNotificacionDomain filtro) throws TerraxsException;

}

