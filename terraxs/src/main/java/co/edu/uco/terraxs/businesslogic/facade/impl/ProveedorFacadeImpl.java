package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProveedorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.dto.PaisDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.proveedor.dto.ProveedorDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tokenconfirmacion.dto.TokenConfirmacionDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.ProveedorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.ProveedorFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.BusinessLogicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.PaisDTO;
import co.edu.uco.terraxs.dto.ProveedorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class ProveedorFacadeImpl implements ProveedorFacade{
	
	private DAOFactory daoFactory;
	private ProveedorBusinessLogic proveedorBusinessLogic;
	
	
	public ProveedorFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		proveedorBusinessLogic = new ProveedorBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarProveedor(ProveedorDTO proveedor) throws TerraxsException{
		
		try {
			daoFactory.iniciarTransaccion();
			
			var proveedorDomain = ProveedorDTOAssembler.getInstance().toDomain(proveedor);
			proveedorBusinessLogic.registrarProveedor(proveedorDomain);
			
			daoFactory.confirmarTransaccion();
		}catch(TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(Exception exception) {
			daoFactory.cancelarTransaccion();
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo proveedor";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un registrar el nuevo proveedor. Para tener más detalles revise el log de errores.";
    		throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}finally {
    		daoFactory.cerrarConexion();
    	}
		
	}

	@Override
	public boolean confirmarDatosProveedor(ProveedorDTO proveedor, TokenConfirmacionDTO token) throws TerraxsException{
	    try {
	        daoFactory.iniciarTransaccion();

	        var proveedorDomain = ProveedorDTOAssembler.getInstance().toDomain(proveedor);
	        var tokenDomain = TokenConfirmacionDTOAssembler.getInstance().toDomain(token);

	        boolean resultado = proveedorBusinessLogic.confirmarDatosProveedor(proveedorDomain, tokenDomain);

	        daoFactory.confirmarTransaccion();
	        return resultado;
	    } catch (TerraxsException exception) {
	        daoFactory.cancelarTransaccion();
	        throw exception;
	    } catch (Exception exception) {
	        daoFactory.cancelarTransaccion();
	        var mensajeUsuario = "Se ha presentado un error inesperado al confirmar los datos del proveedor.";
	        var mensajeTecnico = "Error técnico al confirmar datos del proveedor y validar token.";
	        throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } finally {
	        daoFactory.cerrarConexion();
	    }
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProveedorDTO consultarProveedorPorId(UUID id) throws TerraxsException{
		
		try {
			ProveedorDomain dominioResultado = proveedorBusinessLogic.consultarProveedorPorId(id);
			return ProveedorDTOAssembler.getInstance().toDTO(dominioResultado);
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del proveedor con el identificador deseado";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la información del proveedor. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ProveedorDTO> consultarProveedores(ProveedorDTO filtro) throws TerraxsException{

		try {
			
	        var proveedorDomainFiltro = ProveedorDTOAssembler.getInstance().toDomain(filtro);
	        List<ProveedorDomain> resultadoDominios = proveedorBusinessLogic.consultarProveedores(proveedorDomainFiltro);
	        
	        List<ProveedorDTO> resultadoDTOs = new ArrayList<>();
	        for (ProveedorDomain dominio : resultadoDominios) {
	            resultadoDTOs.add(ProveedorDTOAssembler.getInstance().toDTO(dominio));
	        }

	        return resultadoDTOs;
			
		} catch (TerraxsException exception) {
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de los proveedores con los filtros deseados";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar los proveedores filtrados. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public void modificarDatosProveedor(UUID id, ProveedorDTO proveedor) throws TerraxsException{
		try {
			daoFactory.iniciarTransaccion();

			ProveedorDomain proveedorDomain = ProveedorDTOAssembler.getInstance().toDomain(proveedor);
			proveedorBusinessLogic.modificarDatosProveedor(id, proveedorDomain);

			daoFactory.confirmarTransaccion();
		} catch (TerraxsException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información del proveedor";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar un proveedor existente. Para más detalles revise el log de errores.";
			throw BusinessLogicTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void elegirCiudad(List<CiudadDTO> ciudad) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProveedor(UUID id) throws TerraxsException {
		try {
			daoFactory.iniciarTransaccion();

			proveedorBusinessLogic.eliminarProveedor(id);

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

}
