package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.DepartamentoDTO;

public interface CiudadFacade {

	void registrarNuevaCiudad(CiudadDTO ciudad);

	void modificarCiduadExistente(UUID id, CiudadDTO ciudad);

	void darBajaDefinitivamenteCiudadExistente(UUID id);

	CiudadDTO consultarCiudadPorId(UUID id);

	List<CiudadDTO> consultarCiudades(CiudadDTO filtro);
	
	void elegirDepartamento(List<DepartamentoDTO> pais);
	
}
