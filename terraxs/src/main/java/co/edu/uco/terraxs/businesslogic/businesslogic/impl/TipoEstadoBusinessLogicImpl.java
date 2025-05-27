package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TipoEstadoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipoestado.entity.TipoEstadoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoEstadoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class TipoEstadoBusinessLogicImpl implements TipoEstadoBusinessLogic{
	
	private DAOFactory factory;
	
	public TipoEstadoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public TipoEstadoDomain consultarTipoEstadoPorId(UUID id) throws TerraxsException {
		var tipoEstadoEntity = factory.getTipoEstadoDAO().listById(id);
		return  TipoEstadoEntityAssembler.getInstance().toDomain(tipoEstadoEntity);
	}

	@Override
	public List<TipoEstadoDomain> consultarEstados(TipoEstadoDomain filtro) throws TerraxsException{
		var tipoEstadoFilter = TipoEstadoEntityAssembler.getInstance().toEntity(filtro);
		var tipoEstadoEntities = factory.getTipoEstadoDAO().listByFilter(tipoEstadoFilter);
		return TipoEstadoEntityAssembler.getInstance().toDomain(tipoEstadoEntities);
	}

}
