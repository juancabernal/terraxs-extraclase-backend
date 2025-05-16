package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;

public interface AdministradorBusinessLogic {
	
	void registrarAdministrador(AdministradorDomain administrador);
	
	boolean confirmarDatosAdministrador(AdministradorDomain administrador, TokenConfirmacionDomain token);
	
	void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento);
	
	AdministradorDomain consultarAdministradorPorId(UUID id);
	
	List<AdministradorDomain> consultarAdministradores(AdministradorDomain filtro);
	
	void modificarDatosAdministrador(UUID id, AdministradorDomain administrador);

}


