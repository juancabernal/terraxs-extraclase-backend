package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.DetallePedidoDTO;

public interface DetallePedidoFacade {
	
	void registrarNuevoDetallePedido(DetallePedidoDTO detallePedido);
	
	DetallePedidoDTO consultarDetallePedidoPorId(UUID id);

	List<DetallePedidoDTO> consultarDetallesPedido(DetallePedidoDTO filtro);

}
