package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.ciudad.dto.CiudadDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.dto.PaisDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.CiudadBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.CiudadFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.BusinessLogicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.PaisDTO;

public class CiudadFacadeImpl implements CiudadFacade {
	
	private DAOFactory daoFactory;
	private CiudadBusinessLogic ciudadBusinessLogic;
	
	
	public CiudadFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		ciudadBusinessLogic = new CiudadBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarNuevaCiudad(CiudadDTO ciudad) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCiudadExistente(UUID id, CiudadDTO ciudad) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCiudadExistente(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public CiudadDTO consultarCiudadPorId(UUID id) throws TerraxsException{
		try {
			CiudadDomain dominioResultado = ciudadBusinessLogic.consultarCiudadPorId(id);
			return CiudadDTOAssembler.getInstance().toDTO(dominioResultado);
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de la ciudad con el identificador deseado";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la información de la ciudad. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<CiudadDTO> consultarCiudades(CiudadDTO filtro) throws TerraxsException{
		try {
			
	        var ciudadDomainFiltro = CiudadDTOAssembler.getInstance().toDomain(filtro);
	        List<CiudadDomain> resultadoDominios = ciudadBusinessLogic.consultarCiudades(ciudadDomainFiltro);
	        
	        List<CiudadDTO> resultadoDTOs = new ArrayList<>();
	        for (CiudadDomain dominio : resultadoDominios) {
	            resultadoDTOs.add(CiudadDTOAssembler.getInstance().toDTO(dominio));
	        }

	        return resultadoDTOs;
			
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de las ciudades con los filtros deseados";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar las ciudades filtrados. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<CiudadDTO> consultarCiudadesPorDepartamento(UUID departamentoId) throws TerraxsException {
	    try {
	        daoFactory.iniciarTransaccion();

	        List<CiudadDomain> ciudades = ciudadBusinessLogic.consultarCiudadesPorDepartamento(departamentoId);

	        List<CiudadDTO> ciudadesDTO = new ArrayList<>();
	        for (CiudadDomain domain : ciudades) {
	            ciudadesDTO.add(CiudadDTOAssembler.getInstance().toDTO(domain));
	        }

	        daoFactory.confirmarTransaccion();
	        return ciudadesDTO;

	    } catch (TerraxsException exception) {
	        daoFactory.cancelarTransaccion();
	        throw exception;

	    } catch (Exception exception) {
	        daoFactory.cancelarTransaccion();
	        var mensajeUsuario = "Se ha presentado un problema inesperado al consultar las ciudades por departamento.";
	        var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar las ciudades filtradas por departamento. Para más detalles revise el log de errores.";
	        throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);

	    } finally {
	        daoFactory.cerrarConexion();
	    }
	}



}
