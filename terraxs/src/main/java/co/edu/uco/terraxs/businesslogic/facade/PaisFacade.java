package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.PaisDTO;

public interface PaisFacade {
	
	void registrarNuevoPais(PaisDTO pais);
	
	void modificarPaisExistente(UUID id, PaisDTO pais);
	
	void darBajaDefinitivamentePaisExistente(UUID id);
	
	PaisDTO consultarPaisPorId(UUID id);
	
	List<PaisDTO> consultarPaises(PaisDTO filtro);
	

}
