package co.edu.uco.terraxs.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;
import co.edu.uco.terraxs.entity.EstadoEntity;

public final class TokenConfirmacionDTO {

	private UUID id;
	private String token;
	private LocalDateTime fechaSolicitud;
	private LocalDateTime fechaExpiracion;
	private EstadoDTO estado;
	private NotificacionDTO notificacion;

	public TokenConfirmacionDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setToken(UtilTexto.VACIO);
		setFechaSolicitud(UtilFecha.getInstance().obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.getInstance().obtenerFechaHoraActual());
		setEstado(EstadoDTO.obtenerValorDefecto());
		setNotificacion(NotificacionDTO.obtenerValorDefecto());
	}

	public TokenConfirmacionDTO(final UUID id) {
		setId(id);
		setToken(UtilTexto.VACIO);
		setFechaSolicitud(UtilFecha.getInstance().obtenerFechaHoraActual());
		setFechaExpiracion(UtilFecha.getInstance().obtenerFechaHoraActual());
		setEstado(EstadoDTO.obtenerValorDefecto());
		setNotificacion(NotificacionDTO.obtenerValorDefecto());
	}

	public TokenConfirmacionDTO(final UUID id, final String token, final LocalDateTime fechaSolicitud,
			final LocalDateTime fechaExpiracion, final EstadoDTO estado, final NotificacionDTO notificacion) {
		setId(id);
		setToken(token);
		setFechaSolicitud(fechaSolicitud);
		setFechaExpiracion(fechaExpiracion);
		setEstado(estado);
		setNotificacion(notificacion);
	}

	private TokenConfirmacionDTO(final Builder builder) {
		setId(builder.id);
		setToken(builder.token);
		setFechaSolicitud(builder.fechaSolicitud);
		setFechaExpiracion(builder.fechaExpiracion);
		setEstado(builder.estado);
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

	public NotificacionDTO getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(final NotificacionDTO notificacion) {
		this.notificacion = NotificacionDTO.obtenerValorDefecto(notificacion);
	}

	@Override
	public String toString() {
		return "TokenConfirmacionDTO [id=" + id + ", token=" + token + ", fechaSolicitud=" + fechaSolicitud
				+ ", fechaExpiracion=" + fechaExpiracion + ", estado=" + estado + ", notificacion=" + notificacion + "]";
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estadoDTO) {
		this.estado = estadoDTO;
	}

	public static class Builder {

		private UUID id;
		private String token;
		private LocalDateTime fechaSolicitud;
		private LocalDateTime fechaExpiracion;
		private EstadoDTO estado;
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

		public Builder estado(final EstadoDTO estado) {
			this.estado = estado;
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
