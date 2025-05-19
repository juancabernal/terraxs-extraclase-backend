package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CategoriaProductoDTO;

public interface CategoriaProductoFacade {

	void crearNuevaCategoria(CategoriaProductoDTO categoria) throws TerraxsException;
	
	void actualizarCategoria(UUID id, CategoriaProductoDTO categoria) throws TerraxsException;

	void eliminarCategoria(UUID id) throws TerraxsException;

	CategoriaProductoDTO consultarCategoriaPorId(UUID id) throws TerraxsException;

	List<CategoriaProductoDTO> consultarCategoroias(CategoriaProductoDTO filtro) throws TerraxsException;
	
}
