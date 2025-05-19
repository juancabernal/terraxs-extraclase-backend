package co.edu.uco.terraxs.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CanalNotificacionDTO;

public interface CanalNotificacionFacade {

	void crearNotificacionPorCanal(CanalNotificacionDTO canalNotificaion) throws TerraxsException;
	
	CanalNotificacionDTO consultarCanalNotificacionPorId(UUID id) throws TerraxsException;
	
	List<CanalNotificacionDTO> consultarCanalesNotificacion(CanalNotificacionDTO filtro) throws TerraxsException;
	
}
