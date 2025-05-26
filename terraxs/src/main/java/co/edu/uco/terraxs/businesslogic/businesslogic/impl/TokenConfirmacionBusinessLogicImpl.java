package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TokenConfirmacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class TokenConfirmacionBusinessLogicImpl implements TokenConfirmacionBusinessLogic{
	
	private DAOFactory factory;
	
	public TokenConfirmacionBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public void crearToken(TokenConfirmacionDomain tokenConfirmacion) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TokenConfirmacionDTO consultarToken(UUID id) throws TerraxsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void marcarTokenUsado(UUID id, TokenConfirmacionDomain tokenConfirmacion) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarToken(UUID id) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}

	
}
