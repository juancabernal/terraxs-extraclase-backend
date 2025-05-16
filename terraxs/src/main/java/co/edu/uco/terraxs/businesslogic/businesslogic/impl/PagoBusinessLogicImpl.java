package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.PagoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePagoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PagoDomain;

public class PagoBusinessLogicImpl implements PagoBusinessLogic{

	@Override
	public void realizarPago(PagoDomain pago) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PagoDomain consultarInformacionPago(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoDomain actualizarEstadoPago(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetallePagoDomain verDetallesPago(UUID id, DetallePagoDomain detallePago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean confirmarPago(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancelarPago(UUID id) {
		// TODO Auto-generated method stub
		
	}


	
}
