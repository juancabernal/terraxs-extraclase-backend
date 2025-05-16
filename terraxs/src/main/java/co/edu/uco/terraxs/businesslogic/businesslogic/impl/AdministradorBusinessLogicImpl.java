package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class AdministradorBusinessLogicImpl implements AdministradorBusinessLogic{
	
	private DAOFactory factory;
	
	public AdministradorBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void registrarAdministrador(AdministradorDomain administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean confirmarDatosAdministrador(AdministradorDomain administrador, TokenConfirmacionDomain token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdministradorDomain consultarAdministradorPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdministradorDomain> consultarAdministradores(AdministradorDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDatosAdministrador(UUID id, AdministradorDomain administrador) {
		// TODO Auto-generated method stub
		
	}

	
}
