package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProductoProveedorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoProveedorDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class ProductoProveedorBusinessLogicImpl implements ProductoProveedorBusinessLogic{

	private DAOFactory factory;
	
	public ProductoProveedorBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public void ingresarProductoProveedor(ProductoProveedorDomain productoProveedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductoProveedorDomain consultarInformacionProductoProveedorPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarProductoProveedor(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarDatosProductoProveedor(UUID id, ProductoProveedorDomain productoProveedor) {
		// TODO Auto-generated method stub
		
	}



	
}
