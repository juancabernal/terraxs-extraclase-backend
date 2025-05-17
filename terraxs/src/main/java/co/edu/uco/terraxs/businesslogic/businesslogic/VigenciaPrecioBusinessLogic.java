package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;
import java.util.List;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.VigenciaPrecioDomain;

public interface VigenciaPrecioBusinessLogic {
	
	void crearVigencia(VigenciaPrecioDomain vigenciaPrecio);
	
	
	void actualizarVigencia(UUID id, VigenciaPrecioDomain categoria);


	VigenciaPrecioDomain consultarVigencia(UUID id,VigenciaPrecioDomain vigenciaPrecio );



}



