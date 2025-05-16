package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TipoDocumentoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class TipoDocumentoBusinessLogicImpl implements TipoDocumentoBusinessLogic{
	
	private DAOFactory factory;
	
	public TipoDocumentoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public TipoDocumentoDomain consultarTipoDocumentoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoDocumentoDomain> consultarTiposDocumento(TipoDocumentoDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
