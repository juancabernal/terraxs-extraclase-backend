package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CanalDTO;

public interface CanalFacade {

	CanalDTO consultarCanalPorId(UUID id) throws TerraxsException;
	
	List<CanalDTO> consultarCanales(CanalDTO filtro) throws TerraxsException;
	
}
