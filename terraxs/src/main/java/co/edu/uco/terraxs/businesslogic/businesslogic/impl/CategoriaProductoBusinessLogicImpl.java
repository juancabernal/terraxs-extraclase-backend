package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CategoriaProductoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class CategoriaProductoBusinessLogicImpl implements CategoriaProductoBusinessLogic{
	
	private DAOFactory factory;
	
	public CategoriaProductoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void crearNuevaCategoria(CategoriaProductoDomain categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCategoria(UUID id, CategoriaProductoDomain categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCategoria(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaProductoDomain consultarCategoriaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaProductoDomain> consultarCategoroias(CategoriaProductoDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
