package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.MetodoPagoDTO;

public interface MetodoPagoFacade {
	
	MetodoPagoDTO consultarMetodoPagoPorId(UUID id) throws TerraxsException;
	
	List<MetodoPagoDTO> consultarMetodosPago(MetodoPagoDTO filtro) throws TerraxsException;

}
