package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.ProductoCarritoComprasBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.AdministradorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.ProductoCarritoComprasBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.AdministradorFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.AdministradorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class ProductoCarritoComprasFacadeImpl implements AdministradorFacade{
	
	private DAOFactory daoFactory;
	private ProductoCarritoComprasBusinessLogic productoCarritoComprasBusinessLogic;
	
	
	public ProductoCarritoComprasFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		productoCarritoComprasBusinessLogic = new ProductoCarritoComprasBusinessLogicImpl(daoFactory);
	}


	@Override
	public void registrarAdministrador(AdministradorDTO administrador) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean confirmarDatosAdministrador(AdministradorDTO administrador, TokenConfirmacionDTO token) throws TerraxsException{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public AdministradorDTO consultarAdministradorPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<AdministradorDTO> consultarAdministradores(AdministradorDTO filtro) throws TerraxsException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void modificarDatosAdministrador(UUID id, AdministradorDTO administrador) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

}
