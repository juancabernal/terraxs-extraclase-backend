package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface UsuarioBusinessLogic {
	
	void registrarUsuario(UsuarioDomain usuario) throws TerraxsException;
	
	boolean confirmarDatos(UsuarioDomain usuario,TokenConfirmacionDomain token) throws TerraxsException;
	
	void elegirTipoDocumento(List<TipoDocumentoDomain> documento) throws TerraxsException;
	
	UsuarioDomain consultarInformacionUsuario(UUID id) throws TerraxsException;
	
	void modificarDatos(UUID id,UsuarioDomain usuario) throws TerraxsException;

}



