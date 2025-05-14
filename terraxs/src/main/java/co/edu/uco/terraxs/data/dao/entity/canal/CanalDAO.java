package co.edu.uco.terraxs.data.dao.entity.canal;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.CanalEntity;

public interface CanalDAO extends CreateDAO<CanalEntity>, RetrieveDAO<CanalEntity, UUID>,UpdateDAO<CanalEntity,UUID>,DeleteDAO<UUID>{

}
