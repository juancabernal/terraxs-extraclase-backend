package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.ProveedorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public interface ProveedorFacade {
	
void registrarProveedor(ProveedorDTO proveedor);
	
	boolean confirmarDatosProveedor(ProveedorDTO proveedor, TokenConfirmacionDTO token);
	
	void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento);
	
	ProveedorDTO consultarProveedorPorId(UUID id);
	
	List<ProveedorDTO> consultarProveedores(ProveedorDTO filtro);
	
	void modificarDatosProveedor(UUID id, ProveedorDTO proveedor);
	
	void elegirCiudad(List<CiudadDTO> ciudad);


}
