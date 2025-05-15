package co.edu.uco.terraxs.businesslogic.businesslogic.domain;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class TipoNotificacionDomain {

	private UUID id;
	private String nombre;
	private String mensaje;

	public TipoNotificacionDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoNotificacionDomain(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public TipoNotificacionDomain(final UUID id, final String nombre, final String mensaje) {
		setId(id);
		setNombre(nombre);
		setMensaje(mensaje);
	}

	public static TipoNotificacionDomain obtenerValorDefecto() {
		return new TipoNotificacionDomain();
	}

	public static TipoNotificacionDomain obtenerValorDefecto(final TipoNotificacionDomain tipoNotificacion) {
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
