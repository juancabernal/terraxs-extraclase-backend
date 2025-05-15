package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class TipoDocumentoDomain {

	private UUID id;
	private String nombre;

	public TipoDocumentoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoDocumentoDomain(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoDocumentoDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static TipoDocumentoDomain obtenerValorDefecto() {
		return new TipoDocumentoDomain();
	}

	public static TipoDocumentoDomain obtenerValorDefecto(final TipoDocumentoDomain tipoDocumento) {
		return UtilObjeto.getInstance().obtenerValorDefecto(tipoDocumento, obtenerValorDefecto());
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
}
