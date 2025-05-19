package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface CiudadBusinessLogic {
	
	void registrarNuevaCiudad(CiudadDomain ciudad) throws TerraxsException;

	void modificarCiduadExistente(UUID id, CiudadDomain ciudad) throws TerraxsException;

	void darBajaDefinitivamenteCiudadExistente(UUID id) throws TerraxsException;

	CiudadDomain consultarCiudadPorId(UUID id) throws TerraxsException;

	List<CiudadDomain> consultarCiudades(CiudadDomain filtro) throws TerraxsException;
	
	void elegirDepartamento(List<DepartamentoDomain> pais) throws TerraxsException;

}
