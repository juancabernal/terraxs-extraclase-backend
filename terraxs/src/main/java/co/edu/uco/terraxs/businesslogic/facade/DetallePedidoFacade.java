package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.DetallePedidoDTO;

public interface DetallePedidoFacade {
	
	void registrarNuevoDetallePedido(DetallePedidoDTO detallePedido) throws TerraxsException;
	
	DetallePedidoDTO consultarDetallePedidoPorId(UUID id) throws TerraxsException;

	List<DetallePedidoDTO> consultarDetallesPedido(DetallePedidoDTO filtro) throws TerraxsException;

}
