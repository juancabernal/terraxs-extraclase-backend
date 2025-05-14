package co.edu.uco.terraxs.data.dao.entity.cliente;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.ClienteEntity;

public interface ClienteDAO extends CreateDAO<ClienteEntity>, RetrieveDAO<ClienteEntity, UUID>,UpdateDAO<ClienteEntity,UUID>,DeleteDAO<UUID>{

}
