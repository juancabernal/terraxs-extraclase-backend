package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.ProveedorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public interface ProveedorFacade {
	
	void registrarProveedor(ProveedorDTO proveedor) throws TerraxsException;
	
	boolean confirmarDatosProveedor(ProveedorDTO proveedor, TokenConfirmacionDTO token) throws TerraxsException;
	
	void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento) throws TerraxsException;
	
	ProveedorDTO consultarProveedorPorId(UUID id) throws TerraxsException;
	
	List<ProveedorDTO> consultarProveedores(ProveedorDTO filtro) throws TerraxsException;
	
	void modificarDatosProveedor(UUID id, ProveedorDTO proveedor) throws TerraxsException;
	
	void elegirCiudad(List<CiudadDTO> ciudad) throws TerraxsException;
	
	void eliminarProveedor(UUID id) throws TerraxsException;


}
