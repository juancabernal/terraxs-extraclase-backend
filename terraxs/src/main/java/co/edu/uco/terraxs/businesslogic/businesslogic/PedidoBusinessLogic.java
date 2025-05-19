package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePedidoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PedidoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface PedidoBusinessLogic {
	
	void realizarPedido(PedidoDomain pedido) throws TerraxsException;
	
	double consultarCostoPedido(UUID id) throws TerraxsException;
	
	PedidoDomain consultarEstadoPedido(UUID id) throws TerraxsException;
	
	PedidoDomain actualizarEstadoPedido(UUID id) throws TerraxsException;
			
	void cancelarPedido(UUID id) throws TerraxsException;
	
}





