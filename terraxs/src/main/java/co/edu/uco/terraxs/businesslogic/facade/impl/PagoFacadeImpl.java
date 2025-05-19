package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.PagoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.AdministradorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.PagoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.AdministradorFacade;
import co.edu.uco.terraxs.businesslogic.facade.PagoFacade;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.AdministradorDTO;
import co.edu.uco.terraxs.dto.DetallePagoDTO;
import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.dto.PagoDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class PagoFacadeImpl implements PagoFacade{
	
	private DAOFactory daoFactory;
	private PagoBusinessLogic pagoBusinessLogic;
	
	
	public PagoFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		pagoBusinessLogic = new PagoBusinessLogicImpl(daoFactory);
	}


	@Override
	public void realizarPago(PagoDTO pago) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public PagoDTO consultarInformacionPago(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public EstadoDTO actualizarEstadoPago(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DetallePagoDTO verDetallesPago(UUID id, DetallePagoDTO detallePago) {
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
