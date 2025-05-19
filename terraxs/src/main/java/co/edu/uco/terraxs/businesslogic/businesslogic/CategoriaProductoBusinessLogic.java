package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;
import java.util.List;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface CategoriaProductoBusinessLogic {
	
	void crearNuevaCategoria(CategoriaProductoDomain categoria) throws TerraxsException;
	
	void actualizarCategoria(UUID id, CategoriaProductoDomain categoria) throws TerraxsException;

	void eliminarCategoria(UUID id) throws TerraxsException;

	CategoriaProductoDomain consultarCategoriaPorId(UUID id) throws TerraxsException;

	List<CategoriaProductoDomain> consultarCategoroias(CategoriaProductoDomain filtro) throws TerraxsException;


}



