package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.UsuarioBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UsuarioDomain;

public class UsuarioBusinessLogicImpl implements UsuarioBusinessLogic{

	@Override
	public void registrarUsuario(UsuarioDomain usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean confirmarDatos(UsuarioDomain usuario, TokenConfirmacionDomain token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDomain> documento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UsuarioDomain consultarInformacionUsuario(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDatos(UUID id, UsuarioDomain usuario) {
		// TODO Auto-generated method stub
		
	}




}
