package co.edu.uco.terraxs.data.dao.entity.productocarritocompras;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.ProductoCarritoComprasEntity;

public interface ProductoCarritoComprasDAO extends CreateDAO<ProductoCarritoComprasEntity>, RetrieveDAO<ProductoCarritoComprasEntity, UUID>,UpdateDAO<ProductoCarritoComprasEntity,UUID>,DeleteDAO<UUID>{

}
