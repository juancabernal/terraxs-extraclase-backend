package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.MetodoPagoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePagoDomain;

public interface DetallePagoBusinessLogic {
	
	void registrarNuevoDetallePago(DetallePagoDomain detallePago);
	
	DetallePagoDomain consultarDetallePagoPorId(UUID id);

	List<DetallePagoDomain> consultarDetallesPago(DetallePagoDomain filtro);
	
	void elegirMetodoPago(List<MetodoPagoDomain> metodoPago);
	
	void asignarMontoPorMétodo(UUID id, DetallePagoDomain detallePago);

}



