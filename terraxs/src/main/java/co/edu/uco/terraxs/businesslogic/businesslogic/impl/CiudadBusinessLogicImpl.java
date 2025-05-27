package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.ciudad.entity.CiudadEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.entity.CiudadEntity;
import co.edu.uco.terraxs.entity.DepartamentoEntity;

public class CiudadBusinessLogicImpl implements CiudadBusinessLogic{
	
	private DAOFactory factory;
	
	public CiudadBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void registrarNuevaCiudad(CiudadDomain ciudad) throws TerraxsException {
		var ciudadEntity =  CiudadEntityAssembler.getInstance().toEntity(ciudad);
		factory.getCiudadDAO().create(ciudadEntity);
		
		
	}


	@Override
	public void modificarCiudadExistente(UUID id, CiudadDomain ciudad) throws TerraxsException {
		var ciudadEntity = CiudadEntityAssembler.getInstance().toEntity(ciudad); //Magia de traducir de domain -> entity
		factory.getCiudadDAO().update(id, ciudadEntity);
	}
	@Override
	public void darBajaDefinitivamenteCiudadExistente(UUID id) throws TerraxsException {
		factory.getCiudadDAO().delete(id);
		
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


	public List<CiudadDomain> consultarCiudadesPorDepartamento(UUID departamentoId) throws TerraxsException {
	    var departamentoEntity = DepartamentoEntity.obtenerValorDefecto();
	    departamentoEntity.setId(departamentoId);
	    
	    var ciudadFiltro = CiudadEntity.obtenerValorDefecto();
	    ciudadFiltro.setDepartamento(departamentoEntity);
	    
	    var ciudadesEntity = factory.getCiudadDAO().listByFilter(ciudadFiltro);
	    
	    return CiudadEntityAssembler.getInstance().toDomain(ciudadesEntity);

	}

}
