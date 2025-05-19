package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoEstadoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface TipoEstadoBusinessLogic {
	
	TipoEstadoDomain consultarTipoEstadoPorId(UUID id) throws TerraxsException;
	
	List<TipoEstadoDomain> consultarEstados(TipoEstadoDomain filtro) throws TerraxsException;
}


