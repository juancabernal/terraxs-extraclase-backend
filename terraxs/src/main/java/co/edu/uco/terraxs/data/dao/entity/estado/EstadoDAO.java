package co.edu.uco.terraxs.data.dao.entity.estado;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.EstadoEntity;

public interface EstadoDAO extends CreateDAO<EstadoEntity>, RetrieveDAO<EstadoEntity, UUID>,UpdateDAO<EstadoEntity,UUID>,DeleteDAO<UUID>{

}



