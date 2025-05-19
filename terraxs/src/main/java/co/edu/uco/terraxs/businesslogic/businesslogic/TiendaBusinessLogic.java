package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TiendaDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface TiendaBusinessLogic {
	
	void ingresarTienda(UsuarioDomain usuario) throws TerraxsException;
	
	void salirTienda(UUID id) throws TerraxsException;
	
	TiendaDomain verInformacionTienda(UUID id) throws TerraxsException;
	
	

}

