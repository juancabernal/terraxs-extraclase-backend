package co.edu.uco.terraxs.businesslogic.facade;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.DetallePagoDTO;
import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.dto.PagoDTO;

public interface PagoFacade {
	
	void realizarPago(PagoDTO pago) throws TerraxsException;
	
	PagoDTO consultarInformacionPago(UUID id) throws TerraxsException;
	
	void actualizarEstadoPago(UUID id, PagoDTO pago) throws TerraxsException; 
	
	boolean confirmarPago(UUID id) throws TerraxsException;
		
	void cancelarPago(UUID id) throws TerraxsException;
	
}





