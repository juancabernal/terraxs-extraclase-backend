package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePedidoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface DetallePedidoBusinessLogic {
	
	
	DetallePedidoDomain consultarDetallePedidoPorId(UUID id) throws TerraxsException;

	List<DetallePedidoDomain> consultarDetallesPedido(DetallePedidoDomain filtro) throws TerraxsException;

}
