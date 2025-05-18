
package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.TipoDocumentoDTO;

public interface TipoDocumentoFacade {
	
	TipoDocumentoDTO consultarTipoDocumentoPorId(UUID id);
	
	List<TipoDocumentoDTO> consultarTiposDocumento(TipoDocumentoDTO filtro);

}
