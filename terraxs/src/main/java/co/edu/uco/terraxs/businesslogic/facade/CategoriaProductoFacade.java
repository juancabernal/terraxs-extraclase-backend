package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.CategoriaProductoDTO;

public interface CategoriaProductoFacade {

	void crearNuevaCategoria(CategoriaProductoDTO categoria);
	
	void actualizarCategoria(UUID id, CategoriaProductoDTO categoria);

	void eliminarCategoria(UUID id);

	CategoriaProductoDTO consultarCategoriaPorId(UUID id);

	List<CategoriaProductoDTO> consultarCategoroias(CategoriaProductoDTO filtro);
	
}
