package co.edu.uco.terraxs.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CanalNotificacionDomain;

public interface CanalNotificacionBusinessLogic {
	
	void crearNotificacionPorCanal(CanalNotificacionDomain canalNotificaion);
	
	CanalNotificacionDomain consultarCanalNotificacionPorId(UUID id);
	
	List<CanalNotificacionDomain> consultarCanalesNotificacion(CanalNotificacionDomain filtro);

}



