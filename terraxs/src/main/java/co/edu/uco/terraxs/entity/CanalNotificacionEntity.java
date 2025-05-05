package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class CanalNotificacionEntity {

	private UUID id;
	private NotificacionEntity notificacion;
	private CanalEntity canal;
	private EstadoEntity estado;

	public CanalNotificacionEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNotificacion(NotificacionEntity.obtenerValorDefecto());
		setCanal(CanalEntity.obtenerValorDefecto());
		setEstado(EstadoEntity.obtenerValorDefecto());
	}

	public CanalNotificacionEntity(final UUID id) {
		setId(id);
		setNotificacion(NotificacionEntity.obtenerValorDefecto());
		setCanal(CanalEntity.obtenerValorDefecto());
		setEstado(EstadoEntity.obtenerValorDefecto());
	}

	public CanalNotificacionEntity(final UUID id, final NotificacionEntity notificacion,
			final CanalEntity canal, final EstadoEntity estado) {
		setId(id);
		setNotificacion(notificacion);
		setCanal(canal);
		setEstado(estado);
	}

	public static CanalNotificacionEntity obtenerValorDefecto() {
		return new CanalNotificacionEntity();
	}

	public static CanalNotificacionEntity obtenerValorDefecto(final CanalNotificacionEntity canalNotificacion) {
		return UtilObjeto.getInstance().obtenerValorDefecto(canalNotificacion, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public NotificacionEntity getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(final NotificacionEntity notificacion) {
		this.notificacion = NotificacionEntity.obtenerValorDefecto(notificacion);
	}

	public CanalEntity getCanal() {
		return canal;
	}

	public void setCanal(final CanalEntity canal) {
		this.canal = CanalEntity.obtenerValorDefecto(canal);
	}

	public EstadoEntity getEstado() {
		return estado;
	}

	public void setEstado(final EstadoEntity estado) {
		this.estado = EstadoEntity.obtenerValorDefecto(estado);
	}
}
