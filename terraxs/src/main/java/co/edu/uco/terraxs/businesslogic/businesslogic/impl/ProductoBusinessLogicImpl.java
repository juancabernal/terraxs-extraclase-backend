package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProductoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class ProductoBusinessLogicImpl implements ProductoBusinessLogic{

	private DAOFactory factory;
	
	public ProductoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}
	@Override
	public ProductoDomain consultarCostoProducto(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void publicarProducto(ProductoDomain producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductoDomain> categorizarProducto(ProductoDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDomain visualizarDescripcionProducto(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarDetallesProducto(UUID id, ProductoDomain producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean autorizarCambiosProducto(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminarProducto(UUID id) {
		// TODO Auto-generated method stub
		
	}



	
}
