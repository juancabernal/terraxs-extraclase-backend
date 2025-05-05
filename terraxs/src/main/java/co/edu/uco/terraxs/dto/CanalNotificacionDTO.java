package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class CanalNotificacionDTO {

	private UUID id;
	private NotificacionDTO notificacion;
	private CanalDTO canal;
	private EstadoDTO estado;

	public CanalNotificacionDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNotificacion(NotificacionDTO.obtenerValorDefecto());
		setCanal(CanalDTO.obtenerValorDefecto());
		setEstado(EstadoDTO.obtenerValorDefecto());
	}

	public CanalNotificacionDTO(final UUID id) {
		setId(id);
		setNotificacion(NotificacionDTO.obtenerValorDefecto());
		setCanal(CanalDTO.obtenerValorDefecto());
		setEstado(EstadoDTO.obtenerValorDefecto());
	}

	public CanalNotificacionDTO(final UUID id, final NotificacionDTO notificacion,
			final CanalDTO canal, final EstadoDTO estado) {
		setId(id);
		setNotificacion(notificacion);
		setCanal(canal);
		setEstado(estado);
	}

	public static CanalNotificacionDTO obtenerValorDefecto() {
		return new CanalNotificacionDTO();
	}

	public static CanalNotificacionDTO obtenerValorDefecto(final CanalNotificacionDTO canalNotificacion) {
		return UtilObjeto.getInstance().obtenerValorDefecto(canalNotificacion, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public NotificacionDTO getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(final NotificacionDTO notificacion) {
		this.notificacion = NotificacionDTO.obtenerValorDefecto(notificacion);
	}

	public CanalDTO getCanal() {
		return canal;
	}

	public void setCanal(final CanalDTO canal) {
		this.canal = CanalDTO.obtenerValorDefecto(canal);
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(final EstadoDTO estado) {
		this.estado = EstadoDTO.obtenerValorDefecto(estado);
	}
}
