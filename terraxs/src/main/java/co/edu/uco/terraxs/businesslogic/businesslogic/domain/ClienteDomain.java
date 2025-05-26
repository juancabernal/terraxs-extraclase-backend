package co.edu.uco.terraxs.businesslogic.businesslogic.domain;
import java.util.UUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public class ClienteDomain extends UsuarioDomain {

	private CiudadDomain ciudad;

	public ClienteDomain() {
		super();
		setCiudad(CiudadDomain.obtenerValorDefecto());
	}

	public ClienteDomain(final UUID id, final TipoDocumentoDomain tipoDocumento, final String numeroIdentificacion, final String nombres,
			final String apellidos, final String correo, final String telefono, final boolean correoConfirmado, final boolean telefonoConfirmado,
			final CiudadDomain ciudad, final String password) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado, password);
		setCiudad(ciudad);
	}

	public static ClienteDomain obtenerValorDefecto() {
		return new ClienteDomain();
	}

	public static ClienteDomain obtenerValorDefecto(final ClienteDomain cliente) {
		return UtilObjeto.getInstance().obtenerValorDefecto(cliente, obtenerValorDefecto());
	}

	public CiudadDomain getCiudad() {
		return ciudad;
	}

	public ClienteDomain setCiudad(CiudadDomain ciudad) {
		this.ciudad = CiudadDomain.obtenerValorDefecto(ciudad);
		return this;
	}
}
