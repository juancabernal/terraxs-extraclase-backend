package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public class ClienteDTO extends UsuarioDTO {

	private CiudadDTO ciudad;

	public ClienteDTO() {
		super();
		setCiudad(CiudadDTO.obtenerValorDefecto());
	}
	
	public ClienteDTO(final UUID id, final TipoDocumentoDTO tipoDocumento, final String numeroIdentificacion, final String nombres,
			final String apellidos, final String correo, final String telefono, final boolean correoConfirmado, final boolean telefonoConfirmado,
			final CiudadDTO ciudad) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado);
		setCiudad(ciudad);
	}

	public static ClienteDTO obtenerValorDefecto() {
		return new ClienteDTO();
	}
	
	public static ClienteDTO obtenerValorDefecto(final ClienteDTO cliente) {
		return UtilObjeto.getInstance().obtenerValorDefecto(cliente, obtenerValorDefecto());
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public ClienteDTO setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
		return this;
	}
}








	
