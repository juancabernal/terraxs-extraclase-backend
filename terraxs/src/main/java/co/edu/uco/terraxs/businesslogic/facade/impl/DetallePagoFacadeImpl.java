package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.DetallePagoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.DetallePagoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.DetallePagoFacade;
import co.edu.uco.terraxs.dto.DetallePagoDTO;
import co.edu.uco.terraxs.dto.MetodoPagoDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class DetallePagoFacadeImpl implements DetallePagoFacade{
	
	private DAOFactory daoFactory;
	private DetallePagoBusinessLogic detallePagoBusinessLogic;
	
	
	public DetallePagoFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		detallePagoBusinessLogic = new DetallePagoBusinessLogicImpl(daoFactory);
	}

	@Override
	
	
	public void registrarNuevoDetallePago(DetallePagoDTO detallePago) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetallePagoDTO consultarDetallePagoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetallePagoDTO> consultarDetallesPago(DetallePagoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void elegirMetodoPago(List<MetodoPagoDTO> metodoPago) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignarMontoPorMétodo(UUID id, DetallePagoDTO detallePago) {
		// TODO Auto-generated method stub
		
	}

}
