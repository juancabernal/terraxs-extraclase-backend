package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.EstadoDTO;

public interface EstadoFacade {
	
	EstadoDTO consultarEstadoPorId(UUID id);
	
	List<EstadoDTO> consultarEstados(EstadoDTO filtro);

}
