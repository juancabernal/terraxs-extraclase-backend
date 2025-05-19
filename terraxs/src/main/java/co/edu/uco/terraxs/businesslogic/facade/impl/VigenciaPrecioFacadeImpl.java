package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.VigenciaPrecioBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.VigenciaPrecioBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.VigenciaPrecioFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.VigenciaPrecioDTO;

public class VigenciaPrecioFacadeImpl implements VigenciaPrecioFacade{
	
	
	private DAOFactory daoFactory;
	private VigenciaPrecioBusinessLogic vigenciaPrecioBusinessLogic;
	
	
	public VigenciaPrecioFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		vigenciaPrecioBusinessLogic = new VigenciaPrecioBusinessLogicImpl(daoFactory);
	}
	


	@Override
	public void crearVigencia(VigenciaPrecioDTO vigenciaPrecio) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actualizarVigencia(UUID id, VigenciaPrecioDTO categoria) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public VigenciaPrecioDTO consultarVigencia(UUID id, VigenciaPrecioDTO vigenciaPrecio) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


}
