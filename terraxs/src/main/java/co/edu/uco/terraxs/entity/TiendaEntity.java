package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class TiendaEntity {

	private UUID id;
	private TipoDocumentoEntity tipoDocumento;
	private String numeroDocumento;
	private String correo;

	public TiendaEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setTipoDocumento(TipoDocumentoEntity.obtenerValorDefecto());
		setNumeroDocumento(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TiendaEntity(UUID id, TipoDocumentoEntity tipoDocumento, String numeroDocumento, String correo) {
		setId(id);
		setTipoDocumento(tipoDocumento);
		setNumeroDocumento(numeroDocumento);
		setCorreo(correo);
	}

	public static TiendaEntity obtenerValorDefecto() {
		return new TiendaEntity();
	}

	public static TiendaEntity obtenerValorDefecto(final TiendaEntity tienda) {
		return UtilObjeto.getInstance().obtenerValorDefecto(tienda, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = TipoDocumentoEntity.obtenerValorDefecto(tipoDocumento);
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
}
