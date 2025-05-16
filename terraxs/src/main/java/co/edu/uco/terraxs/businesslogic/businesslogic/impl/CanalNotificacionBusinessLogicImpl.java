package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CanalNotificacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CanalNotificacionDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class CanalNotificacionBusinessLogicImpl implements CanalNotificacionBusinessLogic{
	
	private DAOFactory factory;
	
	public CanalNotificacionBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void crearNotificacionPorCanal(CanalNotificacionDomain canalNotificaion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CanalNotificacionDomain consultarCanalNotificacionPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CanalNotificacionDomain> consultarCanalesNotificacion(CanalNotificacionDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
