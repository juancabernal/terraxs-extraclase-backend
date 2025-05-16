package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.ClienteDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public interface ClienteFacade {

	void registrarCliente(ClienteDTO cliente);
	
	boolean confirmarDatosCliente(ClienteDTO cliente, TokenConfirmacionDTO token);
	
	void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento);
	
	ClienteDTO consultarClientePorId(UUID id);
	
	List<ClienteDTO> consultarClientes(ClienteDTO filtro);
	
	void modificarDatosCliente(UUID id, ClienteDTO cliente);
	
	void elegirMunicipio(List<ClienteDTO> ciudad);
	
}
