package co.edu.uco.terraxs.data.dao.entity.categoriaproducto;

import java.util.UUID;
import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.CategoriaProductoEntity;


public interface CategoriaProductoDAO extends CreateDAO<CategoriaProductoEntity>, RetrieveDAO<CategoriaProductoEntity, UUID>,UpdateDAO<CategoriaProductoEntity,UUID>,DeleteDAO<UUID>  {

}
