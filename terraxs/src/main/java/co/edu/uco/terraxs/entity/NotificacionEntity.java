package co.edu.uco.terraxs.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class NotificacionEntity {

	private UUID id;
	private String codigoReferencia;
	private TipoNotificacionEntity tipoNotificacion;
	private String mensajeAdicional;
	private LocalDateTime fechaHoraEnvio;
	private UsuarioEntity usuarioReceptor;

	public NotificacionEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoNotificacion(TipoNotificacionEntity.obtenerValorDefecto());
		setMensajeAdicional(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaHoraEnvio(UtilFecha.getInstance().obtenerFechaHoraActual());
		setUsuarioReceptor(UsuarioEntity.obtenerValorDefecto());
	}

	public NotificacionEntity(final UUID id) {
		setId(id);
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoNotificacion(TipoNotificacionEntity.obtenerValorDefecto());
		setMensajeAdicional(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaHoraEnvio(LocalDateTime.now());
		setUsuarioReceptor(UsuarioEntity.obtenerValorDefecto());
	}

	public NotificacionEntity(final UUID id, final String codigoReferencia, final TipoNotificacionEntity tipoNotificacion,
			final String mensajeAdicional, final LocalDateTime fechaHoraEnvio, final UsuarioEntity usuarioReceptor) {
		setId(id);
		setCodigoReferencia(codigoReferencia);
		setTipoNotificacion(tipoNotificacion);
		setMensajeAdicional(mensajeAdicional);
		setFechaHoraEnvio(fechaHoraEnvio);
		setUsuarioReceptor(usuarioReceptor);
	}

	public static NotificacionEntity obtenerValorDefecto() {
		return new NotificacionEntity();
	}

	public static NotificacionEntity obtenerValorDefecto(final NotificacionEntity notificacion) {
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

	public TipoNotificacionEntity getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(final TipoNotificacionEntity tipoNotificacion) {
		this.tipoNotificacion = TipoNotificacionEntity.obtenerValorDefecto(tipoNotificacion);
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

	public UsuarioEntity getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(final UsuarioEntity usuarioReceptor) {
		this.usuarioReceptor = UsuarioEntity.obtenerValorDefecto(usuarioReceptor);
	}
}
