package co.edu.uco.terraxs.businesslogic.businesslogic.domain;
import java.util.UUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;

public class ProveedorDomain extends UsuarioDomain {

	private String direccionResidencia;
	private CiudadDomain ciudad;

	public ProveedorDomain() {
		super();
		setDireccionResidencia(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDomain.obtenerValorDefecto());
	}

	public ProveedorDomain(UUID id, TipoDocumentoDomain tipoDocumento, String numeroIdentificacion, String nombres,
			String apellidos, String correo, String telefono, boolean correoConfirmado, boolean telefonoConfirmado, String direccionResidencia, CiudadDomain ciudad) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado);
		setDireccionResidencia(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(ciudad);
	}

	public static ProveedorDomain obtenerValorDefecto() {
		return new ProveedorDomain();
	}

	public static ProveedorDomain obtenerValorDefecto(final ProveedorDomain proveedor) {
		return UtilObjeto.getInstance().obtenerValorDefecto(proveedor, obtenerValorDefecto());
	}
	
	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccionResidencia);
	}

	public CiudadDomain getCiudad() {
		return ciudad;
	}

	public ProveedorDomain setCiudad(CiudadDomain ciudad) {
		this.ciudad = CiudadDomain.obtenerValorDefecto(ciudad);
		return this;
	}
}
