package co.edu.uco.terraxs.entity;
import java.util.UUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public class ProveedorEntity extends UsuarioEntity {

	private CiudadEntity ciudad;

	public ProveedorEntity() {
		super();
		setCiudad(CiudadEntity.obtenerValorDefecto());
	}

	public ProveedorEntity(UUID id, TipoDocumentoEntity tipoDocumento, String numeroIdentificacion, String nombres,
			String apellidos, String correo, String telefono, boolean correoConfirmado, boolean telefonoConfirmado, CiudadEntity ciudad) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado);
		setCiudad(ciudad);
	}

	public static ProveedorEntity obtenerValorDefecto() {
		return new ProveedorEntity();
	}

	public static ProveedorEntity obtenerValorDefecto(final ProveedorEntity proveedor) {
		return UtilObjeto.getInstance().obtenerValorDefecto(proveedor, obtenerValorDefecto());
	}

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public ProveedorEntity setCiudad(CiudadEntity ciudad) {
		this.ciudad = CiudadEntity.obtenerValorDefecto(ciudad);
		return this;
	}
}
