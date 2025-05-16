package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;
import java.util.List;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CategoriaProductoDomain;

public interface CategoriaProductoBusinessLogic {
	
	void crearNuevaCategoria(CategoriaProductoDomain categoria);
	
	void actualizarCategoria(UUID id, CategoriaProductoDomain categoria);

	void eliminarCategoria(UUID id);

	CategoriaProductoDomain consultarCategoriaPorId(UUID id);

	List<CategoriaProductoDomain> consultarCategoroias(CategoriaProductoDomain filtro);


}



