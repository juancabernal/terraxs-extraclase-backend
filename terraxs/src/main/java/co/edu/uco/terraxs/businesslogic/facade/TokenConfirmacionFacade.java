package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public interface TokenConfirmacionFacade {
	
	void crearToken(TokenConfirmacionDTO tokenConfirmacion);
	
	boolean validarToken(UUID id,int TokenIngresado);
	
	void marcarTokenUsado(UUID id);
	

	void eliminarToken(UUID id);
	

}





