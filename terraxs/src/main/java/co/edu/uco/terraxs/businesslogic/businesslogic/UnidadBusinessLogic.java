package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UnidadDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface UnidadBusinessLogic {
	
	UnidadDomain consultarUnidadPorId(UUID id) throws TerraxsException;
	
	List<UnidadDomain> consultarUnidades(UnidadDomain filtro) throws TerraxsException;

}
