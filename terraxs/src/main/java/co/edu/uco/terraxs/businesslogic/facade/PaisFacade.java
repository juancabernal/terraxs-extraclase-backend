package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.PaisDTO;

public interface PaisFacade {
	
	void registrarNuevoPais(PaisDTO pais) throws TerraxsException;
	
	void modificarPaisExistente(UUID id, PaisDTO pais) throws TerraxsException;
	
	void darBajaDefinitivamentePaisExistente(UUID id) throws TerraxsException;
	
	PaisDTO consultarPaisPorId(UUID id) throws TerraxsException;
	
	List<PaisDTO> consultarPaises(PaisDTO filtro) throws TerraxsException;
	

}
