package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CarritoComprasDTO;
import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.dto.ProductoDTO;

public interface CarritoComprasFacade {

	void crearCarritoCompras(CarritoComprasDTO carritoCompras) throws TerraxsException;
	
	CarritoComprasDTO consultarCarritoComprasPorId(UUID id) throws TerraxsException ;

	List<CarritoComprasDTO> consultarCarritosCompras(CarritoComprasDTO filtro) throws TerraxsException;
	
	void agregarProductoCarrito(UUID id, ProductoDTO producto) throws TerraxsException;
	
	void quitarProductoCarrito(UUID id, ProductoDTO producto) throws TerraxsException;
	
	void vaciarCarrito(UUID id, CarritoComprasDTO carritoCompras) throws TerraxsException;
	
	void eliminarCarrito(UUID id) throws TerraxsException ;
	
	void modificarEstadoCarrito(List<EstadoDTO> estado) throws TerraxsException;

}
