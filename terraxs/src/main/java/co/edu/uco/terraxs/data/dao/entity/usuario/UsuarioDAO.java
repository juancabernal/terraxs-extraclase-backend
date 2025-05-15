package co.edu.uco.terraxs.data.dao.entity.usuario;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.UsuarioEntity;


public interface UsuarioDAO extends CreateDAO<UsuarioEntity>, RetrieveDAO<UsuarioEntity, UUID>,UpdateDAO<UsuarioEntity,UUID>,DeleteDAO<UUID>{

}
