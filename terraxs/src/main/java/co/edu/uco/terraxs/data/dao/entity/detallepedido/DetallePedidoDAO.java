package co.edu.uco.terraxs.data.dao.entity.detallepedido;

import java.util.UUID;

import co.edu.uco.terraxs.data.dao.entity.CreateDAO;
import co.edu.uco.terraxs.data.dao.entity.DeleteDAO;
import co.edu.uco.terraxs.data.dao.entity.RetrieveDAO;
import co.edu.uco.terraxs.data.dao.entity.UpdateDAO;
import co.edu.uco.terraxs.entity.DetallePedidoEntity;


public interface DetallePedidoDAO extends CreateDAO<DetallePedidoEntity>, RetrieveDAO<DetallePedidoEntity, UUID>,UpdateDAO<DetallePedidoEntity,UUID>,DeleteDAO<UUID>{

}

