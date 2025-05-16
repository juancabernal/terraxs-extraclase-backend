package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePedidoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PedidoDomain;

public interface PedidoBusinessLogic {
	
	void realizarPedido(PedidoDomain pedido);
	
	double consultarCostoPedido(UUID id);
	
	EstadoDomain consultarEstadoPedido(UUID id);
	
	EstadoDomain ActualizarEstadoPedido(UUID id);
	
	DetallePedidoDomain verDetallesPedido(UUID id,DetallePedidoDomain detallesPedido);
		
	void cancelarPedido(UUID id);
	
}





