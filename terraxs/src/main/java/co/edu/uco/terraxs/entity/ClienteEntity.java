package co.edu.uco.terraxs.entity;
import java.util.UUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public class ClienteEntity extends UsuarioEntity {

	private CiudadEntity ciudad;

	public ClienteEntity() {
		super();
		setCiudad(CiudadEntity.obtenerValorDefecto());
	}

	public ClienteEntity(final UUID id, final TipoDocumentoEntity tipoDocumento, final String numeroIdentificacion, final String nombres,
			final String apellidos, final String correo, final String telefono, final boolean correoConfirmado, final boolean telefonoConfirmado,
			final CiudadEntity ciudad, final String password) {
		super(id, tipoDocumento, numeroIdentificacion, nombres, apellidos, correo, telefono, correoConfirmado,telefonoConfirmado, password);
		setCiudad(ciudad);
	}

	public static ClienteEntity obtenerValorDefecto() {
		return new ClienteEntity();
	}

	public static ClienteEntity obtenerValorDefecto(final ClienteEntity cliente) {
		return UtilObjeto.getInstance().obtenerValorDefecto(cliente, obtenerValorDefecto());
	}

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public ClienteEntity setCiudad(CiudadEntity ciudad) {
		this.ciudad = CiudadEntity.obtenerValorDefecto(ciudad);
		return this;
	}
}
