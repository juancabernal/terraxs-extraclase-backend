package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.TipoNotificacionDTO;

public interface TipoNotificacionFacade {
	
	TipoNotificacionDTO consultarTipoNotificacionPorId(UUID id) throws TerraxsException;
	
	List<TipoNotificacionDTO> consultarTiposNotificacion(TipoNotificacionDTO filtro) throws TerraxsException;

}

