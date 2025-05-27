package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.TipoDocumentoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.entity.PaisEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipodocumento.entity.TipoDocumentoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class TipoDocumentoBusinessLogicImpl implements TipoDocumentoBusinessLogic{
	
	private DAOFactory factory;
	
	public TipoDocumentoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public TipoDocumentoDomain consultarTipoDocumentoPorId(UUID id) throws TerraxsException {
		var tipoDocumentoEntity = factory.getTipoDocumentoDAO().listById(id);
		return  TipoDocumentoEntityAssembler.getInstance().toDomain(tipoDocumentoEntity);
		
	}

	@Override
	public List<TipoDocumentoDomain> consultarTiposDocumento(TipoDocumentoDomain filtro) throws TerraxsException {
		var tipoDocumentoFilter = TipoDocumentoEntityAssembler.getInstance().toEntity(filtro);
		var tipoDocumentoEntities = factory.getTipoDocumentoDAO().listByFilter(tipoDocumentoFilter);
		
		return TipoDocumentoEntityAssembler.getInstance().toDomain(tipoDocumentoEntities);
	}

}
