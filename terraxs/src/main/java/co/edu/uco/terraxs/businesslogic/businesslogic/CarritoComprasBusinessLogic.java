package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CarritoComprasDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoDomain;

public interface CarritoComprasBusinessLogic {
	
	void crearCarritoCompras(CarritoComprasDomain carritoCompras);
	
	CarritoComprasDomain consultarCarritoComprasPorId(UUID id);

	List<CarritoComprasDomain> consultarCarritosCompras(CarritoComprasDomain filtro);
	
	void agregarProductoCarrito(UUID id, ProductoDomain producto);
	
	void quitarProductoCarrito(UUID id, ProductoDomain producto);
	
	void vaciarCarrito(UUID id, CarritoComprasDomain carritoCompras);
	
	void eliminarCarrito(UUID id);
	
	void modificarEstadoCarrito(List<EstadoDomain> estado);

}





