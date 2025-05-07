package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class AdministradorEntity extends UsuarioEntity {

	public AdministradorEntity() {
		super();
	}

	public AdministradorEntity(final UUID id, final TipoDocumentoEntity tipoDocumento, final String numeroIdentificacion,
			final String nombres, final String apellidos, final String correo, final String telefono, final boolean correoConfirmado, final boolean telefonoConfirmado) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado, telefonoConfirmado);
	}

	public static AdministradorEntity obtenerValorDefecto() {
		return new AdministradorEntity();
	}

	public static AdministradorEntity obtenerValorDefecto(final AdministradorEntity administrador) {
		return UtilObjeto.getInstance().obtenerValorDefecto(administrador, obtenerValorDefecto());
	}
}
