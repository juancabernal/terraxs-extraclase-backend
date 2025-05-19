package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TokenConfirmacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.TokenConfirmacionBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.TokenConfirmacionFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class TokenConfirmacionFacadeImpl implements TokenConfirmacionFacade{
	
	private DAOFactory daoFactory;
	private TokenConfirmacionBusinessLogic tokenConfirmacionBusinessLogic;
	
	
	public TokenConfirmacionFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		tokenConfirmacionBusinessLogic = new TokenConfirmacionBusinessLogicImpl(daoFactory);
	}


	@Override
	public void crearToken(TokenConfirmacionDTO tokenConfirmacion) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean validarToken(UUID id, int TokenIngresado) throws TerraxsException{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void marcarTokenUsado(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminarToken(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

}
