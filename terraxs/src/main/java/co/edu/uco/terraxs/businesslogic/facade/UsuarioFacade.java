package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;
import co.edu.uco.terraxs.dto.UsuarioDTO;

public interface UsuarioFacade {
	
	void registrarUsuario(UsuarioDTO usuario) throws TerraxsException;
	
	boolean confirmarDatos(UsuarioDTO usuario,TokenConfirmacionDTO token) throws TerraxsException;
	
	void elegirTipoDocumento(List<TipoDocumentoDTO> documento) throws TerraxsException;
	
	UsuarioDTO consultarInformacionUsuario(UUID id) throws TerraxsException;
	
	void modificarDatos(UUID id,UsuarioDTO usuario) throws TerraxsException;	

}



