package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CategoriaProductoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.CategoriaProductoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.CategoriaProductoFacade;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.CategoriaProductoDTO;

public class CategoriaProductoFacadeImpl implements CategoriaProductoFacade{
	
	private DAOFactory daoFactory;
	private CategoriaProductoBusinessLogic categoriaProductoBusinessLogic;
	
	
	public CategoriaProductoFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		categoriaProductoBusinessLogic = new CategoriaProductoBusinessLogicImpl(daoFactory);
	}

	@Override
	public void crearNuevaCategoria(CategoriaProductoDTO categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCategoria(UUID id, CategoriaProductoDTO categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCategoria(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaProductoDTO consultarCategoriaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaProductoDTO> consultarCategoroias(CategoriaProductoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
