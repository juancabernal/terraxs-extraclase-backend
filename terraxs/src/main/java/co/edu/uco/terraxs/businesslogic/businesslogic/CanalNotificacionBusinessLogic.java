package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CanalNotificacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

public interface CanalNotificacionBusinessLogic {
	
	void crearNotificacionPorCanal(CanalNotificacionDomain canalNotificaion) throws TerraxsException;
	
	CanalNotificacionDomain consultarCanalNotificacionPorId(UUID id) throws TerraxsException;
	
	List<CanalNotificacionDomain> consultarCanalesNotificacion(CanalNotificacionDomain filtro) throws TerraxsException;

}



