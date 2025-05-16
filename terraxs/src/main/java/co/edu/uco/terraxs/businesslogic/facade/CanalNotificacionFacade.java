package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.dto.CanalNotificacionDTO;

public interface CanalNotificacionFacade {

	void crearNotificacionPorCanal(CanalNotificacionDTO canalNotificaion);
	
	CanalNotificacionDTO consultarCanalNotificacionPorId(UUID id);
	
	List<CanalNotificacionDTO> consultarCanalesNotificacion(CanalNotificacionDTO filtro);
	
}
