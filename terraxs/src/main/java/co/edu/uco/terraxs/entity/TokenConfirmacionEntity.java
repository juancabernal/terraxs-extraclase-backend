package co.edu.uco.terraxs.entity;
import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class TokenConfirmacionEntity {

	private UUID id;
	private String token;
	private LocalDateTime fechaSolicitud;
	private LocalDateTime fechaExpiracion;
	private boolean usado;
	private NotificacionEntity notificacion; 

	public TokenConfirmacionEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setToken(UtilTexto.VACIO);
		setFechaSolicitud(UtilFecha.obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.obtenerFechaHoraActual());
		setUsado(false);
		setNotificacion(NotificacionEntity.obtenerValorDefecto());
	}

	public TokenConfirmacionEntity(final UUID id) {
		setId(id);
		setToken(UtilTexto.VACIO);
		setFechaSolicitud(UtilFecha.obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.obtenerFechaHoraActual());
		setUsado(false);
		setNotificacion(NotificacionEntity.obtenerValorDefecto());
	}

	public TokenConfirmacionEntity(final UUID id, final String token, final LocalDateTime fechaSolicitud,
			final LocalDateTime fechaExpiracion, final boolean usado, final NotificacionEntity notificacion) {
		setId(id);
		setToken(token);
		setFechaSolicitud(fechaSolicitud);
		setFechaExpiracion(fechaExpiracion);
		setUsado(usado);
		setNotificacion(notificacion);
	}

	public static TokenConfirmacionEntity obtenerValorDefecto() {
		return new TokenConfirmacionEntity();
	}

	public static TokenConfirmacionEntity obtenerValorDefecto(final TokenConfirmacionEntity token) {
		return UtilObjeto.getInstance().obtenerValorDefecto(token, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(token);
	}

	public LocalDateTime getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(final LocalDateTime fechaSolicitud) {
		this.fechaSolicitud = UtilFecha.obtenerValorDefecto(fechaSolicitud);
	}

	public LocalDateTime getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(final LocalDateTime fechaExpiracion) {
		this.fechaExpiracion = UtilFecha.obtenerValorDefecto(fechaExpiracion);
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(final boolean usado) {
		this.usado = usado;
	}

	public NotificacionEntity getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(final NotificacionEntity notificacion) {
		this.notificacion = NotificacionEntity.obtenerValorDefecto(notificacion);
	}
}
