package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;

public interface DepartamentoBusinessLogic {
	
	void registrarNuevoDepartamento(DepartamentoDomain departamento);

	void modificarDepartamentoExistente(UUID id, DepartamentoDomain departamento);

	void darBajaDefinitivamenteDepartamentoExistente(UUID id);

	DepartamentoDomain consultarDepartamentoPorId(UUID id);

	List<DepartamentoDomain> consultarDepartamentos(DepartamentoDomain filtro);
	
	void elegirPais(List<PaisDomain> pais);

}

