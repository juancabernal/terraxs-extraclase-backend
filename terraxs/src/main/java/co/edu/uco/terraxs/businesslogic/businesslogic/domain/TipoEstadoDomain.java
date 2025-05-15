package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class TipoEstadoDomain {

	private UUID id;
	private String nombre;

	public TipoEstadoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoEstadoDomain(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoEstadoDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static TipoEstadoDomain obtenerValorDefecto() {
		return new TipoEstadoDomain();
	}

	public static TipoEstadoDomain obtenerValorDefecto(final TipoEstadoDomain tipoEstado) {
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
}
