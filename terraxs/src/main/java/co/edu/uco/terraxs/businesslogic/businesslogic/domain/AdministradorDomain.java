package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class AdministradorDomain extends UsuarioDomain {

	public AdministradorDomain() {
		super();
	}

	public AdministradorDomain(final UUID id, final TipoDocumentoDomain tipoDocumento, final String numeroIdentificacion,
			final String nombres, final String apellidos, final String correo, final String telefono, final boolean correoConfirmado, final boolean telefonoConfirmado, final String password) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado, telefonoConfirmado, password);
	}

	public static AdministradorDomain obtenerValorDefecto() {
		return new AdministradorDomain();
	}

	public static AdministradorDomain obtenerValorDefecto(final AdministradorDomain administrador) {
		return UtilObjeto.getInstance().obtenerValorDefecto(administrador, obtenerValorDefecto());
	}
}
