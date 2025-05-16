package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePedidoDomain;

public interface DetallePedidoBusinessLogic {
	
void registrarNuevoDetallePedido(DetallePedidoDomain detallePedido);
	
	DetallePedidoDomain consultarDetallePedidoPorId(UUID id);

	List<DetallePedidoDomain> consultarDetallesPedido(DetallePedidoDomain filtro);

}
