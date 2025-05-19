package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.dto.ProveedorTiendaDTO;

public interface ProveedorTiendaFacade {
	
	ProveedorTiendaDTO consultarFechaIngreso(UUID id);
	

}

