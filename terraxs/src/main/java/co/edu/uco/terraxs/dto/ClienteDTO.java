package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;

public class ClienteDTO extends UsuarioDTO {

	private String direccionResidencia;
	private CiudadDTO ciudad;

	public ClienteDTO() {
		super();
		setDireccionResidencia(direccionResidencia);
		setCiudad(CiudadDTO.obtenerValorDefecto());
	}
	
	public ClienteDTO(final UUID id, final TipoDocumentoDTO tipoDocumento, final String numeroIdentificacion, final String nombres,
			final String apellidos, final String correo, final String telefono, final boolean correoConfirmado, final boolean telefonoConfirmado,
			final String direccionResidencia, final CiudadDTO ciudad, final String password) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado, password);
		setDireccionResidencia(direccionResidencia);
		setCiudad(ciudad);
	}

	public static ClienteDTO obtenerValorDefecto() {
		return new ClienteDTO();
	}
	
	public static ClienteDTO obtenerValorDefecto(final ClienteDTO cliente) {
		return UtilObjeto.getInstance().obtenerValorDefecto(cliente, obtenerValorDefecto());
	}
	
	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccionResidencia);
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public ClienteDTO setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
		return this;
	}
}








	
