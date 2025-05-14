package co.edu.uco.terraxs.data.dao.entity.clientetienda;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.ClienteTiendaEntity;

public interface ClienteTiendaDAO extends CreateDAO<ClienteTiendaEntity>, RetrieveDAO<ClienteTiendaEntity, UUID>,UpdateDAO<ClienteTiendaEntity,UUID>,DeleteDAO<UUID> {

}
