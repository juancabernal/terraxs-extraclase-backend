package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;

public interface ClienteBusinessLogic {

	void registrarCliente(ClienteDomain cliente);
	
	boolean confirmarDatosCliente(ClienteDomain cliente, TokenConfirmacionDomain token);
	
	void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento);
	
	ClienteDomain consultarClientePorId(UUID id);
	
	List<ClienteDomain> consultarClientes(ClienteDomain filtro);
	
	void modificarDatosCliente(UUID id, ClienteDomain cliente);
	
	void elegirMunicipio(List<CiudadDomain> ciudad);

}


