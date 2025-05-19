package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.AdministradorDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;

public interface AdministradorFacade {
	
	void registrarAdministrador(AdministradorDTO administrador) throws TerraxsException;
	
	boolean confirmarDatosAdministrador(AdministradorDTO administrador, TokenConfirmacionDTO token) throws TerraxsException;
	
	void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento) throws TerraxsException;
	
	AdministradorDTO consultarAdministradorPorId(UUID id) throws TerraxsException;
	
	List<AdministradorDTO> consultarAdministradores(AdministradorDTO filtro) throws TerraxsException;
	
	void modificarDatosAdministrador(UUID id, AdministradorDTO administrador) throws TerraxsException;

}


