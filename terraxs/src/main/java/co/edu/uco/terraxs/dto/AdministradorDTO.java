package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class AdministradorDTO extends UsuarioDTO {

	public AdministradorDTO() {
		super();
	}

	public AdministradorDTO(final UUID id, final TipoDocumentoDTO tipoDocumento, final String numeroIdentificacion,
			final String nombres, final String apellidos, final String correo, final String telefono, final boolean correoConfirmado, final boolean telefonoConfirmado) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado, telefonoConfirmado);
	}

	public static AdministradorDTO obtenerValorDefecto() {
		return new AdministradorDTO();
	}

	public static AdministradorDTO obtenerValorDefecto(final AdministradorDTO administrador) {
		return UtilObjeto.getInstance().obtenerValorDefecto(administrador, obtenerValorDefecto());
	}
}
