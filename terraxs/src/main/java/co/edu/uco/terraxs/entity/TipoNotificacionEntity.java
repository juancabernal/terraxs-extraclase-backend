package co.edu.uco.terraxs.entity;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class TipoNotificacionEntity {

	private UUID id;
	private String nombre;
	private String mensaje;

	public TipoNotificacionEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoNotificacionEntity(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoNotificacionEntity(final UUID id, final String nombre, final String mensaje) {
		setId(id);
		setNombre(nombre);
		setMensaje(mensaje);
	}

	public static TipoNotificacionEntity obtenerValorDefecto() {
		return new TipoNotificacionEntity();
	}

	public static TipoNotificacionEntity obtenerValorDefecto(final TipoNotificacionEntity tipoNotificacion) {
		return UtilObjeto.getInstance().obtenerValorDefecto(tipoNotificacion, obtenerValorDefecto());
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(final String mensaje) {
		this.mensaje = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(mensaje);
	}
}
