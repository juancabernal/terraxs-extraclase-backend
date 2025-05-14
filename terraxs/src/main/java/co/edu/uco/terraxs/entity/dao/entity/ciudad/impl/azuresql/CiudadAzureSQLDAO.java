package co.edu.co.onlinetest.data.dao.entity.ciudad.impl.azuresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.onlinetest.data.dao.entity.ciudad.CiudadDAO;
import co.edu.co.onlinetest.entity.CiudadEntity;

public class CiudadAzureSQLDAO implements CiudadDAO {
	
	private Connection conexion;
	
	public CiudadAzureSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(CiudadEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CiudadEntity> listByFilter(CiudadEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadEntity> listALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, CiudadEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}



	

}
