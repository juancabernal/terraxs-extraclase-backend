package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TipoDocumentoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.TipoDocumentoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.TipoDocumentoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class TipoDocumentoFacadeImpl implements TipoDocumentoFacade {
	
	private DAOFactory daoFactory;
	private TipoDocumentoBusinessLogic tipoDocumentoBusinessLogic;
	
	
	public TipoDocumentoFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		tipoDocumentoBusinessLogic = new TipoDocumentoBusinessLogicImpl(daoFactory);
	}

	@Override
	public TipoDocumentoDTO consultarTipoDocumentoPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoDocumentoDTO> consultarTiposDocumento(TipoDocumentoDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

}
