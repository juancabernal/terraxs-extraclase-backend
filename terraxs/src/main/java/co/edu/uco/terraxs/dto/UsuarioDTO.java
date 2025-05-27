package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public class UsuarioDTO {

	protected UUID id;
	protected TipoDocumentoDTO tipoDocumento;
	protected String numeroIdentificacion;
	protected String nombres;
	protected String apellidos;
	protected String correo;
	protected String telefono;
	protected boolean correoConfirmado;
	protected boolean telefonoConfirmado;
	protected String password;


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
		setPassword(UtilTexto.getInstance().obtenerValorDefecto());

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
		setPassword(UtilTexto.getInstance().obtenerValorDefecto());

	}

	public UsuarioDTO(final UUID id, final TipoDocumentoDTO tipoDocumento, final String numeroIdentificacion,
			final String nombres, final String apellidos, final String correo, final String telefono,
			final boolean correoConfirmado, final boolean telefonoConfirmado, final String password) {
		setId(id);
		setTipoDocumento(tipoDocumento);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombres(nombres);
		setApellidos(apellidos);
		setCorreo(correo);
		setTelefono(telefono);
		setCorreoConfirmado(correoConfirmado);
		setTelefonoConfirmado(telefonoConfirmado);
		setPassword(password);

	}

	private UsuarioDTO(final Builder builder) {
		setId(builder.id);
		setTipoDocumento(builder.tipoDocumento);
		setNumeroIdentificacion(builder.numeroIdentificacion);
		setNombres(builder.nombres);
		setApellidos(builder.apellidos);
		setCorreo(builder.correo);
		setTelefono(builder.telefono);
		setCorreoConfirmado(builder.correoConfirmado);
		setTelefonoConfirmado(builder.telefonoConfirmado);
		setPassword(builder.password);

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

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(numeroIdentificacion);
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombres);
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(apellidos);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(correo);
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(telefono);
	}

	public boolean isCorreoConfirmado() {
		return correoConfirmado;
	}

	public void setCorreoConfirmado(boolean correoConfirmado) {
		this.correoConfirmado = correoConfirmado;
	}

	public boolean isTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	public void setTelefonoConfirmado(boolean telefonoConfirmado) {
		this.telefonoConfirmado = telefonoConfirmado;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(password);
	}

	public static class Builder {
		private UUID id;
		private TipoDocumentoDTO tipoDocumento;
		private String numeroIdentificacion;
		private String nombres;
		private String apellidos;
		private String correo;
		private String telefono;
		private boolean correoConfirmado;
		private boolean telefonoConfirmado;
		private String password;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder tipoDocumento(final TipoDocumentoDTO tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
			return this;
		}

		public Builder numeroIdentificacion(final String numeroIdentificacion) {
			this.numeroIdentificacion = numeroIdentificacion;
			return this;
		}

		public Builder nombres(final String nombres) {
			this.nombres = nombres;
			return this;
		}

		public Builder apellidos(final String apellidos) {
			this.apellidos = apellidos;
			return this;
		}

		public Builder correo(final String correo) {
			this.correo = correo;
			return this;
		}

		public Builder telefono(final String telefono) {
			this.telefono = telefono;
			return this;
		}

		public Builder correoConfirmado(final boolean correoConfirmado) {
			this.correoConfirmado = correoConfirmado;
			return this;
		}

		public Builder telefonoConfirmado(final boolean telefonoConfirmado) {
			this.telefonoConfirmado = telefonoConfirmado;
			return this;
		}
		
		public Builder password(final String password) {
			this.password = password;
			return this;
		}

		public UsuarioDTO crear() {
			return new UsuarioDTO(this);
		}
	}
}
