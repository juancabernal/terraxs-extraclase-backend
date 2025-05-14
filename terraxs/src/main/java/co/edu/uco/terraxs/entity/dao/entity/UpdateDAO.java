package co.edu.co.onlinetest.data.dao.entity;


public interface UpdateDAO<E, ID> {
	
	void update(ID id,E entity);
	
	
	
}
