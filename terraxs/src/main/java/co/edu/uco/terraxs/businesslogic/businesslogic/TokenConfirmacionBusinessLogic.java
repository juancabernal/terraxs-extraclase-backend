package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;

public interface TokenConfirmacionBusinessLogic {
	
	void crearToken(TokenConfirmacionDomain tokenConfirmacion);
	
	boolean validarToken(UUID id,int TokenIngresado);
	
	void marcarTokenUsado(UUID id);
	

	void eliminarToken(UUID id);
	

}





