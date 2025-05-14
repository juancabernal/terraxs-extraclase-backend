package co.edu.uco.terraxs.data.dao.entity.administrador;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.AdministradorEntity;


public interface AdministradorDAO extends CreateDAO<AdministradorEntity>, RetrieveDAO<AdministradorEntity, UUID>,UpdateDAO<AdministradorEntity,UUID>,DeleteDAO<UUID>{

}


