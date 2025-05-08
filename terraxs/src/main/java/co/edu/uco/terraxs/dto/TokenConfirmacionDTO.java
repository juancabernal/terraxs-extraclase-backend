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
		setFechaSolicitud(UtilFecha.getInstance().obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.getInstance().obtenerFechaHoraActual());
		setUsado(false);
		setNotificacion(NotificacionDTO.obtenerValorDefecto());
	}

	public TokenConfirmacionDTO(final UUID id) {
		setId(id);
		setToken(UtilTexto.VACIO);
		setFechaSolicitud(UtilFecha.getInstance().obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.getInstance().obtenerFechaHoraActual());
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

	private TokenConfirmacionDTO(final Builder builder) {
		setId(builder.id);
		setToken(builder.token);
		setFechaSolicitud(builder.fechaSolicitud);
		setFechaExpiracion(builder.fechaExpiracion);
		setUsado(builder.usado);
		setNotificacion(builder.notificacion);
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

	public NotificacionDTO getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(final NotificacionDTO notificacion) {
		this.notificacion = NotificacionDTO.obtenerValorDefecto(notificacion);
	}

	@Override
	public String toString() {
		return "TokenConfirmacionDTO [id=" + id + ", token=" + token + ", fechaSolicitud=" + fechaSolicitud
				+ ", fechaExpiracion=" + fechaExpiracion + ", usado=" + usado + ", notificacion=" + notificacion + "]";
	}

	public static class Builder {

		private UUID id;
		private String token;
		private LocalDateTime fechaSolicitud;
		private LocalDateTime fechaExpiracion;
		private boolean usado;
		private NotificacionDTO notificacion;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder token(final String token) {
			this.token = token;
			return this;
		}

		public Builder fechaSolicitud(final LocalDateTime fechaSolicitud) {
			this.fechaSolicitud = fechaSolicitud;
			return this;
		}

		public Builder fechaExpiracion(final LocalDateTime fechaExpiracion) {
			this.fechaExpiracion = fechaExpiracion;
			return this;
		}

		public Builder usado(final boolean usado) {
			this.usado = usado;
			return this;
		}

		public Builder notificacion(final NotificacionDTO notificacion) {
			this.notificacion = notificacion;
			return this;
		}

		public TokenConfirmacionDTO crear() {
			return new TokenConfirmacionDTO(this);
		}
	}
}
