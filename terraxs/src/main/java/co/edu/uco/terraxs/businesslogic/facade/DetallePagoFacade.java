package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.DetallePagoDTO;
import co.edu.uco.terraxs.dto.MetodoPagoDTO;

public interface DetallePagoFacade {
	
	void registrarNuevoDetallePago(DetallePagoDTO detallePago) throws TerraxsException;
	
	DetallePagoDTO consultarDetallePagoPorId(UUID id) throws TerraxsException;

	List<DetallePagoDTO> consultarDetallesPago(DetallePagoDTO filtro) throws TerraxsException;
	
	void elegirMetodoPago(List<MetodoPagoDTO> metodoPago) throws TerraxsException;
	
	void asignarMontoPorMétodo(UUID id, DetallePagoDTO detallePago) throws TerraxsException;

}
