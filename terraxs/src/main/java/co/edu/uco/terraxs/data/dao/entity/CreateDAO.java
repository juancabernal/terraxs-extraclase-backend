package co.edu.uco.terraxs.data.dao.entity;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface CreateDAO<E> {
	
	void create(E entity) throws TerraxsException;
	

}

