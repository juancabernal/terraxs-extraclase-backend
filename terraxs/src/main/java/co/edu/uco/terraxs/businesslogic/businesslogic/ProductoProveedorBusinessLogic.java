package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoProveedorDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface ProductoProveedorBusinessLogic {
	
	void ingresarProductoProveedor(ProductoProveedorDomain productoProveedor) throws TerraxsException;
	
	ProductoProveedorDomain consultarInformacionProductoProveedorPorId(UUID id) throws TerraxsException;

	void eliminarProductoProveedor(UUID id) throws TerraxsException;
	
	void actualizarDatosProductoProveedor(UUID id,ProductoProveedorDomain productoProveedor ) throws TerraxsException;

}





