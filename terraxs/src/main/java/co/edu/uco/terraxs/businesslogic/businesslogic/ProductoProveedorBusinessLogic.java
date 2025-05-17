package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoProveedorDomain;

public interface ProductoProveedorBusinessLogic {
	
	void ingresarProductoProveedor(ProductoProveedorDomain productoProveedor);
	
	ProductoProveedorDomain consultarInformacionProductoProveedorPorId(UUID id);

	void eliminarProductoProveedor(UUID id);
	
	void actualizarDatosProductoProveedor(UUID id,ProductoProveedorDomain productoProveedor );

}





