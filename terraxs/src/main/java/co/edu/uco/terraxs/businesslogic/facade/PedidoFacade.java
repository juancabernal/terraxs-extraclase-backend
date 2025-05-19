package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.dto.PedidoDTO;

public interface PedidoFacade {
	
	void realizarPedido(PedidoDTO pedido) throws TerraxsException;
	
	double consultarCostoPedido(UUID id) throws TerraxsException;
	
	PedidoDTO consultarEstadoPedido(UUID id) throws TerraxsException;
	
	void actualizarEstadoPedido(UUID id) throws TerraxsException;
			
	void cancelarPedido(UUID id) throws TerraxsException;
	
}





