package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.ciudad.entity.CiudadEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.departamento.entity.DepartamentoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.entity.PaisEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.entity.DepartamentoEntity;

public class DepartamentoBusinessLogicImpl implements DepartamentoBusinessLogic{
	
	private DAOFactory factory;
	
	public DepartamentoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void registrarNuevoDepartamento(DepartamentoDomain departamento) throws TerraxsException {
		var departamentoEntity =  DepartamentoEntityAssembler.getInstance().toEntity(departamento);
		factory.getDepartamentoDAO().create(departamentoEntity);
		
		
	}


	@Override
	public DepartamentoDomain consultarDepartamentoPorId(UUID id) throws TerraxsException {
		var departamentoEntity = factory.getDepartamentoDAO().listById(id);
		return  DepartamentoEntityAssembler.getInstance().toDomain(departamentoEntity);
		
	}

	@Override
	public List<DepartamentoDomain> consultarDepartamentos(DepartamentoDomain filtro) throws TerraxsException {
		var departamentoFilter = DepartamentoEntityAssembler.getInstance().toEntity(filtro);
		var departamentoEntities = factory.getDepartamentoDAO().listByFilter(departamentoFilter);
		
		return DepartamentoEntityAssembler.getInstance().toDomain(departamentoEntities);
	}
	


	@Override
	public void modificarDepartamentoExistente(UUID id, DepartamentoDomain departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteDepartamentoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<DepartamentoDomain> consultarDepartamentosPorPais(UUID paisId) throws TerraxsException {
		var paisEntity = PaisEntityAssembler.getInstance().toEntity(new PaisDomain(paisId));
	    
	    var departamentoFiltro = DepartamentoEntity.obtenerValorDefecto();
	    departamentoFiltro.setPais(paisEntity);
	    
	    var departamentosEntity = factory.getDepartamentoDAO().listByFilter(departamentoFiltro);
	    
	    return DepartamentoEntityAssembler.getInstance().toDomain(departamentosEntity);
	}



}
