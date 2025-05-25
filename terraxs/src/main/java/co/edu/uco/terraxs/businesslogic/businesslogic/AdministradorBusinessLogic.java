package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;

public interface AdministradorBusinessLogic {
	
	void registrarAdministrador(AdministradorDomain administrador) throws TerraxsException;
	
	boolean confirmarDatosAdministrador(AdministradorDomain administrador, TokenConfirmacionDomain token) throws TerraxsException;
	
	void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento) throws TerraxsException;
	
	AdministradorDomain consultarAdministradorPorId(UUID id) throws TerraxsException;
	
	List<AdministradorDomain> consultarAdministradores(AdministradorDomain filtro) throws TerraxsException;
	
	void modificarDatosAdministrador(UUID id, AdministradorDomain administrador) throws TerraxsException;
	

}


