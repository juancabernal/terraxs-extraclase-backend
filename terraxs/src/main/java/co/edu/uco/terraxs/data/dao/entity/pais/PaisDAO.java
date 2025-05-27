package co.edu.uco.terraxs.data.dao.entity.pais;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.entity.PaisEntity;


public interface PaisDAO extends CreateDAO<PaisEntity>, RetrieveDAO<PaisEntity, UUID>,UpdateDAO<PaisEntity,UUID>,DeleteDAO<UUID>  {
	

}