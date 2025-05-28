package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.DepartamentoDTO;
import co.edu.uco.terraxs.dto.PaisDTO;

public interface DepartamentoFacade {
	
	void registrarNuevoDepartamento(DepartamentoDTO departamento) throws TerraxsException;

	void modificarDepartamentoExistente(UUID id, DepartamentoDTO departamento) throws TerraxsException;

	void darBajaDefinitivamenteDepartamentoExistente(UUID id) throws TerraxsException;

	DepartamentoDTO consultarDepartamentoPorId(UUID id) throws TerraxsException;

	List<DepartamentoDTO> consultarDepartamentos() throws TerraxsException;
	
	List<DepartamentoDTO> consultarDepartamentosPorPais(UUID paisId) throws TerraxsException;

	List<DepartamentoDTO> consultarDepartamentosPorFiltro(DepartamentoDTO filtro) throws TerraxsException;
	
}
