package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CanalDomain;

public interface CanalBusinessLogic {
	
	CanalDomain consultarCanalPorId(UUID id);
	
	List<CanalDomain> consultarCanales(CanalDomain filtro);

}

