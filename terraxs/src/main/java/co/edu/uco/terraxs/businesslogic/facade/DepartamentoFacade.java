package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.DepartamentoDTO;
import co.edu.uco.terraxs.dto.PaisDTO;

public interface DepartamentoFacade {
	
	void registrarNuevoDepartamento(DepartamentoDTO departamento);

	void modificarDepartamentoExistente(UUID id, DepartamentoDTO departamento);

	void darBajaDefinitivamenteDepartamentoExistente(UUID id);

	DepartamentoDTO consultarDepartamentoPorId(UUID id);

	List<DepartamentoDTO> consultarDepartamentos(DepartamentoDTO filtro);
	
	void elegirPais(List<PaisDTO> pais);
	
}
