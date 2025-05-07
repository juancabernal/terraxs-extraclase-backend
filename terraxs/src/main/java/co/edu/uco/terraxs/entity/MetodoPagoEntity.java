package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class MetodoPagoEntity {

	private UUID id;
	private String nombre;

	public MetodoPagoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public MetodoPagoEntity(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public MetodoPagoEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static MetodoPagoEntity obtenerValorDefecto() {
		return new MetodoPagoEntity();
	}

	public static MetodoPagoEntity obtenerValorDefecto(final MetodoPagoEntity metodo) {
		return UtilObjeto.getInstance().obtenerValorDefecto(metodo, obtenerValorDefecto());
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
