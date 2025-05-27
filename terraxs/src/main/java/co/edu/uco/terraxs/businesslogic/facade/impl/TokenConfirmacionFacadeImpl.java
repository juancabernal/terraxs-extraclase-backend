
package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TokenConfirmacionBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tokenconfirmacion.dto.TokenConfirmacionDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.TokenConfirmacionBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.TokenConfirmacionFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.BusinessLogicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class TokenConfirmacionFacadeImpl implements TokenConfirmacionFacade{
	
	private DAOFactory daoFactory;
	private TokenConfirmacionBusinessLogic tokenConfirmacionBusinessLogic;
	
	
	public TokenConfirmacionFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		tokenConfirmacionBusinessLogic = new TokenConfirmacionBusinessLogicImpl(daoFactory);
	}


	@Override
	public void crearToken(TokenConfirmacionDTO tokenConfirmacion) throws TerraxsException {
		try {
			daoFactory.iniciarTransaccion();
			
			var tokenConfirmacionDomain = TokenConfirmacionDTOAssembler.getInstance().toDomain(tokenConfirmacion);
			tokenConfirmacionBusinessLogic.crearToken(tokenConfirmacionDomain);
			
			daoFactory.confirmarTransaccion();
		}catch(TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(Exception exception) {
			daoFactory.cancelarTransaccion();
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo token";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un registrar el nuevo token. Para tener más detalles revise el log de errores.";
    		throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}finally {
    		daoFactory.cerrarConexion();
    	}
		
	}


	@Override
	public TokenConfirmacionDTO consultarToken(UUID id) throws TerraxsException {
		try {
			TokenConfirmacionDomain dominioResultado = tokenConfirmacionBusinessLogic.consultarToken(id);
			return TokenConfirmacionDTOAssembler.getInstance().toDTO(dominioResultado);
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del token confirmacion con el identificador deseado";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la información del token confirmacion. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}


	@Override
	public void marcarTokenUsado(UUID id, TokenConfirmacionDTO tokenConfirmacion) throws TerraxsException {
		try {
			daoFactory.iniciarTransaccion();

			TokenConfirmacionDomain tokenConfirmacionDomain = TokenConfirmacionDTOAssembler.getInstance().toDomain(tokenConfirmacion);
			tokenConfirmacionBusinessLogic.marcarTokenUsado(id, tokenConfirmacionDomain);

			daoFactory.confirmarTransaccion();
		} catch (TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información del token de confirmacion";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar un token de confirmacion existente. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}


	@Override
	public void eliminarToken(UUID id) throws TerraxsException {
		try {
			daoFactory.iniciarTransaccion();

			tokenConfirmacionBusinessLogic.eliminarToken(id);

			daoFactory.confirmarTransaccion();
		} catch (TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información del token de confirmacion";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de eliminar un token de confirmacion existente. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
		
		
	}



}
