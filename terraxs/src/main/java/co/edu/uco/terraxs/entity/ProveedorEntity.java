package co.edu.uco.terraxs.entity;
import java.util.UUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;

public class ProveedorEntity extends UsuarioEntity {
	
	private String direccionResidencia;
	private CiudadEntity ciudad;

	public ProveedorEntity() {
		super();
		setDireccionResidencia(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadEntity.obtenerValorDefecto());
	}

	public ProveedorEntity(UUID id, TipoDocumentoEntity tipoDocumento, String numeroIdentificacion, String nombres,
			String apellidos, String correo, String telefono, boolean correoConfirmado, boolean telefonoConfirmado, String direccionResidencia, CiudadEntity ciudad, String password) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado, password);
		setDireccionResidencia(direccionResidencia);
		setCiudad(ciudad);
	}

	public static ProveedorEntity obtenerValorDefecto() {
		return new ProveedorEntity();
	}

	public static ProveedorEntity obtenerValorDefecto(final ProveedorEntity proveedor) {
		return UtilObjeto.getInstance().obtenerValorDefecto(proveedor, obtenerValorDefecto());
	}
	
	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccionResidencia);
	}

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public ProveedorEntity setCiudad(CiudadEntity ciudad) {
		this.ciudad = CiudadEntity.obtenerValorDefecto(ciudad);
		return this;
	}
}
