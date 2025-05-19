package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CategoriaProductoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.CategoriaProductoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.CategoriaProductoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.CategoriaProductoDTO;

public class CategoriaProductoFacadeImpl implements CategoriaProductoFacade{
	
	private DAOFactory daoFactory;
	private CategoriaProductoBusinessLogic categoriaProductoBusinessLogic;
	
	
	public CategoriaProductoFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		categoriaProductoBusinessLogic = new CategoriaProductoBusinessLogicImpl(daoFactory);
	}

	@Override
	public void crearNuevaCategoria(CategoriaProductoDTO categoria) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCategoria(UUID id, CategoriaProductoDTO categoria) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCategoria(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaProductoDTO consultarCategoriaPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaProductoDTO> consultarCategoroias(CategoriaProductoDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

}
