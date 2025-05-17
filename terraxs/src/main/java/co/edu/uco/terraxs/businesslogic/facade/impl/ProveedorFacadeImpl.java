package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProveedorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.ProveedorBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.ProveedorFacade;
import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.ProveedorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class ProveedorFacadeImpl implements ProveedorFacade{
	
	private DAOFactory daoFactory;
	private ProveedorBusinessLogic proveedorBusinessLogic;
	
	
	public ProveedorFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		proveedorBusinessLogic = new ProveedorBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarProveedor(ProveedorDTO proveedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean confirmarDatosProveedor(ProveedorDTO proveedor, TokenConfirmacionDTO token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProveedorDTO consultarProveedorPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProveedorDTO> consultarProveedores(ProveedorDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDatosProveedor(UUID id, ProveedorDTO proveedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elegirCiudad(List<CiudadDTO> ciudad) {
		// TODO Auto-generated method stub
		
	}

}
