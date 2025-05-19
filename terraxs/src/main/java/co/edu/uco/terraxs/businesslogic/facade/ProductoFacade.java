package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.ProductoDTO;

public interface ProductoFacade {
	
	ProductoDTO consultarCostoProducto(UUID id) throws TerraxsException;
	
	void publicarProducto(ProductoDTO producto) throws TerraxsException;
	
	List<ProductoDTO> categorizarProducto(ProductoDTO filtro) throws TerraxsException;
	
	ProductoDTO visualizarDescripcionProducto(UUID id) throws TerraxsException;
	
	void actualizarDetallesProducto(UUID id, ProductoDTO producto) throws TerraxsException;
	
	boolean autorizarCambiosProducto(UUID id) throws TerraxsException;
	
	void eliminarProducto(UUID id) throws TerraxsException;

	
	
}





