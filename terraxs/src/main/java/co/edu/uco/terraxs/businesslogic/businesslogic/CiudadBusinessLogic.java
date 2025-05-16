package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;

public interface CiudadBusinessLogic {
	
	void registrarNuevaCiudad(CiudadDomain ciudad);

	void modificarCiduadExistente(UUID id, CiudadDomain ciudad);

	void darBajaDefinitivamenteCiudadExistente(UUID id);

	CiudadDomain consultarCiudadPorId(UUID id);

	List<CiudadDomain> consultarCiudades(CiudadDomain filtro);
	
	void elegirDepartamento(List<DepartamentoDomain> pais);

}
