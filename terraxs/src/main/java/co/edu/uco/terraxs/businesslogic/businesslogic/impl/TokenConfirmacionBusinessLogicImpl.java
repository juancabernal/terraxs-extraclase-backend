package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TokenConfirmacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tokenconfirmacion.entity.TokenConfirmacionEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.BusinessLogicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.entity.TokenConfirmacionEntity;

public class TokenConfirmacionBusinessLogicImpl implements TokenConfirmacionBusinessLogic{
	
	private DAOFactory factory;
	
	public TokenConfirmacionBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public void crearToken(TokenConfirmacionDomain tokenConfirmacion) throws TerraxsException {
		//1. se debe asegurar que los datos sean validos a nivel de tipo de dato, longitud,obligatoriedad,formato,rango
		validarIntegridadInformacionRegistrarNuevoToken(tokenConfirmacion);
		
		//2. validar que el numero del token no existe con el estado HÁBIL
		validarNoExistaTokenConMismoNumeroYEstado(tokenConfirmacion.getToken());
	
		//3. generar identificador nuevo token
		var id= generarIdentificadorNuevoToken();
		
		//4. recrear el domain con el id generado
		var tokenConfirmacionAcrear= new TokenConfirmacionDomain(id, tokenConfirmacion.getToken(), tokenConfirmacion.getFechaSolicitud(), 
				tokenConfirmacion.getFechaExpiracion(), tokenConfirmacion.getEstado() ,tokenConfirmacion.getNotificacion());
		
		//5. creamos el token siempre y cuando se hayan creado todas las reglas
		var tokenConfirmacionEntity =  TokenConfirmacionEntityAssembler.getInstance().toEntity(tokenConfirmacionAcrear);
		factory.getTokenConfirmacionDAO().create(tokenConfirmacionEntity);
		
	}
	
	
	
	private void validarIntegridadInformacionRegistrarNuevoToken(TokenConfirmacionDomain tokenConfirmacion) throws TerraxsException {
		validarIntegridadToken(tokenConfirmacion.getToken());
		
		
	}
	
	private void validarIntegridadToken(String token) throws TerraxsException {
		
	    if (UtilTexto.getInstance().estaVacia(token)) {
	        throw BusinessLogicTerraxsException.reportar("El número del token no puede estar vacío.");
	    }

	    if (token.length() != 6 || !token.matches("\\d{6}")) {
	        throw BusinessLogicTerraxsException.reportar("El token debe ser un número de exactamente 6 dígitos.");
	    }
		
		
	}
	private void validarNoExistaTokenConMismoNumeroYEstado(String token) throws TerraxsException {
	    var filtro = new TokenConfirmacionEntity();
	    filtro.setToken(token);

	    var tokensConEseNumero = factory.getTokenConfirmacionDAO().listByFilter(filtro);

	    var tokenHabil = tokensConEseNumero.stream()
	        .filter(t -> t.getEstado().getNombre().equalsIgnoreCase("HÁBIL"))
	        .findFirst();

	    if (tokenHabil.isPresent()) {
	        throw BusinessLogicTerraxsException.reportar("El token ya está en uso con estado HÁBIL. Se debe generar otro.");
	    }
	}
	
	private UUID generarIdentificadorNuevoToken() throws TerraxsException {
		UUID nuevoId;
		var existeId=false;
		do {
			nuevoId=UtilUUID.generarNuevoUUID();
			var tokenConfirmacion = factory.getTokenConfirmacionDAO().listById(nuevoId);
			existeId=!UtilUUID.esValorDefecto(tokenConfirmacion.getId());	
		}while(existeId);
		
		return nuevoId;
	}
	
	
	

	@Override
	public TokenConfirmacionDomain consultarToken(UUID id) throws TerraxsException {
		var tokenConfirmacionEntity = factory.getTokenConfirmacionDAO().listById(id);
		return  TokenConfirmacionEntityAssembler.getInstance().toDomain(tokenConfirmacionEntity);
	}

	@Override
	public void marcarTokenUsado(UUID id, TokenConfirmacionDomain tokenConfirmacion) throws TerraxsException {
		var tokenConfirmacionEntity = TokenConfirmacionEntityAssembler.getInstance().toEntity(tokenConfirmacion); //Magia de traducir de domain -> entity
		factory.getTokenConfirmacionDAO().update(id, tokenConfirmacionEntity);
		
	}

	@Override
	public void eliminarToken(UUID id) throws TerraxsException {
		factory.getTokenConfirmacionDAO().delete(id);
	}

	
}
