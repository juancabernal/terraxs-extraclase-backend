package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class UnidadEntity {

	private UUID id;
	private String nombre;

	public UnidadEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public UnidadEntity(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public UnidadEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static UnidadEntity obtenerValorDefecto() {
		return new UnidadEntity();
	}

	public static UnidadEntity obtenerValorDefecto(final UnidadEntity unidad) {
		return UtilObjeto.getInstance().obtenerValorDefecto(unidad, obtenerValorDefecto());
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
