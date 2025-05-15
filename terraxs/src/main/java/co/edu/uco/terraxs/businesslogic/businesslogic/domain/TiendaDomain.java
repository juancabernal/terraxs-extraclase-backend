package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class TiendaDomain {

	private UUID id;
	private TipoDocumentoDomain tipoDocumento;
	private String numeroDocumento;
	private String correo;

	public TiendaDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setTipoDocumento(TipoDocumentoDomain.obtenerValorDefecto());
		setNumeroDocumento(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TiendaDomain(final UUID id, final TipoDocumentoDomain tipoDocumento, final String numeroDocumento, final String correo) {
		setId(id);
		setTipoDocumento(tipoDocumento);
		setNumeroDocumento(numeroDocumento);
		setCorreo(correo);
	}

	public static TiendaDomain obtenerValorDefecto() {
		return new TiendaDomain();
	}

	public static TiendaDomain obtenerValorDefecto(final TiendaDomain tienda) {
		return UtilObjeto.getInstance().obtenerValorDefecto(tienda, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoDocumentoDomain getTipoDocumento() {
		return tipoDocumento;
	}

	public TiendaDomain setTipoDocumento(TipoDocumentoDomain tipoDocumento) {
		this.tipoDocumento = TipoDocumentoDomain.obtenerValorDefecto(tipoDocumento);
		return this;
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
