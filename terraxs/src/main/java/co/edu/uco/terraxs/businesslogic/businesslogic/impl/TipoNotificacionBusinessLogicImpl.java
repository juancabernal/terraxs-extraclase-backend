package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TipoNotificacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class TipoNotificacionBusinessLogicImpl implements TipoNotificacionBusinessLogic{

	private DAOFactory factory;
	
	public TipoNotificacionBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}
	@Override
	public TipoNotificacionDomain consultarTipoNotificacionPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoNotificacionDomain> consultarTiposNotificacion(TipoNotificacionDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}



}
