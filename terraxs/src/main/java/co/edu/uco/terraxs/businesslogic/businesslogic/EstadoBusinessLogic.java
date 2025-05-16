package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;

public interface EstadoBusinessLogic {
	
	EstadoDomain consultarEstadoPorId(UUID id);
	
	List<EstadoDomain> consultarEstados(EstadoDomain filtro);

}
