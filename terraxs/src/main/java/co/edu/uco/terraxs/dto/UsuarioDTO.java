package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.entity.UsuarioEntity;

public class UsuarioDTO {

	private UUID id;
	private TipoDocumentoDTO tipoDocumento;
	private String numeroIdentificacion;
	private String nombres;
	private String apellidos;
	private String correo;
	private String telefono;
	private boolean correoConfirmado;
	private boolean telefonoConfirmado;

	public UsuarioDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setTipoDocumento(TipoDocumentoDTO.obtenerValorDefecto());
		setNumeroIdentificacion(UtilTexto.getInstance().obtenerValorDefecto());
		setNombres(UtilTexto.getInstance().obtenerValorDefecto());
		setApellidos(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setTelefono(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreoConfirmado(false);
		setTelefonoConfirmado(false);
	}
	
	public UsuarioDTO(final UUID id) {
		setId(id);
		setTipoDocumento(TipoDocumentoDTO.obtenerValorDefecto());
		setNumeroIdentificacion(UtilTexto.getInstance().obtenerValorDefecto());
		setNombres(UtilTexto.getInstance().obtenerValorDefecto());
		setApellidos(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setTelefono(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreoConfirmado(false);
		setTelefonoConfirmado(false);
	}
	
	public UsuarioDTO(final UUID id, final TipoDocumentoDTO tipoDocumento, final String numeroIdentificacion, final String nombres,
			final String apellidos, final String correo, final String telefono, final boolean correoConfirmado, final boolean telefonoConfirmado) {
		setId(id);
		setTipoDocumento(tipoDocumento);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombres(nombres);
		setApellidos(apellidos);
		setCorreo(correo);
		setTelefono(telefono);
		setCorreoConfirmado(correoConfirmado);
		setTelefonoConfirmado(telefonoConfirmado);
	}

	public static UsuarioDTO obtenerValorDefecto() {
		return new UsuarioDTO();
	}
	
	public static UsuarioDTO obtenerValorDefecto(final UsuarioDTO usuario) {
		return UtilObjeto.getInstance().obtenerValorDefecto(usuario, obtenerValorDefecto());
	}
	
	public UUID getId() {
		return id;
	}

	public UsuarioDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public UsuarioDTO setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = TipoDocumentoDTO.obtenerValorDefecto(tipoDocumento);
		return this;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public UsuarioDTO setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(numeroIdentificacion);
		return this;
	}

	public String getNombres() {
		return nombres;
	}

	public UsuarioDTO setNombres(String nombres) {
		this.nombres = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombres);
		return this;
	}

	public String getApellidos() {
		return apellidos;
	}

	public UsuarioDTO setApellidos(String apellidos) {
		this.apellidos = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(apellidos);
		return this;
	}

	public String getCorreo() {
		return correo;
	}

	public UsuarioDTO setCorreo(String correo) {
		this.correo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(correo);
		return this;
	}

	public String getTelefono() {
		return telefono;
	}

	public UsuarioDTO setTelefono(String telefono) {
		this.telefono = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(telefono);
		return this;
	}

	public boolean isCorreoConfirmado() {
		return correoConfirmado;
	}

	public UsuarioDTO setCorreoConfirmado(boolean correoConfirmado) {
		this.correoConfirmado = correoConfirmado;
		return this;
	}

	public boolean isTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	public UsuarioDTO setTelefonoConfirmado(boolean telefonoConfirmado) {
		this.telefonoConfirmado = telefonoConfirmado;
		return this;
	}
}
