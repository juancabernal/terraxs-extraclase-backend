package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface PaisBusinessLogic {
	
	void registrarNuevoPais(PaisDomain pais) throws TerraxsException;
	
	void modificarPaisExistente(UUID id, PaisDomain pais) throws TerraxsException;
	
	void darBajaDefinitivamentePaisExistente(UUID id) throws TerraxsException;
	
	PaisDomain consultarPaisPorId(UUID id) throws TerraxsException;
	
	List<PaisDomain> consultarPaises(PaisDomain filtro) throws TerraxsException;
	

}
