package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.DepartamentoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.DepartamentoFacade;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.DepartamentoDTO;
import co.edu.uco.terraxs.dto.PaisDTO;

public class DepartamentoFacadeImpl implements DepartamentoFacade{
	
	private DAOFactory daoFactory;
	private DepartamentoBusinessLogic departamentoBusinessLogic;
	
	
	public DepartamentoFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		departamentoBusinessLogic = new DepartamentoBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarNuevoDepartamento(DepartamentoDTO departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDepartamentoExistente(UUID id, DepartamentoDTO departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteDepartamentoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartamentoDTO consultarDepartamentoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDTO> consultarDepartamentos(DepartamentoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void elegirPais(List<PaisDTO> pais) {
		// TODO Auto-generated method stub
		
	}

}
