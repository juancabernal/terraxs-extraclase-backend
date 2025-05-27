package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TipoNotificacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tiponotificacion.entity.TipoNotificacionEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class TipoNotificacionBusinessLogicImpl implements TipoNotificacionBusinessLogic{

	private DAOFactory factory;
	
	public TipoNotificacionBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}
	@Override
	public TipoNotificacionDomain consultarTipoNotificacionPorId(UUID id) throws TerraxsException {
		var tipoNotificacionEntity = factory.getTipoNotificacionDAO().listById(id);
		return  TipoNotificacionEntityAssembler.getInstance().toDomain(tipoNotificacionEntity);
	}

	@Override
	public List<TipoNotificacionDomain> consultarTiposNotificacion(TipoNotificacionDomain filtro) throws TerraxsException {
		var tipoNotificacionFilter = TipoNotificacionEntityAssembler.getInstance().toEntity(filtro);
		var tipoNotificacionEntities = factory.getTipoNotificacionDAO().listByFilter(tipoNotificacionFilter);
		
		return TipoNotificacionEntityAssembler.getInstance().toDomain(tipoNotificacionEntities);
	}



}
