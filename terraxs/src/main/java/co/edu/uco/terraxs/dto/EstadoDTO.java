package co.edu.uco.terraxs.dto;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class EstadoDTO {

	private UUID id;
	private String nombre;
	private TipoEstadoDTO tipoEstado;

	public EstadoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoEstado(TipoEstadoDTO.obtenerValorDefecto());
	}

	public EstadoDTO(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoEstado(TipoEstadoDTO.obtenerValorDefecto());
	}

	public EstadoDTO(final UUID id, final String nombre, final TipoEstadoDTO tipoEstado) {
		setId(id);
		setNombre(nombre);
		setTipoEstado(tipoEstado);
	}

	private EstadoDTO(final Builder builder) {
		setId(builder.id);
		setNombre(builder.nombre);
		setTipoEstado(builder.tipoEstado);
	}

	public static EstadoDTO obtenerValorDefecto() {
		return new EstadoDTO();
	}

	public static EstadoDTO obtenerValorDefecto(final EstadoDTO estado) {
		return UtilObjeto.getInstance().obtenerValorDefecto(estado, obtenerValorDefecto());
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

	public TipoEstadoDTO getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(final TipoEstadoDTO tipoEstado) {
		this.tipoEstado = TipoEstadoDTO.obtenerValorDefecto(tipoEstado);
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private TipoEstadoDTO tipoEstado;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder nombre(final String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder tipoEstado(final TipoEstadoDTO tipoEstado) {
			this.tipoEstado = tipoEstado;
			return this;
		}

		public EstadoDTO crear() {
			return new EstadoDTO(this);
		}
	}
}
