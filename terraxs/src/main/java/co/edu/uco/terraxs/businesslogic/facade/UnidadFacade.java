package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UnidadDomain;
import co.edu.uco.terraxs.dto.UnidadDTO;

public interface UnidadFacade {
	
	UnidadDTO consultarUnidadPorId(UUID id);
	
	List<UnidadDTO> consultarUnidades(UnidadDTO filtro);

}
