package co.edu.uco.terraxs.data.dao.entity;

import java.util.List;

public interface RetrieveDAO<E, ID> {
	
	List<E> listByFilter(E filter);
	
	
	List<E> listALL();

	E listById(ID id);


	

}
