package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.dto.TiendaDTO;
import co.edu.uco.terraxs.dto.UsuarioDTO;

public interface TiendaFacade {
	
	void ingresarTienda(UsuarioDTO usuario);
	
	
	void salirTienda(UUID id);
	
	TiendaDTO verInformacionTienda(UUID id);
	
	

}

