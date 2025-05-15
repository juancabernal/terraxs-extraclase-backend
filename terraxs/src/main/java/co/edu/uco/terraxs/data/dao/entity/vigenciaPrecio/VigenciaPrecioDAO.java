package co.edu.uco.terraxs.data.dao.entity.vigenciaPrecio;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.VigenciaPrecioEntity;


public interface VigenciaPrecioDAO extends CreateDAO<VigenciaPrecioEntity>, RetrieveDAO<VigenciaPrecioEntity, UUID>,UpdateDAO<VigenciaPrecioEntity,UUID>,DeleteDAO<UUID>{

}
