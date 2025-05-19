package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProductoProveedorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.ProductoProveedorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.ProductoProveedorFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.ProductoProveedorDTO;

public class ProductoProveedorFacadeImpl implements ProductoProveedorFacade{
	
	private DAOFactory daoFactory;
	private ProductoProveedorBusinessLogic productoProveedorBusinessLogic;
	
	
	public ProductoProveedorFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		productoProveedorBusinessLogic = new ProductoProveedorBusinessLogicImpl(daoFactory);
	}


	@Override
	public void ingresarProductoProveedor(ProductoProveedorDTO productoProveedor) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public ProductoProveedorDTO consultarInformacionProductoProveedorPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void eliminarProductoProveedor(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actualizarDatosProductoProveedor(UUID id, ProductoProveedorDTO productoProveedor) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

}
