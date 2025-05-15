package co.edu.uco.terraxs.data.dao.entity.detallepago;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.DetallePagoEntity;


public interface DetallePagoDAO extends CreateDAO<DetallePagoEntity>, RetrieveDAO<DetallePagoEntity, UUID>,UpdateDAO<DetallePagoEntity,UUID>,DeleteDAO<UUID>{

}
