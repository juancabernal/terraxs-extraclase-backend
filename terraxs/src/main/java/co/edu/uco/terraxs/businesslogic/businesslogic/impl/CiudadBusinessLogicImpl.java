package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class CiudadBusinessLogicImpl implements CiudadBusinessLogic{
	
	private DAOFactory factory;
	
	public CiudadBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void registrarNuevaCiudad(CiudadDomain ciudad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCiduadExistente(UUID id, CiudadDomain ciudad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCiudadExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CiudadDomain consultarCiudadPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadDomain> consultarCiudades(CiudadDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void elegirDepartamento(List<DepartamentoDomain> pais) {
		// TODO Auto-generated method stub
		
	}

}
