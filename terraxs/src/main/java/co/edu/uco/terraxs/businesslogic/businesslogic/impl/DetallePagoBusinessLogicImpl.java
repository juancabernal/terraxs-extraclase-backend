package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.DetallePagoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePagoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.MetodoPagoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class DetallePagoBusinessLogicImpl implements DetallePagoBusinessLogic{
	
	private DAOFactory factory;
	
	public DetallePagoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void registrarNuevoDetallePago(DetallePagoDomain detallePago) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetallePagoDomain consultarDetallePagoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetallePagoDomain> consultarDetallesPago(DetallePagoDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void elegirMetodoPago(List<MetodoPagoDomain> metodoPago) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignarMontoPorMétodo(UUID id, DetallePagoDomain detallePago) {
		// TODO Auto-generated method stub
		
	}

}
