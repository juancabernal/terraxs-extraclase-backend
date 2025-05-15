package co.edu.uco.terraxs.data.dao.entity.productoproveedor;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.ProductoProveedorEntity;

public interface ProductoProveedorDAO extends CreateDAO<ProductoProveedorEntity>, RetrieveDAO<ProductoProveedorEntity, UUID>,UpdateDAO<ProductoProveedorEntity,UUID>,DeleteDAO<UUID>{

}
