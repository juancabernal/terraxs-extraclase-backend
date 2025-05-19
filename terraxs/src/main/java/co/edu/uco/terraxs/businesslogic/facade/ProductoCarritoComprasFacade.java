package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.ProductoCarritoComprasDTO;

public interface ProductoCarritoComprasFacade {
	
	ProductoCarritoComprasDTO consultarDetallesCarritoComprasPorId(UUID id) throws TerraxsException;
	
	void modificarCantidadProducto(UUID id, ProductoCarritoComprasDTO productoCarritoCompras) throws TerraxsException;
}
