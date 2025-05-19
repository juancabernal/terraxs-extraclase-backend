package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.DetallePagoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.DetallePagoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.DetallePagoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.DetallePagoDTO;
import co.edu.uco.terraxs.dto.MetodoPagoDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class DetallePagoFacadeImpl implements DetallePagoFacade{
	
	private DAOFactory daoFactory;
	private DetallePagoBusinessLogic detallePagoBusinessLogic;
	
	
	public DetallePagoFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		detallePagoBusinessLogic = new DetallePagoBusinessLogicImpl(daoFactory);
	}

	@Override
	
	
	public void registrarNuevoDetallePago(DetallePagoDTO detallePago) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetallePagoDTO consultarDetallePagoPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetallePagoDTO> consultarDetallesPago(DetallePagoDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void elegirMetodoPago(List<MetodoPagoDTO> metodoPago) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignarMontoPorMétodo(UUID id, DetallePagoDTO detallePago) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

}
