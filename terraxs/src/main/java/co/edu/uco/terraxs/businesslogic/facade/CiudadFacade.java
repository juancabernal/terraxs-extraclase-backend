package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.DepartamentoDTO;

public interface CiudadFacade {

	void registrarNuevaCiudad(CiudadDTO ciudad) throws TerraxsException;

	void modificarCiduadExistente(UUID id, CiudadDTO ciudad) throws TerraxsException;

	void darBajaDefinitivamenteCiudadExistente(UUID id) throws TerraxsException;

	CiudadDTO consultarCiudadPorId(UUID id) throws TerraxsException;

	List<CiudadDTO> consultarCiudades(CiudadDTO filtro) throws TerraxsException;
	
	void elegirDepartamento(List<DepartamentoDTO> pais) throws TerraxsException;
	
}
