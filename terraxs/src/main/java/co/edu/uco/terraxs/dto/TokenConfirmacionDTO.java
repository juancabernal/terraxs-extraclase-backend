package co.edu.uco.terraxs.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class TokenConfirmacionDTO {

	private UUID id;
	private String token;
	private LocalDateTime fechaSolicitud;
	private LocalDateTime fechaExpiracion;
	private boolean usado;
	private NotificacionDTO notificacion;

	public TokenConfirmacionDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setToken(UtilTexto.VACIO);
		setFechaSolicitud(UtilFecha.obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.obtenerFechaHoraActual());
		setUsado(false);
		setNotificacion(NotificacionDTO.obtenerValorDefecto());
	}

	public TokenConfirmacionDTO(final UUID id) {
		setId(id);
		setToken(UtilTexto.VACIO);
		setFechaSolicitud(UtilFecha.obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.obtenerFechaHoraActual());
		setUsado(false);
		setNotificacion(NotificacionDTO.obtenerValorDefecto());
	}

	public TokenConfirmacionDTO(final UUID id, final String token, final LocalDateTime fechaSolicitud,
			final LocalDateTime fechaExpiracion, final boolean usado, final NotificacionDTO notificacion) {
		setId(id);
		setToken(token);
		setFechaSolicitud(fechaSolicitud);
		setFechaExpiracion(fechaExpiracion);
		setUsado(usado);
		setNotificacion(notificacion);
	}

	public static TokenConfirmacionDTO obtenerValorDefecto() {
		return new TokenConfirmacionDTO();
	}

	public static TokenConfirmacionDTO obtenerValorDefecto(final TokenConfirmacionDTO token) {
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

	public NotificacionDTO getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(final NotificacionDTO notificacion) {
		this.notificacion = NotificacionDTO.obtenerValorDefecto(notificacion);
	}
}
