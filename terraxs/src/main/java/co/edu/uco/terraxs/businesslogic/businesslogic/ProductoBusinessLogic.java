package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoDomain;

public interface ProductoBusinessLogic {
	
	ProductoDomain consultarCostoProducto(UUID id);
	
	void publicarProducto(ProductoDomain producto);
	
	List<ProductoDomain> categorizarProducto(ProductoDomain filtro);
	
	ProductoDomain visualizarDescripcionProducto(UUID id);
	
	void actualizarDetallesProducto(UUID id, ProductoDomain producto);
	
	boolean autorizarCambiosProducto(UUID id);
	
	void eliminarProducto(UUID id);

	
	
}





