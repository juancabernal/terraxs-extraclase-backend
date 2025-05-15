package co.edu.uco.terraxs.data.dao.entity.producto;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.ProductoEntity;

public interface ProductoDAO extends CreateDAO<ProductoEntity>, RetrieveDAO<ProductoEntity, UUID>,UpdateDAO<ProductoEntity,UUID>,DeleteDAO<UUID>{

}
