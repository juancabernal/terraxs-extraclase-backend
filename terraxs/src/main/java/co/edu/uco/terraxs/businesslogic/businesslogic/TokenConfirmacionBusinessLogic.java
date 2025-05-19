package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface TokenConfirmacionBusinessLogic {
	
	void crearToken(TokenConfirmacionDomain tokenConfirmacion) throws TerraxsException;
	
	boolean validarToken(UUID id, int tokenIngresado) throws TerraxsException;
	
	void marcarTokenUsado(UUID id) throws TerraxsException;

	void eliminarToken(UUID id) throws TerraxsException;

}





