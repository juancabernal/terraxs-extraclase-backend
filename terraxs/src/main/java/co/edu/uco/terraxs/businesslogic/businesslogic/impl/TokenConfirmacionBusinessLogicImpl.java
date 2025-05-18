package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TokenConfirmacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class TokenConfirmacionBusinessLogicImpl implements TokenConfirmacionBusinessLogic{
	
	private DAOFactory factory;
	
	public TokenConfirmacionBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}



	@Override
	public void crearToken(TokenConfirmacionDomain tokenConfirmacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validarToken(UUID id, int TokenIngresado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void marcarTokenUsado(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarToken(UUID id) {
		// TODO Auto-generated method stub
		
	}


	
}
