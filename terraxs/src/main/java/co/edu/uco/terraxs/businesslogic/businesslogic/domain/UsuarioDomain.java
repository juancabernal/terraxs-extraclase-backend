package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public class UsuarioDomain {

	private UUID id;
	private TipoDocumentoDomain tipoDocumento;
	private String numeroIdentificacion;
	private String nombres;
	private String apellidos;
	private String correo;
	private String telefono;
	private boolean correoConfirmado;
	private boolean telefonoConfirmado;
	private String password;
	//private String confirmPassword;



	

	public UsuarioDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setTipoDocumento(TipoDocumentoDomain.obtenerValorDefecto());
		setNumeroIdentificacion(UtilTexto.getInstance().obtenerValorDefecto());
		setNombres(UtilTexto.getInstance().obtenerValorDefecto());
		setApellidos(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setTelefono(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreoConfirmado(false);
		setTelefonoConfirmado(false);
		setPassword(UtilTexto.getInstance().obtenerValorDefecto());
		//setConfirmPassword(UtilTexto.getInstance().obtenerValorDefecto());


	}
	
	public UsuarioDomain(final UUID id) {
		setId(id);
		setTipoDocumento(TipoDocumentoDomain.obtenerValorDefecto());
		setNumeroIdentificacion(UtilTexto.getInstance().obtenerValorDefecto());
		setNombres(UtilTexto.getInstance().obtenerValorDefecto());
		setApellidos(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setTelefono(UtilTexto.getInstance().obtenerValorDefecto());
		setCorreoConfirmado(false);
		setTelefonoConfirmado(false);
		setPassword(UtilTexto.getInstance().obtenerValorDefecto());
		//setConfirmPassword(UtilTexto.getInstance().obtenerValorDefecto());


	}

	public UsuarioDomain(UUID id, TipoDocumentoDomain tipoDocumento, String numeroIdentificacion,
			String nombres, String apellidos, String correo, String telefono,
			boolean correoConfirmado, boolean telefonoConfirmado,String password   ) {  // crear ,String confirmPassword
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
		//setConfirmPassword(confirmPassword);


	}

	public static UsuarioDomain obtenerValorDefecto() {
		return new UsuarioDomain();
	}

	public static UsuarioDomain obtenerValorDefecto(final UsuarioDomain usuario) {
		return UtilObjeto.getInstance().obtenerValorDefecto(usuario, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoDocumentoDomain getTipoDocumento() {
		return tipoDocumento;
	}

	public UsuarioDomain setTipoDocumento(TipoDocumentoDomain tipoDocumento) {
		this.tipoDocumento = TipoDocumentoDomain.obtenerValorDefecto(tipoDocumento);
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
		this.password = password;
	}
	/*public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}*/
}
