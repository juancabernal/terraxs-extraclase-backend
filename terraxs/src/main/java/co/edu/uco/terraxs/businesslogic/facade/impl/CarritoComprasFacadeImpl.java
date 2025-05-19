package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CarritoComprasBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.CarritoComprasBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.CarritoComprasFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CarritoComprasDTO;
import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.dto.ProductoDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class CarritoComprasFacadeImpl implements CarritoComprasFacade{
	
	private DAOFactory daoFactory;
	private CarritoComprasBusinessLogic carritoComprasBusinessLogic;
	
	
	public CarritoComprasFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		carritoComprasBusinessLogic = new CarritoComprasBusinessLogicImpl(daoFactory);
	}

	@Override
	public void crearCarritoCompras(CarritoComprasDTO carritoCompras) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public CarritoComprasDTO consultarCarritoComprasPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarritoComprasDTO> consultarCarritosCompras(CarritoComprasDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarProductoCarrito(UUID id, ProductoDTO producto) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarProductoCarrito(UUID id, ProductoDTO producto) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vaciarCarrito(UUID id, CarritoComprasDTO carritoCompras) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCarrito(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEstadoCarrito(List<EstadoDTO> estado) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

}
