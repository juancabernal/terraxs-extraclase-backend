package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.MetodoPagoDTO;

public interface MetodoPagoFacade {
	
	MetodoPagoDTO consultarMetodoPagoPorId(UUID id);
	
	List<MetodoPagoDTO> consultarMetodosPago(MetodoPagoDTO filtro);

}
