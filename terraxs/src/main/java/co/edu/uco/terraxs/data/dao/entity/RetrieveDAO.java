package co.edu.uco.terraxs.data.dao.entity;

import java.util.List;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface RetrieveDAO<E, ID> {
	
	List<E> listByFilter(E filter) throws TerraxsException;
	
	
	List<E> listALL() throws TerraxsException;

	E listById(ID id) throws TerraxsException;


	

}
