package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class AdministradorEntity {

	private UUID id;
	private TipoDocumentoEntity tipoDocumento;
	private String numeroIdentificacion;
	private String nombres;
	private String apellidos;
	private String correo;
	private boolean correoConfirmado;
	private String telefono;
	private boolean telefonoConfirmado;

	public AdministradorEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setTipoDocumento(TipoDocumentoEntity.obtenerValorDefecto());
		setNumeroIdentificacion(UtilTexto.getInstance().obtenerValorDefecto());
		setNombres(UtilTexto.getInstance().obtenerValorDefecto());
		setApellidos(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreoConfirmado(false);
		setTelefono(UtilTexto.getInstance().obtenerValorDefecto());
		setTelefonoConfirmado(false);
	}

	public static AdministradorEntity obtenerValorDefecto() {
		return new AdministradorEntity();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = TipoDocumentoEntity.obtenerValorDefecto(tipoDocumento);
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

	public boolean isCorreoConfirmado() {
		return correoConfirmado;
	}

	public void setCorreoConfirmado(boolean correoConfirmado) {
		this.correoConfirmado = correoConfirmado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(telefono);
	}

	public boolean isTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	public void setTelefonoConfirmado(boolean telefonoConfirmado) {
		this.telefonoConfirmado = telefonoConfirmado;
	}
}
