
package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;

public interface TipoDocumentoFacade {
	
	TipoDocumentoDTO consultarTipoDocumentoPorId(UUID id) throws TerraxsException;
	
	List<TipoDocumentoDTO> consultarTiposDocumento(TipoDocumentoDTO filtro) throws TerraxsException;

}
