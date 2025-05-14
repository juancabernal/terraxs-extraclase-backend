package co.edu.co.onlinetest.data.dao.entity.departamento;
import java.util.UUID;

import co.edu.co.onlinetest.data.dao.entity.CreateDAO;
import co.edu.co.onlinetest.data.dao.entity.DeleteDAO;
import co.edu.co.onlinetest.data.dao.entity.RetrieveDAO;
import co.edu.co.onlinetest.data.dao.entity.UpdateDAO;
import co.edu.co.onlinetest.entity.DepartamentoEntity;





public interface DepartamentoDAO extends CreateDAO<DepartamentoEntity>, RetrieveDAO<DepartamentoEntity, UUID>,UpdateDAO<DepartamentoEntity,UUID>,DeleteDAO<UUID>  {
	

}
