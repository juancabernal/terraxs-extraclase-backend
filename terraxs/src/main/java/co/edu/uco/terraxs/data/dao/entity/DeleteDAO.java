package co.edu.uco.terraxs.data.dao.entity;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface DeleteDAO< ID> {
	
	void delete(ID id) throws TerraxsException;
	
		
}
