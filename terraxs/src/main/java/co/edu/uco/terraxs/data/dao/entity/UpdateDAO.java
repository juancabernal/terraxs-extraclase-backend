package co.edu.uco.terraxs.data.dao.entity;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface UpdateDAO<E, ID> {
	
	void update(ID id,E entity) throws TerraxsException;
	
	
	
}