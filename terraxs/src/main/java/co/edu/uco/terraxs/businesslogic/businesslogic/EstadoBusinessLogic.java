package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface EstadoBusinessLogic {
	
	EstadoDomain consultarEstadoPorId(UUID id) throws TerraxsException;
	
	List<EstadoDomain> consultarEstados(EstadoDomain filtro) throws TerraxsException;

}
