package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.EstadoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.estado.entity.EstadoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class EstadoBusinessLogicImpl implements EstadoBusinessLogic{
	
	private DAOFactory factory;
	
	public EstadoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public EstadoDomain consultarEstadoPorId(UUID id) throws TerraxsException {
		var estadoEntity = factory.getEstadoDAO().listById(id);
		return  EstadoEntityAssembler.getInstance().toDomain(estadoEntity);
	}

	@Override
	public List<EstadoDomain> consultarEstados(EstadoDomain filtro) throws TerraxsException{
		var estadoFilter = EstadoEntityAssembler.getInstance().toEntity(filtro);
		var estadoEntities = factory.getEstadoDAO().listByFilter(estadoFilter);
		
		return EstadoEntityAssembler.getInstance().toDomain(estadoEntities);
	}

}
