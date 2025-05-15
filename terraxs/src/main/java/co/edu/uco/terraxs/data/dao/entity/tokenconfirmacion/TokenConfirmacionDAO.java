package co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.TokenConfirmacionEntity;


public interface TokenConfirmacionDAO extends CreateDAO<TokenConfirmacionEntity>, RetrieveDAO<TokenConfirmacionEntity, UUID>,UpdateDAO<TokenConfirmacionEntity,UUID>,DeleteDAO<UUID>{

}