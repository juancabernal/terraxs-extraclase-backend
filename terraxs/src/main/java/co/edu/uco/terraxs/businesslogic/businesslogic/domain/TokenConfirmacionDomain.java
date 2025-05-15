package co.edu.uco.terraxs.businesslogic.businesslogic.domain;
import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class TokenConfirmacionDomain {

	private UUID id;
	private String token;
	private LocalDateTime fechaSolicitud;
	private LocalDateTime fechaExpiracion;
	private boolean usado;
	private NotificacionDomain notificacion; 

	public TokenConfirmacionDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setToken(UtilTexto.VACIO);
		setFechaSolicitud(UtilFecha.getInstance().obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.getInstance().obtenerFechaHoraActual());
		setUsado(false);
		setNotificacion(NotificacionDomain.obtenerValorDefecto());
	}

	public TokenConfirmacionDomain(final UUID id) {
		setId(id);
		setToken(UtilTexto.VACIO);
		setFechaSolicitud(UtilFecha.getInstance().obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.getInstance().obtenerFechaHoraActual());
		setUsado(false);
		setNotificacion(NotificacionDomain.obtenerValorDefecto());
	}

	public TokenConfirmacionDomain(final UUID id, final String token, final LocalDateTime fechaSolicitud,
			final LocalDateTime fechaExpiracion, final boolean usado, final NotificacionDomain notificacion) {
		setId(id);
		setToken(token);
		setFechaSolicitud(fechaSolicitud);
		setFechaExpiracion(fechaExpiracion);
		setUsado(usado);
		setNotificacion(notificacion);
	}

	public static TokenConfirmacionDomain obtenerValorDefecto() {
		return new TokenConfirmacionDomain();
	}

	public static TokenConfirmacionDomain obtenerValorDefecto(final TokenConfirmacionDomain token) {
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
		this.fechaSolicitud = UtilFecha.getInstance().obtenerValorDefecto(fechaSolicitud);
	}

	public LocalDateTime getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(final LocalDateTime fechaExpiracion) {
		this.fechaExpiracion = UtilFecha.getInstance().obtenerValorDefecto(fechaExpiracion);
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(final boolean usado) {
		this.usado = usado;
	}

	public NotificacionDomain getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(final NotificacionDomain notificacion) {
		this.notificacion = NotificacionDomain.obtenerValorDefecto(notificacion);
	}
}
