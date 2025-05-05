package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class EstadoEntity {

	private UUID id;
	private String nombre;
	private TipoEstadoEntity tipoEstado;

	public EstadoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoEstado(TipoEstadoEntity.obtenerValorDefecto());
	}

	public EstadoEntity(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoEstado(TipoEstadoEntity.obtenerValorDefecto());
	}

	public EstadoEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
		setTipoEstado(TipoEstadoEntity.obtenerValorDefecto());
	}

	public EstadoEntity(final UUID id, final String nombre, final TipoEstadoEntity tipoEstado) {
		setId(id);
		setNombre(nombre);
		setTipoEstado(tipoEstado);
	}

	public static EstadoEntity obtenerValorDefecto() {
		return new EstadoEntity();
	}

	public static EstadoEntity obtenerValorDefecto(final EstadoEntity estado) {
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

	public TipoEstadoEntity getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(final TipoEstadoEntity tipoEstado) {
		this.tipoEstado = TipoEstadoEntity.obtenerValorDefecto(tipoEstado);
	}
}
