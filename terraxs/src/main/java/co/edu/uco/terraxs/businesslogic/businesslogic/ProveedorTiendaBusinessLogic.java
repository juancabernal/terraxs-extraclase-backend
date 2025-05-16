package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorTiendaDomain;

public interface ProveedorTiendaBusinessLogic {
	
	ProveedorTiendaDomain consultarFechaIngreso(UUID id);
	

}

