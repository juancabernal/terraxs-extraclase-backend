package co.edu.uco.terraxs.data.dao.entity.unidad;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.UnidadEntity;


public interface UnidadDAO extends CreateDAO<UnidadEntity>, RetrieveDAO<UnidadEntity, UUID>,UpdateDAO<UnidadEntity,UUID>,DeleteDAO<UUID>{

}