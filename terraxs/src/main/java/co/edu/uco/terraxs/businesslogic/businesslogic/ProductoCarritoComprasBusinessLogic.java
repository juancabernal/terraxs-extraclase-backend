package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoCarritoComprasDomain;

public interface ProductoCarritoComprasBusinessLogic {
	
	ProductoCarritoComprasDomain consultarDetallesCarritoComprasPorId(UUID id);
	
	void modificarCantidadProducto(UUID id, ProductoCarritoComprasDomain productoCarritoCompras);
}
