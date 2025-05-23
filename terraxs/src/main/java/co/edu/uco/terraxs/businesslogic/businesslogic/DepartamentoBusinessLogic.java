package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;

public interface DepartamentoBusinessLogic {
	
	void registrarNuevoDepartamento(DepartamentoDomain departamento) throws TerraxsException;

	void modificarDepartamentoExistente(UUID id, DepartamentoDomain departamento) throws TerraxsException;

	void darBajaDefinitivamenteDepartamentoExistente(UUID id) throws TerraxsException;

	DepartamentoDomain consultarDepartamentoPorId(UUID id) throws TerraxsException;

	List<DepartamentoDomain> consultarDepartamentos(DepartamentoDomain filtro) throws TerraxsException;
	
	void elegirPais(List<PaisDomain> pais) throws TerraxsException;

}

