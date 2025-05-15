package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class CanalNotificacionDomain {

	private UUID id;
	private NotificacionDomain notificacion;
	private CanalDomain canal;
	private EstadoDomain estado;

	public CanalNotificacionDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNotificacion(NotificacionDomain.obtenerValorDefecto());
		setCanal(CanalDomain.obtenerValorDefecto());
		setEstado(EstadoDomain.obtenerValorDefecto());
	}

	public CanalNotificacionDomain(final UUID id) {
		setId(id);
		setNotificacion(NotificacionDomain.obtenerValorDefecto());
		setCanal(CanalDomain.obtenerValorDefecto());
		setEstado(EstadoDomain.obtenerValorDefecto());
	}

	public CanalNotificacionDomain(final UUID id, final NotificacionDomain notificacion,
			final CanalDomain canal, final EstadoDomain estado) {
		setId(id);
		setNotificacion(notificacion);
		setCanal(canal);
		setEstado(estado);
	}

	public static CanalNotificacionDomain obtenerValorDefecto() {
		return new CanalNotificacionDomain();
	}

	public static CanalNotificacionDomain obtenerValorDefecto(final CanalNotificacionDomain canalNotificacion) {
		return UtilObjeto.getInstance().obtenerValorDefecto(canalNotificacion, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public NotificacionDomain getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(final NotificacionDomain notificacion) {
		this.notificacion = NotificacionDomain.obtenerValorDefecto(notificacion);
	}

	public CanalDomain getCanal() {
		return canal;
	}

	public void setCanal(final CanalDomain canal) {
		this.canal = CanalDomain.obtenerValorDefecto(canal);
	}

	public EstadoDomain getEstado() {
		return estado;
	}

	public void setEstado(final EstadoDomain estado) {
		this.estado = EstadoDomain.obtenerValorDefecto(estado);
	}
}
