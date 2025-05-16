package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.CanalDTO;

public interface CanalFacade {

	CanalDTO consultarCanalPorId(UUID id);
	
	List<CanalDTO> consultarCanales(CanalDTO filtro);
	
}
