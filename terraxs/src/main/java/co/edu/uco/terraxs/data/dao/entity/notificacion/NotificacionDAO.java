package co.edu.uco.terraxs.data.dao.entity.notificacion;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.NotificacionEntity;

public interface NotificacionDAO extends CreateDAO<NotificacionEntity>, RetrieveDAO<NotificacionEntity, UUID>,UpdateDAO<NotificacionEntity,UUID>,DeleteDAO<UUID>{

}


