package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePagoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PagoDomain;

public interface PagoBusinessLogic {
	
	void realizarPago(PagoDomain pago);
	
	
	PagoDomain consultarInformacionPago(UUID id);
	
	EstadoDomain actualizarEstadoPago(UUID id);

	DetallePagoDomain verDetallesPago(UUID id,DetallePagoDomain detallePago);
	
	boolean confirmarPago(UUID id);
		
	void cancelarPago(UUID id);
	
}





