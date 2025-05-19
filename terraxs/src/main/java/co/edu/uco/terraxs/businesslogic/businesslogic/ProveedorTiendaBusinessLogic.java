package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorTiendaDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface ProveedorTiendaBusinessLogic {
	
	ProveedorTiendaDomain consultarFechaIngreso(UUID id) throws TerraxsException;
	

}

