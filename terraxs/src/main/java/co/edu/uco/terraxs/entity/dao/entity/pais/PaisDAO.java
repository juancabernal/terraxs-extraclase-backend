package co.edu.co.onlinetest.data.dao.entity.pais;
import java.util.UUID;

import co.edu.co.onlinetest.data.dao.entity.CreateDAO;
import co.edu.co.onlinetest.data.dao.entity.UpdateDAO;
import co.edu.co.onlinetest.data.dao.entity.RetrieveDAO;
import co.edu.co.onlinetest.data.dao.entity.DeleteDAO;
import co.edu.co.onlinetest.entity.PaisEntity;





public interface PaisDAO extends CreateDAO<PaisEntity>, RetrieveDAO<PaisEntity, UUID>,UpdateDAO<PaisEntity,UUID>,DeleteDAO<UUID>  {
	

}
