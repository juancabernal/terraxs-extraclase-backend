package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ClienteTiendaDomain;

public interface ClienteTiendaBusinessLogic {
	
void crearClienteTienda(ClienteTiendaDomain clienteTienda);
	
	LocalDate consultarFechaIngreso(UUID id);
	
	List<ClienteTiendaDomain> consultarClientesTienda(ClienteTiendaDomain filtro);

}
