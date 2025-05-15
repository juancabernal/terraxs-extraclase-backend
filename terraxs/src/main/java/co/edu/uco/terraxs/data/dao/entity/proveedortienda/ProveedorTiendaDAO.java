package co.edu.uco.terraxs.data.dao.entity.proveedortienda;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.ProveedorTiendaEntity;

public interface ProveedorTiendaDAO extends CreateDAO<ProveedorTiendaEntity>, RetrieveDAO<ProveedorTiendaEntity, UUID>,UpdateDAO<ProveedorTiendaEntity,UUID>,DeleteDAO<UUID>{

}
