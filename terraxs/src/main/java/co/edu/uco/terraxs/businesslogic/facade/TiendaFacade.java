package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.TiendaDTO;
import co.edu.uco.terraxs.dto.UsuarioDTO;

public interface TiendaFacade {
	
	void ingresarTienda(UsuarioDTO usuario) throws TerraxsException;
	
	void salirTienda(UUID id) throws TerraxsException;
	
	TiendaDTO verInformacionTienda(UUID id) throws TerraxsException;
	
	

}

