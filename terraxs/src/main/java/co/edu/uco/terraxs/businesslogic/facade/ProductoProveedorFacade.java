package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.ProductoProveedorDTO;

public interface ProductoProveedorFacade {
	
	void ingresarProductoProveedor(ProductoProveedorDTO productoProveedor) throws TerraxsException;
	
	ProductoProveedorDTO consultarInformacionProductoProveedorPorId(UUID id) throws TerraxsException;

	void eliminarProductoProveedor(UUID id) throws TerraxsException;
	
	void actualizarDatosProductoProveedor(UUID id,ProductoProveedorDTO productoProveedor ) throws TerraxsException;

}





