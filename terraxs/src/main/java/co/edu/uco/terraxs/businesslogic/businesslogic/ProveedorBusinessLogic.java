package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;

public interface ProveedorBusinessLogic {

	void registrarProveedor(ProveedorDomain proveedor);
	
	boolean confirmarDatosProveedor(ProveedorDomain proveedor, TokenConfirmacionDomain token);
	
	void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento);
	
	ProveedorDomain consultarProveedorPorId(UUID id);
	
	List<ProveedorDomain> consultarProveedores(ProveedorDomain filtro);
	
	void modificarDatosProveedor(UUID id, ProveedorDomain proveedor);
	
	void elegirCiudad(List<CiudadDomain> ciudad);

	
}
