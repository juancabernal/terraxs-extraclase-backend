package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.dto.ProductoCarritoComprasDTO;

public interface ProductoCarritoComprasFacade {
	
	ProductoCarritoComprasDTO consultarDetallesCarritoComprasPorId(UUID id);
	
	void modificarCantidadProducto(UUID id, ProductoCarritoComprasDTO productoCarritoCompras);
}
