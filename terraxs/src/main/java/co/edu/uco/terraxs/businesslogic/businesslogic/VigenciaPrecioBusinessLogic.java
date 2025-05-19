package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;
import java.util.List;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.VigenciaPrecioDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface VigenciaPrecioBusinessLogic {
	
	void crearVigencia(VigenciaPrecioDomain vigenciaPrecio) throws TerraxsException;
	
	
	void actualizarVigencia(UUID id, VigenciaPrecioDomain categoria) throws TerraxsException;


	VigenciaPrecioDomain consultarVigencia(UUID id,VigenciaPrecioDomain vigenciaPrecio ) throws TerraxsException;



}



