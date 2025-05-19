package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.ClienteDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public interface ClienteFacade {

	void registrarCliente(ClienteDTO cliente) throws TerraxsException;
	
	boolean confirmarDatosCliente(ClienteDTO cliente, TokenConfirmacionDTO token) throws TerraxsException;
	
	void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento) throws TerraxsException;
	
	ClienteDTO consultarClientePorId(UUID id) throws TerraxsException;
	
	List<ClienteDTO> consultarClientes(ClienteDTO filtro) throws TerraxsException;
	
	void modificarDatosCliente(UUID id, ClienteDTO cliente) throws TerraxsException;
	
	void elegirMunicipio(List<ClienteDTO> ciudad) throws TerraxsException;
	
}
