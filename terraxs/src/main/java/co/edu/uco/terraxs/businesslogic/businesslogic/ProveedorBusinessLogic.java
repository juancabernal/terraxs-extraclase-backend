package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;

public interface ProveedorBusinessLogic {

	void registrarProveedor(ProveedorDomain proveedor) throws TerraxsException;
	
	boolean confirmarDatosProveedor(ProveedorDomain proveedor, TokenConfirmacionDomain token) throws TerraxsException;
	
	void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento) throws TerraxsException;
	
	ProveedorDomain consultarProveedorPorId(UUID id) throws TerraxsException;
	
	List<ProveedorDomain> consultarProveedores(ProveedorDomain filtro) throws TerraxsException;
	
	void modificarDatosProveedor(UUID id, ProveedorDomain proveedor) throws TerraxsException;
	
	void elegirCiudad(List<CiudadDomain> ciudad) throws TerraxsException;

	
}
