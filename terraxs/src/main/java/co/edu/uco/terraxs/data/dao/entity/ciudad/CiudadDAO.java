package co.edu.uco.terraxs.data.dao.entity.ciudad;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.CiudadEntity;





public interface CiudadDAO extends CreateDAO<CiudadEntity>, RetrieveDAO<CiudadEntity, UUID>,UpdateDAO<CiudadEntity,UUID>,DeleteDAO<UUID>  {
	

}