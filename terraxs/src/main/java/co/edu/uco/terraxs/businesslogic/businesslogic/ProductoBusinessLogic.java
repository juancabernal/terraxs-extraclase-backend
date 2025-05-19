package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface ProductoBusinessLogic {
	
	ProductoDomain consultarCostoProducto(UUID id) throws TerraxsException;
	
	void publicarProducto(ProductoDomain producto) throws TerraxsException;
	
	List<ProductoDomain> categorizarProducto(ProductoDomain filtro) throws TerraxsException;
	
	ProductoDomain visualizarDescripcionProducto(UUID id) throws TerraxsException;
	
	void actualizarDetallesProducto(UUID id, ProductoDomain producto) throws TerraxsException;
	
	boolean autorizarCambiosProducto(UUID id) throws TerraxsException;
	
	void eliminarProducto(UUID id) throws TerraxsException;

	
	
}





