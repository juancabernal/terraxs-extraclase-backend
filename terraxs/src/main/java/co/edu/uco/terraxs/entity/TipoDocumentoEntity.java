package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class TipoDocumentoEntity {

	private UUID id;
	private String nombre;

	public TipoDocumentoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoDocumentoEntity(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoDocumentoEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static TipoDocumentoEntity obtenerValorDefecto() {
		return new TipoDocumentoEntity();
	}

	public static TipoDocumentoEntity obtenerValorDefecto(final TipoDocumentoEntity tipoDocumento) {
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
