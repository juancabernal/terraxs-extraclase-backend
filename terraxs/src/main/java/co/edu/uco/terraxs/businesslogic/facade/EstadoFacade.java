package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.EstadoDTO;

public interface EstadoFacade {
	
	EstadoDTO consultarEstadoPorId(UUID id) throws TerraxsException;
	
	List<EstadoDTO> consultarEstados(EstadoDTO filtro) throws TerraxsException;

}
