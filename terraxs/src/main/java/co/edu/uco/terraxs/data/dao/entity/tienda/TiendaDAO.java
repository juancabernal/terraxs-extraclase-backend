package co.edu.uco.terraxs.data.dao.entity.tienda;


import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.TiendaEntity;


public interface TiendaDAO extends CreateDAO<TiendaEntity>, RetrieveDAO<TiendaEntity, UUID>,UpdateDAO<TiendaEntity,UUID>,DeleteDAO<UUID>{

}
