package co.edu.uco.terraxs.data.dao.entity.tiponotificacion;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.TipoNotificacionEntity;


public interface TipoNotificacionDAO extends CreateDAO<TipoNotificacionEntity>, RetrieveDAO<TipoNotificacionEntity, UUID>,UpdateDAO<TipoNotificacionEntity,UUID>,DeleteDAO<UUID>{

}
