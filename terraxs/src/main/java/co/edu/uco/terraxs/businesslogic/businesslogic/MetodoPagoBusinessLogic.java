package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.MetodoPagoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UnidadDomain;

public interface MetodoPagoBusinessLogic {
	
	MetodoPagoDomain consultarMetodoPagoPorId(UUID id);
	
	List<MetodoPagoDomain> consultarMetodosPago(MetodoPagoDomain filtro);

}
