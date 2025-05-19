package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.dto.DetallePagoDTO;
import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.dto.PagoDTO;

public interface PagoFacade {
	
	void realizarPago(PagoDTO pago);
	
	
	PagoDTO consultarInformacionPago(UUID id);
	
	EstadoDTO actualizarEstadoPago(UUID id);

	DetallePagoDTO verDetallesPago(UUID id,DetallePagoDTO detallePago);
	
	boolean confirmarPago(UUID id);
		
	void cancelarPago(UUID id);
	
}





