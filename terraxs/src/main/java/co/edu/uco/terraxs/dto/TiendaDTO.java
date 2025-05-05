package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class TiendaDTO {

	private UUID id;
	private TipoDocumentoDTO tipoDocumento;
	private String numeroDocumento;
	private String correo;

	public TiendaDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setTipoDocumento(TipoDocumentoDTO.obtenerValorDefecto());
		setNumeroDocumento(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TiendaDTO(UUID id, TipoDocumentoDTO tipoDocumento, String numeroDocumento, String correo) {
		setId(id);
		setTipoDocumento(tipoDocumento);
		setNumeroDocumento(numeroDocumento);
		setCorreo(correo);
	}

	private TiendaDTO(Builder builder) {
		setId(builder.id);
		setTipoDocumento(builder.tipoDocumento);
		setNumeroDocumento(builder.numeroDocumento);
		setCorreo(builder.correo);
	}

	public static TiendaDTO obtenerValorDefecto() {
		return new TiendaDTO();
	}

	public static TiendaDTO obtenerValorDefecto(final TiendaDTO dto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = TipoDocumentoDTO.obtenerValorDefecto(tipoDocumento);
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(numeroDocumento);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(correo);
	}

	public static class Builder {

		private UUID id;
		private TipoDocumentoDTO tipoDocumento;
		private String numeroDocumento;
		private String correo;

		public Builder id(UUID id) {
			this.id = id;
			return this;
		}

		public Builder tipoDocumento(TipoDocumentoDTO tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
			return this;
		}

		public Builder numeroDocumento(String numeroDocumento) {
			this.numeroDocumento = numeroDocumento;
			return this;
		}

		public Builder correo(String correo) {
			this.correo = correo;
			return this;
		}

		public TiendaDTO crear() {
			return new TiendaDTO(this);
		}
	}
}
