package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.CiudadBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.CiudadFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.CiudadDTO;

public class CiudadFacadeImpl implements CiudadFacade {
	
	private DAOFactory daoFactory;
	private CiudadBusinessLogic ciudadBusinessLogic;
	
	
	public CiudadFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		ciudadBusinessLogic = new CiudadBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarNuevaCiudad(CiudadDTO ciudad) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCiudadExistente(UUID id, CiudadDTO ciudad) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCiudadExistente(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public CiudadDTO consultarCiudadPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadDTO> consultarCiudades(CiudadDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadDTO> consultarCiudadesPorDepartamento(UUID departamentoId) throws TerraxsException {
		// TODO Auto-generated method stub
		return null;
	}


}
