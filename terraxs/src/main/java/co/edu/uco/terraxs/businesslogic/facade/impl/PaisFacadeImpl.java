package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.dto.PaisDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.PaisBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.PaisFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.BusinessLogicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.PaisDTO;

public class PaisFacadeImpl implements PaisFacade {
	
	private DAOFactory daoFactory;
	private PaisBusinessLogic paisBusinessLogic;
	
	
	public PaisFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		paisBusinessLogic= new PaisBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarNuevoPais(PaisDTO pais) throws TerraxsException{
		
		try {
			daoFactory.iniciarTransaccion();
			
			var paisDomain = PaisDTOAssembler.getInstance().toDomain(pais);
			paisBusinessLogic.registrarNuevoPais(paisDomain);
			
			daoFactory.confirmarTransaccion();
		}catch(TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(Exception exception) {
			daoFactory.cancelarTransaccion();
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo país";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un registrar el nuevo pais. Para tener más detalles revise el log de errores.";
    		throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}finally {
    		daoFactory.cerrarConexion();
    	}
		
		
	}

	@Override
	public void modificarPaisExistente(UUID id, PaisDTO pais) throws TerraxsException {
		try {
			daoFactory.iniciarTransaccion();

			PaisDomain paisDomain = PaisDTOAssembler.getInstance().toDomain(pais);
			paisBusinessLogic.modificarPaisExistente(id, paisDomain);

			daoFactory.confirmarTransaccion();
		} catch (TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información del país";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar un país existente. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public void darBajaDefinitivamentePaisExistente(UUID id) throws TerraxsException {
		try {
			daoFactory.iniciarTransaccion();

			paisBusinessLogic.darBajaDefinitivamentePaisExistente(id);

			daoFactory.confirmarTransaccion();
		} catch (TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información del país";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de eliminar un país existente. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public PaisDTO consultarPaisPorId(UUID id) throws TerraxsException {
		
		try {
			PaisDomain dominioResultado = paisBusinessLogic.consultarPaisPorId(id);
			return PaisDTOAssembler.getInstance().toDTO(dominioResultado);
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del país con el identificador deseado";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la información del país. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public List<PaisDTO> consultarPaises(PaisDTO filtro) throws TerraxsException {
		try {
			
	        var paisDomainFiltro = PaisDTOAssembler.getInstance().toDomain(filtro);
	        List<PaisDomain> resultadoDominios = paisBusinessLogic.consultarPaises(paisDomainFiltro);
	        
	        List<PaisDTO> resultadoDTOs = new ArrayList<>();
	        for (PaisDomain dominio : resultadoDominios) {
	            resultadoDTOs.add(PaisDTOAssembler.getInstance().toDTO(dominio));
	        }

	        return resultadoDTOs;
			
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de los países con los filtros deseados";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar los países filtrados. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}



}
