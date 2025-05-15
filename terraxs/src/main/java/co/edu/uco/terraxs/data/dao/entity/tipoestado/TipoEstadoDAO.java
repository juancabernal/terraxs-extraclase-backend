package co.edu.uco.terraxs.data.dao.entity.tipoestado;
import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.TipoEstadoEntity;


public interface TipoEstadoDAO extends CreateDAO<TipoEstadoEntity>, RetrieveDAO<TipoEstadoEntity, UUID>,UpdateDAO<TipoEstadoEntity,UUID>,DeleteDAO<UUID>{

}
