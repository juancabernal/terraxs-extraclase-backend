package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface TipoDocumentoBusinessLogic {
	
	TipoDocumentoDomain consultarTipoDocumentoPorId(UUID id) throws TerraxsException;
	
	List<TipoDocumentoDomain> consultarTiposDocumento(TipoDocumentoDomain filtro) throws TerraxsException;

}

