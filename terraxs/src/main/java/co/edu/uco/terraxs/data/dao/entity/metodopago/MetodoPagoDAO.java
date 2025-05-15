package co.edu.uco.terraxs.data.dao.entity.metodopago;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.MetodoPagoEntity;

public interface MetodoPagoDAO extends CreateDAO<MetodoPagoEntity>, RetrieveDAO<MetodoPagoEntity, UUID>,UpdateDAO<MetodoPagoEntity,UUID>,DeleteDAO<UUID>{

}


