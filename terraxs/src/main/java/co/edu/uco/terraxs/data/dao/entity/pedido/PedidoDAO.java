package co.edu.uco.terraxs.data.dao.entity.pedido;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.PedidoEntity;

public interface PedidoDAO extends CreateDAO<PedidoEntity>, RetrieveDAO<PedidoEntity, UUID>,UpdateDAO<PedidoEntity,UUID>,DeleteDAO<UUID>{

}

