package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UsuarioDomain;

public interface UsuarioBusinessLogic {
	
	void registrarUsuario(UsuarioDomain usuario);
	
	boolean confirmarDatos(UsuarioDomain usuario,TokenConfirmacionDomain token);
	
	void elegirTipoDocumento(List<TipoDocumentoDomain> documento);
	
	UsuarioDomain consultarInformacionUsuario(UUID id);
	
	void modificarDatos(UUID id,UsuarioDomain usuario);
	

	

}



