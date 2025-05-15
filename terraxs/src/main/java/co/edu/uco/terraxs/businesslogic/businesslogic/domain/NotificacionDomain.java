package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class NotificacionDomain {

	private UUID id;
	private String codigoReferencia;
	private TipoNotificacionDomain tipoNotificacion;
	private String mensajeAdicional;
	private LocalDateTime fechaHoraEnvio;
	private UsuarioDomain usuarioReceptor;

	public NotificacionDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoNotificacion(TipoNotificacionDomain.obtenerValorDefecto());
		setMensajeAdicional(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaHoraEnvio(UtilFecha.getInstance().obtenerFechaHoraActual());
		setUsuarioReceptor(UsuarioDomain.obtenerValorDefecto());
	}

	public NotificacionDomain(final UUID id) {
		setId(id);
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoNotificacion(TipoNotificacionDomain.obtenerValorDefecto());
		setMensajeAdicional(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaHoraEnvio(LocalDateTime.now());
		setUsuarioReceptor(UsuarioDomain.obtenerValorDefecto());
	}

	public NotificacionDomain(final UUID id, final String codigoReferencia, final TipoNotificacionDomain tipoNotificacion,
			final String mensajeAdicional, final LocalDateTime fechaHoraEnvio, final UsuarioDomain usuarioReceptor) {
		setId(id);
		setCodigoReferencia(codigoReferencia);
		setTipoNotificacion(tipoNotificacion);
		setMensajeAdicional(mensajeAdicional);
		setFechaHoraEnvio(fechaHoraEnvio);
		setUsuarioReceptor(usuarioReceptor);
	}

	public static NotificacionDomain obtenerValorDefecto() {
		return new NotificacionDomain();
	}

	public static NotificacionDomain obtenerValorDefecto(final NotificacionDomain notificacion) {
		return UtilObjeto.getInstance().obtenerValorDefecto(notificacion, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(final String codigoReferencia) {
		this.codigoReferencia = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigoReferencia);
	}

	public TipoNotificacionDomain getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(final TipoNotificacionDomain tipoNotificacion) {
		this.tipoNotificacion = TipoNotificacionDomain.obtenerValorDefecto(tipoNotificacion);
	}

	public String getMensajeAdicional() {
		return mensajeAdicional;
	}

	public void setMensajeAdicional(final String mensajeAdicional) {
		this.mensajeAdicional = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(mensajeAdicional);
	}

	public LocalDateTime getFechaHoraEnvio() {
		return fechaHoraEnvio;
	}

	public void setFechaHoraEnvio(final LocalDateTime fechaHoraEnvio) {
		this.fechaHoraEnvio = UtilFecha.getInstance().obtenerValorDefecto(fechaHoraEnvio);
	}

	public UsuarioDomain getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(final UsuarioDomain usuarioReceptor) {
		this.usuarioReceptor = UsuarioDomain.obtenerValorDefecto(usuarioReceptor);
	}
}
