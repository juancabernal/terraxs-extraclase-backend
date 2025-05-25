package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.dto.PaisDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.PaisBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.PaisFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.Business_logicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
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
			
			var paisDomain = PaisDTOAssembler.getInstance().toDomain(pais); //TODO: Magia de convertir de DTO a Domain
			paisBusinessLogic.registrarNuevoPais(paisDomain);
			
			daoFactory.confirmarTransaccion();
		}catch(TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(Exception exception) {
			daoFactory.cancelarTransaccion();
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo país";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un registrar el nuevo pais. Para tener más detalles revise el log de errores.";
    		throw Business_logicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}finally {
    		daoFactory.cerrarConexion();
    	}
		
		
	}
	@Override
	public void modificarPaisExistente(UUID id, PaisDTO pais) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamentePaisExistente(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDTO consultarPaisPorId(UUID id) throws TerraxsException{
		try {
			
			var listaDominioResultado = paisBusinessLogic.consultarPaisPorId(id);
			//Magia de convertir Domain a DTO de respuesta
			return null;
			
		}catch(TerraxsException exception) {
			throw exception;
		}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información del país con el identificador deseado";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la información del pais con el identificador deseado. Para tener más detalles revise el log de errores.";
    		throw Business_logicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}finally {
    		daoFactory.cerrarConexion();
    	}
		
	}

	@Override
	public List<PaisDTO> consultarPaises(PaisDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static PaisDomain convertirDeDTO(final PaisDTO dto) throws TerraxsException {
		if (UtilObjeto.getInstance().esNulo(dto)) {
			throw Business_logicTerraxsException.reportar("No es posible convertir un país nulo a dto.");
		}
		return new PaisDomain(dto.getId(), dto.getNombre());
	}
	
	
	public static PaisDTO convertirADTO(final PaisDomain domain) throws TerraxsException {
		if (UtilObjeto.getInstance().esNulo(domain)) {
			throw Business_logicTerraxsException.reportar("No es posible convertir un dto de país nulo a dominio.");
		}
			return new PaisDTO(domain.getId(), domain.getNombre());
	}
	


}
