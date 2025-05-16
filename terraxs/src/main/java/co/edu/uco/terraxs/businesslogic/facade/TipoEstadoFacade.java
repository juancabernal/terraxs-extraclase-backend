package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.TipoEstadoDTO;

public interface TipoEstadoFacade {
	
	TipoEstadoDTO consultarTipoEstadoPorId(UUID id);
	
	List<TipoEstadoDTO> consultarEstados(TipoEstadoDTO filtro);

}
