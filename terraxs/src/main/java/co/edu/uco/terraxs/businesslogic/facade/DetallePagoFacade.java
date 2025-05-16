package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.DetallePagoDTO;
import co.edu.uco.terraxs.dto.MetodoPagoDTO;

public interface DetallePagoFacade {
	
	void registrarNuevoDetallePago(DetallePagoDTO detallePago);
	
	DetallePagoDTO consultarDetallePagoPorId(UUID id);

	List<DetallePagoDTO> consultarDetallesPago(DetallePagoDTO filtro);
	
	void elegirMetodoPago(List<MetodoPagoDTO> metodoPago);
	
	void asignarMontoPorMétodo(UUID id, DetallePagoDTO detallePago);

}
