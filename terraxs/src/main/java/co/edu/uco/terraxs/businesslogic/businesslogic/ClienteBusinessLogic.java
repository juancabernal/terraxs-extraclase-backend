package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;

public interface ClienteBusinessLogic {

	void registrarCliente(ClienteDomain cliente) throws TerraxsException;
	
	boolean confirmarDatosCliente(ClienteDomain cliente, TokenConfirmacionDomain token) throws TerraxsException;
	
	void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento) throws TerraxsException;
	
	ClienteDomain consultarClientePorId(UUID id) throws TerraxsException;
	
	List<ClienteDomain> consultarClientes(ClienteDomain filtro) throws TerraxsException;
	
	void modificarDatosCliente(UUID id, ClienteDomain cliente) throws TerraxsException;
	
	void elegirCiudad(List<CiudadDomain> ciudad) throws TerraxsException;

}


