package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CarritoComprasDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface CarritoComprasBusinessLogic {
	
	void crearCarritoCompras(CarritoComprasDomain carritoCompras) throws TerraxsException;
	
	CarritoComprasDomain consultarCarritoComprasPorId(UUID id) throws TerraxsException;

	List<CarritoComprasDomain> consultarCarritosCompras(CarritoComprasDomain filtro) throws TerraxsException;
	
	void agregarProductoCarrito(UUID id, ProductoDomain producto) throws TerraxsException;
	
	void quitarProductoCarrito(UUID id, ProductoDomain producto) throws TerraxsException;
	
	void vaciarCarrito(UUID id, CarritoComprasDomain carritoCompras) throws TerraxsException;
	
	void eliminarCarrito(UUID id) throws TerraxsException;
	
	void modificarEstadoCarrito(List<EstadoDomain> estado) throws TerraxsException;

}





