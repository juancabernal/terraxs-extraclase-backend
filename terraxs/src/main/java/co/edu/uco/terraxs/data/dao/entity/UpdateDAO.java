package co.edu.uco.terraxs.data.dao.entity;

public interface UpdateDAO<E, ID> {
	
	void update(ID id,E entity);
	
	
	
}