package co.edu.uco.terraxs.businesslogic.facade;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.ClienteTiendaDTO;

public interface ClienteTiendaFacade {

	LocalDate consultarFechaIngreso(UUID id);
	
	List<ClienteTiendaDTO> consultarClientesTienda(ClienteTiendaDTO filtro);
	
}
