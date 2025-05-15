package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class EstadoDomain {

	private UUID id;
	private String nombre;
	private TipoEstadoDomain tipoEstado;

	public EstadoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoEstado(TipoEstadoDomain.obtenerValorDefecto());
	}

	public EstadoDomain(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoEstado(TipoEstadoDomain.obtenerValorDefecto());
	}

	public EstadoDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
		setTipoEstado(TipoEstadoDomain.obtenerValorDefecto());
	}

	public EstadoDomain(final UUID id, final String nombre, final TipoEstadoDomain tipoEstado) {
		setId(id);
		setNombre(nombre);
		setTipoEstado(tipoEstado);
	}

	public static EstadoDomain obtenerValorDefecto() {
		return new EstadoDomain();
	}

	public static EstadoDomain obtenerValorDefecto(final EstadoDomain estado) {
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

	public TipoEstadoDomain getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(final TipoEstadoDomain tipoEstado) {
		this.tipoEstado = TipoEstadoDomain.obtenerValorDefecto(tipoEstado);
	}
}
