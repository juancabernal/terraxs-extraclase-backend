package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.ProductoDTO;

public interface ProductoFacade {
	
	ProductoDTO consultarCostoProducto(UUID id);
	
	void publicarProducto(ProductoDTO producto);
	
	List<ProductoDTO> categorizarProducto(ProductoDTO filtro);
	
	ProductoDTO visualizarDescripcionProducto(UUID id);
	
	void actualizarDetallesProducto(UUID id, ProductoDTO producto);
	
	boolean autorizarCambiosProducto(UUID id);
	
	void eliminarProducto(UUID id);

	
	
}





