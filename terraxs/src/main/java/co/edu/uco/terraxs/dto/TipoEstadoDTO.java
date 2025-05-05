package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class TipoEstadoDTO {

	private UUID id;
	private String nombre;

	public TipoEstadoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoEstadoDTO(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoEstadoDTO(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	private TipoEstadoDTO(final Builder builder) {
		setId(builder.id);
		setNombre(builder.nombre);
	}

	public static TipoEstadoDTO obtenerValorDefecto() {
		return new TipoEstadoDTO();
	}

	public static TipoEstadoDTO obtenerValorDefecto(final TipoEstadoDTO tipoEstado) {
		return UtilObjeto.getInstance().obtenerValorDefecto(tipoEstado, obtenerValorDefecto());
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

	public static class Builder {
		private UUID id;
		private String nombre;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder nombre(final String nombre) {
			this.nombre = nombre;
			return this;
		}

		public TipoEstadoDTO crear() {
			return new TipoEstadoDTO(this);
		}
	}
}
