package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;
import co.edu.uco.terraxs.dto.UsuarioDTO;

public interface UsuarioFacade {
	
	void registrarUsuario(UsuarioDTO usuario);
	
	boolean confirmarDatos(UsuarioDTO usuario,TokenConfirmacionDTO token);
	s
	void elegirTipoDocumento(List<TipoDocumentoDTO> documento);
	
	UsuarioDTO consultarInformacionUsuario(UUID id);
	
	void modificarDatos(UUID id,UsuarioDTO usuario);
	

	

}



