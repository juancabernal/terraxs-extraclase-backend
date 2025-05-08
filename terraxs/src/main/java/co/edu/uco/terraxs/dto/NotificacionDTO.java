package co.edu.uco.terraxs.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class NotificacionDTO {

	private UUID id;
	private String codigoReferencia;
	private TipoNotificacionDTO tipoNotificacion;
	private String mensajeAdicional;
	private LocalDateTime fechaHoraEnvio;
	private UsuarioDTO usuarioReceptor;

	public NotificacionDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoNotificacion(TipoNotificacionDTO.obtenerValorDefecto());
		setMensajeAdicional(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaHoraEnvio(UtilFecha.getInstance().obtenerFechaHoraActual());
		setUsuarioReceptor(UsuarioDTO.obtenerValorDefecto());
	}

	public NotificacionDTO(final UUID id) {
		setId(id);
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setTipoNotificacion(TipoNotificacionDTO.obtenerValorDefecto());
		setMensajeAdicional(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaHoraEnvio(LocalDateTime.now());
		setUsuarioReceptor(UsuarioDTO.obtenerValorDefecto());
	}

	public NotificacionDTO(final UUID id, final String codigoReferencia, final TipoNotificacionDTO tipoNotificacion,
			final String mensajeAdicional, final LocalDateTime fechaHoraEnvio, final UsuarioDTO usuarioReceptor) {
		setId(id);
		setCodigoReferencia(codigoReferencia);
		setTipoNotificacion(tipoNotificacion);
		setMensajeAdicional(mensajeAdicional);
		setFechaHoraEnvio(fechaHoraEnvio);
		setUsuarioReceptor(usuarioReceptor);
	}

	public static NotificacionDTO obtenerValorDefecto() {
		return new NotificacionDTO();
	}

	public static NotificacionDTO obtenerValorDefecto(final NotificacionDTO notificacion) {
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

	public TipoNotificacionDTO getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(final TipoNotificacionDTO tipoNotificacion) {
		this.tipoNotificacion = TipoNotificacionDTO.obtenerValorDefecto(tipoNotificacion);
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

	public UsuarioDTO getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(final UsuarioDTO usuarioReceptor) {
		this.usuarioReceptor = UsuarioDTO.obtenerValorDefecto(usuarioReceptor);
	}
}
