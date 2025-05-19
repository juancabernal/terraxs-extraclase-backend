package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.MetodoPagoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePagoDomain;

public interface DetallePagoBusinessLogic {
	
	void registrarNuevoDetallePago(DetallePagoDomain detallePago) throws TerraxsException; 
	
	DetallePagoDomain consultarDetallePagoPorId(UUID id) throws TerraxsException;

	List<DetallePagoDomain> consultarDetallesPago(DetallePagoDomain filtro) throws TerraxsException;
	
	void elegirMetodoPago(List<MetodoPagoDomain> metodoPago) throws TerraxsException;
	
	void asignarMontoPorMétodo(UUID id, DetallePagoDomain detallePago) throws TerraxsException;

}



