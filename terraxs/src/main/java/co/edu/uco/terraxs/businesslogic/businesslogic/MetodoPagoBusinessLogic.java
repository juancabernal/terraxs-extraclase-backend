package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.MetodoPagoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UnidadDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface MetodoPagoBusinessLogic {
	
	MetodoPagoDomain consultarMetodoPagoPorId(UUID id) throws TerraxsException;
	
	List<MetodoPagoDomain> consultarMetodosPago(MetodoPagoDomain filtro) throws TerraxsException;

}
