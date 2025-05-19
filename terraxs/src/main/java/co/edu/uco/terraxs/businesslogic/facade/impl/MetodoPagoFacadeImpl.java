package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CanalBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.MetodoPagoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.CanalBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.MetodoPagoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.CanalFacade;
import co.edu.uco.terraxs.businesslogic.facade.MetodoPagoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CanalDTO;
import co.edu.uco.terraxs.dto.MetodoPagoDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class MetodoPagoFacadeImpl implements MetodoPagoFacade{
	
	private DAOFactory daoFactory;
	private MetodoPagoBusinessLogic metodoPagoBusinessLogic;
	
	
	public MetodoPagoFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		metodoPagoBusinessLogic = new MetodoPagoBusinessLogicImpl(daoFactory);
	}


	@Override
	public MetodoPagoDTO consultarMetodoPagoPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MetodoPagoDTO> consultarMetodosPago(MetodoPagoDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


}
