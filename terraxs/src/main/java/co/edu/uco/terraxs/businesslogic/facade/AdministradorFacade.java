package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.AdministradorDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;

public interface AdministradorFacade {
	
	void registrarAdministrador(AdministradorDTO administrador);
	
	boolean confirmarDatosAdministrador(AdministradorDTO administrador, TokenConfirmacionDTO token);
	
	void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento);
	
	AdministradorDTO consultarAdministradorPorId(UUID id);
	
	List<AdministradorDTO> consultarAdministradores(AdministradorDTO filtro);
	
	void modificarDatosAdministrador(UUID id, AdministradorDTO administrador);

}


