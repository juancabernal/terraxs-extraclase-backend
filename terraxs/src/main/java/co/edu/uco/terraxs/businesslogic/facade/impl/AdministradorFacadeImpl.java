package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.AdministradorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.AdministradorFacade;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.AdministradorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class AdministradorFacadeImpl implements AdministradorFacade{
	
	private DAOFactory daoFactory;
	private AdministradorBusinessLogic administradorBusinessLogic;
	
	
	public AdministradorFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		administradorBusinessLogic = new AdministradorBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarAdministrador(AdministradorDTO administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean confirmarDatosAdministrador(AdministradorDTO administrador, TokenConfirmacionDTO token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdministradorDTO consultarAdministradorPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdministradorDTO> consultarAdministradores(AdministradorDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDatosAdministrador(UUID id, AdministradorDTO administrador) {
		// TODO Auto-generated method stub
		
	}

}
