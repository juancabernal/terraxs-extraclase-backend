package co.edu.uco.terraxs.data.dao.entity.tipodocumento;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.TipoDocumentoEntity;


public interface TipoDocumentoDAO extends CreateDAO<TipoDocumentoEntity>, RetrieveDAO<TipoDocumentoEntity, UUID>,UpdateDAO<TipoDocumentoEntity,UUID>,DeleteDAO<UUID>{

}