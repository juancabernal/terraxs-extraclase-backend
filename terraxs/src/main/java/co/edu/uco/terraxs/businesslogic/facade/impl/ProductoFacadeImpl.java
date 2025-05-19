package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.ProductoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.AdministradorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.ProductoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.AdministradorFacade;
import co.edu.uco.terraxs.businesslogic.facade.ProductoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.AdministradorDTO;
import co.edu.uco.terraxs.dto.ProductoDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class ProductoFacadeImpl implements ProductoFacade{
	
	private DAOFactory daoFactory;
	private ProductoBusinessLogic productoBusinessLogic;
	
	
	public ProductoFacadeImpl() throws TerraxsException{
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL) ;
		productoBusinessLogic = new ProductoBusinessLogicImpl(daoFactory);
	}


	@Override
	public ProductoDTO consultarCostoProducto(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void publicarProducto(ProductoDTO producto) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ProductoDTO> categorizarProducto(ProductoDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ProductoDTO visualizarDescripcionProducto(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void actualizarDetallesProducto(UUID id, ProductoDTO producto) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean autorizarCambiosProducto(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void eliminarProducto(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


}
