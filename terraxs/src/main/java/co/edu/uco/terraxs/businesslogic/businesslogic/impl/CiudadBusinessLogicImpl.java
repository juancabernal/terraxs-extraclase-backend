package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.ciudad.entity.CiudadEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.entity.PaisEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
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
	public CiudadDomain consultarCiudadPorId(UUID id) throws TerraxsException {
		var ciudadEntity = factory.getCiudadDAO().listById(id);
		return  CiudadEntityAssembler.getInstance().toDomain(ciudadEntity);
		
	}

	@Override
	public List<CiudadDomain> consultarCiudades(CiudadDomain filtro) throws TerraxsException {
		var ciudadFilter = CiudadEntityAssembler.getInstance().toEntity(filtro);
		var ciudadEntities = factory.getCiudadDAO().listByFilter(ciudadFilter);
		return CiudadEntityAssembler.getInstance().toDomain(ciudadEntities);
	}

	@Override
	public void elegirDepartamento(List<DepartamentoDomain> pais) {
		// TODO Auto-generated method stub
		
	}

}
