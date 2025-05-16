package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TiendaDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UsuarioDomain;

public interface TiendaBusinessLogic {
	
	void ingresarTienda(UsuarioDomain usuario);
	
	
	void salirTienda(UUID id);
	
	TiendaDomain verInformacionTienda(UUID id);
	
	

}

