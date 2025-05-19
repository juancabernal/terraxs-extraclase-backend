package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CanalDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface CanalBusinessLogic {
	
	CanalDomain consultarCanalPorId(UUID id) throws TerraxsException;
	
	List<CanalDomain> consultarCanales(CanalDomain filtro) throws TerraxsException;

}

