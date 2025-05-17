package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UnidadDomain;

public interface UnidadBusinessLogic {
	
	UnidadDomain consultarUnidadPorId(UUID id);
	
	List<UnidadDomain> consultarUnidades(UnidadDomain filtro);

}
