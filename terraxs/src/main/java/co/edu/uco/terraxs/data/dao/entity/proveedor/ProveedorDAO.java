package co.edu.uco.terraxs.data.dao.entity.proveedor;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.ProveedorEntity;

public interface ProveedorDAO extends CreateDAO<ProveedorEntity>, RetrieveDAO<ProveedorEntity, UUID>,UpdateDAO<ProveedorEntity,UUID>,DeleteDAO<UUID>{

}
