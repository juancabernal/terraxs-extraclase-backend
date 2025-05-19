package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePagoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PagoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface PagoBusinessLogic {
	
	void realizarPago(PagoDomain pago);
	
	
	PagoDomain consultarInformacionPago(UUID id) throws TerraxsException;
	
	EstadoDomain actualizarEstadoPago(UUID id) throws TerraxsException;

	DetallePagoDomain verDetallesPago(UUID id,DetallePagoDomain detallePago) throws TerraxsException;
	
	boolean confirmarPago(UUID id) throws TerraxsException;
		
	void cancelarPago(UUID id) throws TerraxsException;
	
}





