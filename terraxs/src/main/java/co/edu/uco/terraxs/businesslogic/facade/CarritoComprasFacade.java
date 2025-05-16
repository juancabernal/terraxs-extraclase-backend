package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.CarritoComprasDTO;
import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.dto.ProductoDTO;

public interface CarritoComprasFacade {

	void crearCarritoCompras(CarritoComprasDTO carritoCompras);
	
	CarritoComprasDTO consultarCarritoComprasPorId(UUID id);

	List<CarritoComprasDTO> consultarCarritosCompras(CarritoComprasDTO filtro);
	
	void agregarProductoCarrito(UUID id, ProductoDTO producto);
	
	void quitarProductoCarrito(UUID id, ProductoDTO producto);
	
	void vaciarCarrito(UUID id, CarritoComprasDTO carritoCompras);
	
	void eliminarCarrito(UUID id);
	
	void modificarEstadoCarrito(List<EstadoDTO> estado);

}
