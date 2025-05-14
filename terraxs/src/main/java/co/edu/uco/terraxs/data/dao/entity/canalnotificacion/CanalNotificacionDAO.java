package co.edu.uco.terraxs.data.dao.entity.canalnotificacion;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.CanalNotificacionEntity;

public interface CanalNotificacionDAO extends CreateDAO<CanalNotificacionEntity>, RetrieveDAO<CanalNotificacionEntity, UUID>,UpdateDAO<CanalNotificacionEntity,UUID>,DeleteDAO<UUID>  {

}
