package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TipoDocumentoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipodocumento.dto.TipoDocumentoDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.TipoDocumentoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.TipoDocumentoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.BusinessLogicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;

public class TipoDocumentoFacadeImpl implements TipoDocumentoFacade {
	
	private DAOFactory daoFactory;
	private TipoDocumentoBusinessLogic tipoDocumentoBusinessLogic;
	
	
	public TipoDocumentoFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		tipoDocumentoBusinessLogic = new TipoDocumentoBusinessLogicImpl(daoFactory);
	}

	@Override
	public TipoDocumentoDTO consultarTipoDocumentoPorId(UUID id) throws TerraxsException{
		try {
			TipoDocumentoDomain dominioResultado = tipoDocumentoBusinessLogic.consultarTipoDocumentoPorId(id);
			return TipoDocumentoDTOAssembler.getInstance().toDTO(dominioResultado);
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del tipo de documento con el identificador deseado";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la información del tipo de documento. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public List<TipoDocumentoDTO> consultarTiposDocumento(TipoDocumentoDTO filtro) throws TerraxsException{
		try {
			
	        var tipoDocumentoDomainFiltro = TipoDocumentoDTOAssembler.getInstance().toDomain(filtro);
	        List<TipoDocumentoDomain> resultadoDominios = tipoDocumentoBusinessLogic.consultarTiposDocumento(tipoDocumentoDomainFiltro);
	        
	        List<TipoDocumentoDTO> resultadoDTOs = new ArrayList<>();
	        for (TipoDocumentoDomain dominio : resultadoDominios) {
	            resultadoDTOs.add(TipoDocumentoDTOAssembler.getInstance().toDTO(dominio));
	        }

	        return resultadoDTOs;
			
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de los tipos de documento con los filtros deseados";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar los tipos de documento filtrados. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

}
