package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;

public interface TipoDocumentoBusinessLogic {
	
	TipoDocumentoDomain consultarTipoDocumentoPorId(UUID id);
	
	List<TipoDocumentoDomain> consultarTiposDocumento(TipoDocumentoDomain filtro);

}

