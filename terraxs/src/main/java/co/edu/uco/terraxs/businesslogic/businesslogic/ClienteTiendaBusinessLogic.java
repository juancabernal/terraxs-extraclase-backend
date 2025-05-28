package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ClienteTiendaDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface ClienteTiendaBusinessLogic {
	
		
	void crearClienteTienda(ClienteTiendaDomain clienteTienda) throws TerraxsException;
	
	LocalDate consultarFechaIngreso(UUID id) throws TerraxsException;
	
	List<ClienteTiendaDomain> consultarClientesTienda(ClienteTiendaDomain filtro) throws TerraxsException;

}
