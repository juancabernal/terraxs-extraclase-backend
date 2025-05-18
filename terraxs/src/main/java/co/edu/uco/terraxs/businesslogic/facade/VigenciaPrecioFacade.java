package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;
import java.util.List;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.VigenciaPrecioDomain;
import co.edu.uco.terraxs.dto.VigenciaPrecioDTO;

public interface VigenciaPrecioFacade {
	
	void crearVigencia(VigenciaPrecioDTO vigenciaPrecio);
	
	
	void actualizarVigencia(UUID id, VigenciaPrecioDTO categoria);


	VigenciaPrecioDTO consultarVigencia(UUID id,VigenciaPrecioDTO vigenciaPrecio );



}



