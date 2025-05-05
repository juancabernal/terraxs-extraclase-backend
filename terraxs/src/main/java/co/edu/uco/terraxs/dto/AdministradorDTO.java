package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class AdministradorDTO {

	private UUID id;
	private TipoDocumentoDTO tipoDocumento;
	private String numeroIdentificacion;
	private String nombres;
	private String apellidos;
	private String correo;
	private boolean correoConfirmado;
	private String telefono;
	private boolean telefonoConfirmado;

	public AdministradorDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setTipoDocumento(TipoDocumentoDTO.obtenerValorDefecto());
		setNumeroIdentificacion(UtilTexto.getInstance().obtenerValorDefecto());
		setNombres(UtilTexto.getInstance().obtenerValorDefecto());
		setApellidos(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreoConfirmado(false);
		setTelefono(UtilTexto.getInstance().obtenerValorDefecto());
		setTelefonoConfirmado(false);
	}
	
	public AdministradorDTO(final UUID id) {
		setId(id);
		setTipoDocumento(TipoDocumentoDTO.obtenerValorDefecto());
		setNumeroIdentificacion(UtilTexto.getInstance().obtenerValorDefecto());
		setNombres(UtilTexto.getInstance().obtenerValorDefecto());
		setApellidos(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreoConfirmado(false);
		setTelefono(UtilTexto.getInstance().obtenerValorDefecto());
		setTelefonoConfirmado(false);
	}
	
    public AdministradorDTO(UUID id, TipoDocumentoDTO tipoDocumento, String numeroIdentificacion,
            String nombres, String apellidos, String correo, boolean correoConfirmado,
            String telefono, boolean telefonoConfirmado) {
			setId(id);
			setTipoDocumento(tipoDocumento);
			setNumeroIdentificacion(numeroIdentificacion);
			setNombres(nombres);
			setApellidos(apellidos);
			setCorreo(correo);
			setCorreoConfirmado(correoConfirmado);
			setTelefono(telefono);
			setTelefonoConfirmado(telefonoConfirmado);
	}

	public static AdministradorDTO obtenerValorDefecto() {
		return new AdministradorDTO();
	}

	public UUID getId() {
		return id;
	}

	public AdministradorDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public AdministradorDTO setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = TipoDocumentoDTO.obtenerValorDefecto(tipoDocumento);
		return this;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public AdministradorDTO setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(numeroIdentificacion);
		return this;
	}

	public String getNombres() {
		return nombres;
	}

	public AdministradorDTO setNombres(String nombres) {
		this.nombres = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombres);
		return this;
	}

	public String getApellidos() {
		return apellidos;
	}

	public AdministradorDTO setApellidos(String apellidos) {
		this.apellidos = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(apellidos);
		return this;
	}

	public String getCorreo() {
		return correo;
	}

	public AdministradorDTO setCorreo(String correo) {
		this.correo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(correo);
		return this;
	}

	public boolean isCorreoConfirmado() {
		return correoConfirmado;
	}

	public AdministradorDTO setCorreoConfirmado(boolean correoConfirmado) {
		this.correoConfirmado = correoConfirmado;
		return this;
	}

	public String getTelefono() {
		return telefono;
	}

	public AdministradorDTO setTelefono(String telefono) {
		this.telefono = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(telefono);
		return this;
	}

	public boolean isTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	public AdministradorDTO setTelefonoConfirmado(boolean telefonoConfirmado) {
		this.telefonoConfirmado = telefonoConfirmado;
		return this;
	}
}
