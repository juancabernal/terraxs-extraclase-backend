package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProveedorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class ProveedorBusinessLogicImpl implements ProveedorBusinessLogic{
	
	private DAOFactory factory;
	
	public ProveedorBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void registrarProveedor(ProveedorDomain proveedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean confirmarDatosProveedor(ProveedorDomain proveedor, TokenConfirmacionDomain token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProveedorDomain consultarProveedorPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProveedorDomain> consultarProveedores(ProveedorDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDatosProveedor(UUID id, ProveedorDomain proveedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elegirCiudad(List<CiudadDomain> ciudad) {
		// TODO Auto-generated method stub
		
	}

}
