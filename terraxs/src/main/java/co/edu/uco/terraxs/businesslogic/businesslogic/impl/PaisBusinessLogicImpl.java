package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.entity.PaisEntity;

public class PaisBusinessLogicImpl implements PaisBusinessLogic {
	
	private DAOFactory factory;
	
	public PaisBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public void registrarNuevoPais(PaisDomain pais) throws TerraxsException {
		PaisEntity paisEntity=null;      //Magia de traducir de domain a entity
		factory.getPaisDAO().create(paisEntity);
	}

	@Override
	public void modificarPaisExistente(UUID id, PaisDomain pais) throws TerraxsException {
		PaisEntity paisEntity=null;
		factory.getPaisDAO().update(id,paisEntity);


	}

	@Override
	public void darBajaDefinitivamentePaisExistente(UUID id) throws TerraxsException {

		factory.getPaisDAO().delete(id);

	}

	@Override
	public PaisDomain consultarPaisPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDomain> consultarPaises(PaisDomain filtro) throws TerraxsException {
		
		PaisEntity paisFilter=null;   //Magia de traducir de domain a entity
		List<PaisEntity>paisEntities= factory.getPaisDAO().listByFilter(paisFilter)	;
		
		List<PaisDomain> datosARetornar=null;    //Magia de traducir de entitys a domain
		return datosARetornar;
	}

}