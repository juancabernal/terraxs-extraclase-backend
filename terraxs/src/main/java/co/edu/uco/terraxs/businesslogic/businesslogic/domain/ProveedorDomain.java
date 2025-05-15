package co.edu.uco.terraxs.businesslogic.businesslogic.domain;
import java.util.UUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public class ProveedorDomain extends UsuarioDomain {

	private CiudadDomain ciudad;

	public ProveedorDomain() {
		super();
		setCiudad(CiudadDomain.obtenerValorDefecto());
	}

	public ProveedorDomain(UUID id, TipoDocumentoDomain tipoDocumento, String numeroIdentificacion, String nombres,
			String apellidos, String correo, String telefono, boolean correoConfirmado, boolean telefonoConfirmado, CiudadDomain ciudad) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado);
		setCiudad(ciudad);
	}

	public static ProveedorDomain obtenerValorDefecto() {
		return new ProveedorDomain();
	}

	public static ProveedorDomain obtenerValorDefecto(final ProveedorDomain proveedor) {
		return UtilObjeto.getInstance().obtenerValorDefecto(proveedor, obtenerValorDefecto());
	}

	public CiudadDomain getCiudad() {
		return ciudad;
	}

	public ProveedorDomain setCiudad(CiudadDomain ciudad) {
		this.ciudad = CiudadDomain.obtenerValorDefecto(ciudad);
		return this;
	}
}
