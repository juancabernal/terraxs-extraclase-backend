package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProductoCarritoComprasBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoCarritoComprasDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class ProductoCarritoComprasBusinessLogicImpl implements ProductoCarritoComprasBusinessLogic{

	private DAOFactory factory;
	
	public ProductoCarritoComprasBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public ProductoCarritoComprasDomain consultarDetallesCarritoComprasPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarCantidadProducto(UUID id, ProductoCarritoComprasDomain productoCarritoCompras) {
		// TODO Auto-generated method stub
		
	}


	
}
