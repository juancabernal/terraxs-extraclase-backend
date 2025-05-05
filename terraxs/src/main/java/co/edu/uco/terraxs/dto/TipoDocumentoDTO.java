package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class TipoDocumentoDTO {

	private UUID id;
	private String nombre;

	public TipoDocumentoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoDocumentoDTO(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoDocumentoDTO(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	private TipoDocumentoDTO(final Builder builder) {
		setId(builder.id);
		setNombre(builder.nombre);
	}

	public static TipoDocumentoDTO obtenerValorDefecto() {
		return new TipoDocumentoDTO();
	}

	public static TipoDocumentoDTO obtenerValorDefecto(final TipoDocumentoDTO dto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
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

	@Override
	public String toString() {
		return "TipoDocumentoDTO [id=" + id + ", nombre=" + nombre + "]";
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

		public TipoDocumentoDTO crear() {
			return new TipoDocumentoDTO(this);
		}
	}
}
