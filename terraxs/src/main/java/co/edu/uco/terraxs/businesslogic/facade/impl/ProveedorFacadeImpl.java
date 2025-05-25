package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProveedorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.dto.PaisDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.ProveedorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.ProveedorFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.Business_logicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.ProveedorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

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
			
			var paisDomain = ProveedorDTOAssembler.getInstance().toDomain(proveedor); //TODO: Magia de convertir de DTO a Domain
			proveedorBusinessLogic.registrarNuevoProv(paisDomain);
			
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
	public boolean confirmarDatosProveedor(ProveedorDTO proveedor, TokenConfirmacionDTO token) throws TerraxsException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProveedorDTO consultarProveedorPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProveedorDTO> consultarProveedores(ProveedorDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDatosProveedor(UUID id, ProveedorDTO proveedor) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elegirCiudad(List<CiudadDTO> ciudad) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProveedor(UUID id) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}

}
