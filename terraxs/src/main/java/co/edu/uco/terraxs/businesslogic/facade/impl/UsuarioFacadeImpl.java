package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.UsuarioBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.AdministradorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.UsuarioBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.AdministradorFacade;
import co.edu.uco.terraxs.businesslogic.facade.UsuarioFacade;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.AdministradorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;
import co.edu.uco.terraxs.dto.UsuarioDTO;

public class UsuarioFacadeImpl implements UsuarioFacade{
	
	private DAOFactory daoFactory;
	private UsuarioBusinessLogic usuarioBusinessLogic;
	
	
	public UsuarioFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		usuarioBusinessLogic = new UsuarioBusinessLogicImpl(daoFactory);


}


	@Override
	public void registrarUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean confirmarDatos(UsuarioDTO usuario, TokenConfirmacionDTO token) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDTO> documento) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public UsuarioDTO consultarInformacionUsuario(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void modificarDatos(UUID id, UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		
	}
}
