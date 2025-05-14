package co.edu.uco.terraxs.data.dao.entity.carritocompras;

import java.util.UUID;
import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.CarritoComprasEntity;

public interface CarritoComprasDAO extends CreateDAO<CarritoComprasEntity>, RetrieveDAO<CarritoComprasEntity, UUID>,UpdateDAO<CarritoComprasEntity,UUID>,DeleteDAO<UUID>{

}


