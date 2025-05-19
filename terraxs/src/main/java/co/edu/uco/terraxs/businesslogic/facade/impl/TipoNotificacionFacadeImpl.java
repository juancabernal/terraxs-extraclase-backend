package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.TipoNotificacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.AdministradorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.TipoNotificacionBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.AdministradorFacade;
import co.edu.uco.terraxs.businesslogic.facade.TipoNotificacionFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.AdministradorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TipoNotificacionDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class TipoNotificacionFacadeImpl implements TipoNotificacionFacade{
	
	private DAOFactory daoFactory;
	private TipoNotificacionBusinessLogic tipoNotificacionBusinessLogic;
	
	
	public TipoNotificacionFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		tipoNotificacionBusinessLogic = new TipoNotificacionBusinessLogicImpl(daoFactory);
	}


	@Override
	public TipoNotificacionDTO consultarTipoNotificacionPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<TipoNotificacionDTO> consultarTiposNotificacion(TipoNotificacionDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


}
