package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.PaisBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.PaisFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.PaisDTO;

public class PaisFacadeImpl implements PaisFacade {
	
	private DAOFactory daoFactory;
	private PaisBusinessLogic paisBusinessLogic;
	
	
	public PaisFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		paisBusinessLogic= new PaisBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarNuevoPais(PaisDTO pais) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPaisExistente(UUID id, PaisDTO pais) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamentePaisExistente(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDTO consultarPaisPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> consultarPaises(PaisDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
