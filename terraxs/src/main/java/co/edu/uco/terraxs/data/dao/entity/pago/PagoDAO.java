package co.edu.uco.terraxs.data.dao.entity.pago;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.PagoEntity;

public interface PagoDAO extends CreateDAO<PagoEntity>, RetrieveDAO<PagoEntity, UUID>,UpdateDAO<PagoEntity,UUID>,DeleteDAO<UUID>{

}

