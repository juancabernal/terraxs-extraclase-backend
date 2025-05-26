package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public interface TokenConfirmacionFacade {
	
	void crearToken(TokenConfirmacionDTO tokenConfirmacion) throws TerraxsException;
	
	TokenConfirmacionDTO consultarToken(UUID id) throws TerraxsException;
	
	void marcarTokenUsado(UUID id, TokenConfirmacionDTO tokenConfirmacion) throws TerraxsException;
	
	void eliminarToken(UUID id) throws TerraxsException;
	

}





