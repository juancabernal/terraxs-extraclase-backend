package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.VigenciaPrecioBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.VigenciaPrecioDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class VigenciaPrecioBusinessLogicImpl implements VigenciaPrecioBusinessLogic{
	
	private DAOFactory factory;
	
	public VigenciaPrecioBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public void crearVigencia(VigenciaPrecioDomain vigenciaPrecio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarVigencia(UUID id, VigenciaPrecioDomain categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VigenciaPrecioDomain consultarVigencia(UUID id, VigenciaPrecioDomain vigenciaPrecio) {
		// TODO Auto-generated method stub
		return null;
	}
}


