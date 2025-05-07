package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public class ProveedorDTO extends UsuarioDTO {

	private CiudadDTO ciudad;

	public ProveedorDTO() {
		super();
		setCiudad(CiudadDTO.obtenerValorDefecto());
	}
	
	public ProveedorDTO(UUID id, TipoDocumentoDTO tipoDocumento, String numeroIdentificacion, String nombres,
			String apellidos, String correo, String telefono, boolean correoConfirmado, boolean telefonoConfirmado, CiudadDTO ciudad) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado);
		setCiudad(ciudad);
	}

	public static ProveedorDTO obtenerValorDefecto() {
		return new ProveedorDTO();
	}
	
	public static ProveedorDTO obtenerValorDefecto(final ProveedorDTO proveedor) {
		return UtilObjeto.getInstance().obtenerValorDefecto(proveedor, obtenerValorDefecto());
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public ProveedorDTO setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);		
		return this;
	}
}

