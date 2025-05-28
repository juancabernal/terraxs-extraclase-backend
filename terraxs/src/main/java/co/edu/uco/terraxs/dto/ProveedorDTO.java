package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;

public class ProveedorDTO extends UsuarioDTO {

	private String direccionResidencia;
	private CiudadDTO ciudad;

	public ProveedorDTO() {
		super();
		setDireccionResidencia(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDTO.obtenerValorDefecto());
	}
	
	public ProveedorDTO(final UUID id, final TipoDocumentoDTO tipoDocumento, final String numeroIdentificacion, final String nombres,
			final String apellidos, final String correo, final String telefono, final boolean correoConfirmado, final boolean telefonoConfirmado, final String direccionResidencia, final CiudadDTO ciudad, final String password) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado, password);  //agregar ,confirmPassword
		setDireccionResidencia(direccionResidencia);
		setCiudad(ciudad);
	}

	public static ProveedorDTO obtenerValorDefecto() {
		return new ProveedorDTO();
	}
	
	public static ProveedorDTO obtenerValorDefecto(final ProveedorDTO proveedor) {
		return UtilObjeto.getInstance().obtenerValorDefecto(proveedor, obtenerValorDefecto());
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

	public ProveedorDTO setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);		
		return this;
	}
	
	@Override
	public String toString() {
	    return "ProveedorDTO{" +
	            "id=" + id +
	            ", tipoDocumento=" + (tipoDocumento != null ? tipoDocumento.getNombre() : null) +
	            ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
	            ", nombres='" + nombres + '\'' +
	            ", apellidos='" + apellidos + '\'' +
	            ", correo='" + correo + '\'' +
	            ", telefono='" + telefono + '\'' +
	            ", correoConfirmado=" + correoConfirmado +
	            ", telefonoConfirmado=" + telefonoConfirmado +
	            ", direccionResidencia='" + direccionResidencia + '\'' +
	            ", ciudad=" + (ciudad != null ? ciudad.getNombre() : null) +
	            '}';
	}

}

