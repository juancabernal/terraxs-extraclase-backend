package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoCarritoComprasDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface ProductoCarritoComprasBusinessLogic {
	
	ProductoCarritoComprasDomain consultarDetallesCarritoComprasPorId(UUID id) throws TerraxsException;
	
	void modificarCantidadProducto(UUID id, ProductoCarritoComprasDomain productoCarritoCompras) throws TerraxsException;
}
