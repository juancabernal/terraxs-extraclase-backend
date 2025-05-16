package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoEstadoDomain;

public interface TipoEstadoBusinessLogic {
	
	TipoEstadoDomain consultarTipoEstadoPorId(UUID id);
	
	List<TipoEstadoDomain> consultarEstados(TipoEstadoDomain filtro);
}


