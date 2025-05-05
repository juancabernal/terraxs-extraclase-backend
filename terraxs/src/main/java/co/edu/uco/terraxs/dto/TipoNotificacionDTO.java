package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class TipoNotificacionDTO {

	private UUID id;
	private String nombre;
	private String mensaje;

	public TipoNotificacionDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoNotificacionDTO(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoNotificacionDTO(final UUID id, final String nombre, final String mensaje) {
		setId(id);
		setNombre(nombre);
		setMensaje(mensaje);
	}

	private TipoNotificacionDTO(final Builder builder) {
		setId(builder.id);
		setNombre(builder.nombre);
		setMensaje(builder.mensaje);
	}

	public static TipoNotificacionDTO obtenerValorDefecto() {
		return new TipoNotificacionDTO();
	}

	public static TipoNotificacionDTO obtenerValorDefecto(final TipoNotificacionDTO tipo) {
		return UtilObjeto.getInstance().obtenerValorDefecto(tipo, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(final String mensaje) {
		this.mensaje = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(mensaje);
	}

	public static class Builder {
		private UUID id;
		private String nombre;
		private String mensaje;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder nombre(final String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder mensaje(final String mensaje) {
			this.mensaje = mensaje;
			return this;
		}

		public TipoNotificacionDTO crear() {
			return new TipoNotificacionDTO(this);
		}
	}
}
