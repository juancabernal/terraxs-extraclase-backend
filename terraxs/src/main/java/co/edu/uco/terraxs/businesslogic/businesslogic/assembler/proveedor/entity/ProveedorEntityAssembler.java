package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.proveedor.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.ciudad.entity.CiudadEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipodocumento.entity.TipoDocumentoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.ProveedorEntity;

public class ProveedorEntityAssembler implements EntityAssembler<ProveedorEntity, ProveedorDomain> {

	private static final ProveedorEntityAssembler INSTANCE = new ProveedorEntityAssembler();

	private ProveedorEntityAssembler() {
		super();
	}

	public static ProveedorEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public ProveedorEntity toEntity(ProveedorDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? ProveedorEntity.obtenerValorDefecto()
				: new ProveedorEntity(
						domain.getId(),
						TipoDocumentoEntityAssembler.getInstance().toEntity(domain.getTipoDocumento()),
						domain.getNumeroIdentificacion(),
						domain.getNombres(),
						domain.getApellidos(),
						domain.getCorreo(),
						domain.getTelefono(),
						domain.isCorreoConfirmado(),
						domain.isTelefonoConfirmado(),
						domain.getDireccionResidencia(),
						CiudadEntityAssembler.getInstance().toEntity(domain.getCiudad()),
						domain.getPassword()
				);
	}

	@Override
	public ProveedorDomain toDomain(ProveedorEntity entity) {
		var proveedorEntityAEnsamblar = ProveedorEntity.obtenerValorDefecto(entity);

		return new ProveedorDomain(
				proveedorEntityAEnsamblar.getId(),
				TipoDocumentoEntityAssembler.getInstance().toDomain(proveedorEntityAEnsamblar.getTipoDocumento()),
				proveedorEntityAEnsamblar.getNumeroIdentificacion(),
				proveedorEntityAEnsamblar.getNombres(),
				proveedorEntityAEnsamblar.getApellidos(),
				proveedorEntityAEnsamblar.getCorreo(),
				proveedorEntityAEnsamblar.getTelefono(),
				proveedorEntityAEnsamblar.isCorreoConfirmado(),
				proveedorEntityAEnsamblar.isTelefonoConfirmado(),
				proveedorEntityAEnsamblar.getDireccionResidencia(),
				CiudadEntityAssembler.getInstance().toDomain(proveedorEntityAEnsamblar.getCiudad()),
				proveedorEntityAEnsamblar.getPassword()
		);
	}

	@Override
	public List<ProveedorDomain> toDomain(List<ProveedorEntity> entityList) {
		var listaResultados = new ArrayList<ProveedorDomain>();
		for (ProveedorEntity proveedorEntity : entityList) {
			listaResultados.add(toDomain(proveedorEntity));
		}
		return listaResultados;
	}
}
