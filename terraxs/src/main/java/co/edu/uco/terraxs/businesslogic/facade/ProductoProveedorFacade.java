package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.dto.ProductoProveedorDTO;

public interface ProductoProveedorFacade {
	
	void ingresarProductoProveedor(ProductoProveedorDTO productoProveedor);
	
	ProductoProveedorDTO consultarInformacionProductoProveedorPorId(UUID id);

	void eliminarProductoProveedor(UUID id);
	
	void actualizarDatosProductoProveedor(UUID id,ProductoProveedorDTO productoProveedor );

}





