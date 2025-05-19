package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.dto.PedidoDTO;

public interface PedidoFacade {
	
	void realizarPedido(PedidoDTO pedido);
	
	double consultarCostoPedido(UUID id);
	
	EstadoDTO consultarEstadoPedido(UUID id);
	
	EstadoDTO ActualizarEstadoPedido(UUID id);
			
	void cancelarPedido(UUID id);
	
}





