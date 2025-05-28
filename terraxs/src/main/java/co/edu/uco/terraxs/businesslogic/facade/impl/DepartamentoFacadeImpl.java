package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.departamento.dto.DepartamentoDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.DepartamentoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.DepartamentoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.BusinessLogicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.DepartamentoDTO;

public class DepartamentoFacadeImpl implements DepartamentoFacade{
	
	private DAOFactory daoFactory;
	private DepartamentoBusinessLogic departamentoBusinessLogic;
	
	
	public DepartamentoFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		departamentoBusinessLogic = new DepartamentoBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarNuevoDepartamento(DepartamentoDTO departamento) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDepartamentoExistente(UUID id, DepartamentoDTO departamento) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteDepartamentoExistente(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartamentoDTO consultarDepartamentoPorId(UUID id) throws TerraxsException {
		try {
			DepartamentoDomain dominioResultado = departamentoBusinessLogic.consultarDepartamentoPorId(id);
			return DepartamentoDTOAssembler.getInstance().toDTO(dominioResultado);
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se presentó un error inesperado consultando el departamento por ID.";
			var mensajeTecnico = "Excepción no controlada al consultar el departamento por ID. Ver logs para más detalles.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
	

	@Override
	public List<DepartamentoDTO> consultarDepartamentos() throws TerraxsException {
	    try {
	        List<DepartamentoDomain> dominios = departamentoBusinessLogic.consultarDepartamentos();

	        List<DepartamentoDTO> resultado = new ArrayList<>();
	        for (DepartamentoDomain domain : dominios) {
	            resultado.add(DepartamentoDTOAssembler.getInstance().toDTO(domain));
	        }

	        return resultado;

	    } catch (TerraxsException exception) {
	        throw exception;
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se presentó un problema inesperado consultando todos los departamentos.";
	        var mensajeTecnico = "Excepción no controlada al consultar todos los departamentos. Ver logs.";
	        throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } finally {
	        daoFactory.cerrarConexion();
	    }
	}


	@Override
	public List<DepartamentoDTO> consultarDepartamentosPorFiltro(DepartamentoDTO filtro) throws TerraxsException {
		try {
			var filtroDomain = DepartamentoDTOAssembler.getInstance().toDomain(filtro);
			List<DepartamentoDomain> dominios = departamentoBusinessLogic.consultarDepartamentosPorFiltro(filtroDomain);

			List<DepartamentoDTO> resultado = new ArrayList<>();
			for (DepartamentoDomain domain : dominios) {
				resultado.add(DepartamentoDTOAssembler.getInstance().toDTO(domain));
			}
			return resultado;

		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se presentó un problema inesperado consultando departamentos.";
			var mensajeTecnico = "Excepción no controlada al consultar departamentos. Ver logs.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<DepartamentoDTO> consultarDepartamentosPorPais(UUID paisId) throws TerraxsException {
		try {
			daoFactory.iniciarTransaccion();

			List<DepartamentoDomain> dominios = departamentoBusinessLogic.consultarDepartamentosPorPais(paisId);

			List<DepartamentoDTO> resultado = new ArrayList<>();
			for (DepartamentoDomain domain : dominios) {
				resultado.add(DepartamentoDTOAssembler.getInstance().toDTO(domain));
			}

			daoFactory.confirmarTransaccion();
			return resultado;

		} catch (TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se presentó un problema inesperado consultando departamentos por país.";
			var mensajeTecnico = "Excepción no controlada al consultar departamentos filtrados por país. Ver logs.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

}
