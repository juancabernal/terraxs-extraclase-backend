package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.usuario.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipodocumento.entity.TipoDocumentoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.UsuarioEntity;

public class UsuarioEntityAssembler implements EntityAssembler<UsuarioEntity, UsuarioDomain> {

	private static final UsuarioEntityAssembler INSTANCE = new UsuarioEntityAssembler();

	private UsuarioEntityAssembler() {
		super();
	}

	public static UsuarioEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public UsuarioEntity toEntity(UsuarioDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? UsuarioEntity.obtenerValorDefecto()
				: new UsuarioEntity(
						domain.getId(),
						TipoDocumentoEntityAssembler.getInstance().toEntity(domain.getTipoDocumento()),
						domain.getNumeroIdentificacion(),
						domain.getNombres(),
						domain.getApellidos(),
						domain.getCorreo(),
						domain.getTelefono(),
						domain.isCorreoConfirmado(),
						domain.isTelefonoConfirmado(),
						domain.getPassword()
				);
	}

	@Override
	public UsuarioDomain toDomain(UsuarioEntity entity) {
		var usuarioEntityAEnsamblar = UsuarioEntity.obtenerValorDefecto(entity);
		return new UsuarioDomain(
				usuarioEntityAEnsamblar.getId(),
				TipoDocumentoEntityAssembler.getInstance().toDomain(usuarioEntityAEnsamblar.getTipoDocumento()),
				usuarioEntityAEnsamblar.getNumeroIdentificacion(),
				usuarioEntityAEnsamblar.getNombres(),
				usuarioEntityAEnsamblar.getApellidos(),
				usuarioEntityAEnsamblar.getCorreo(),
				usuarioEntityAEnsamblar.getTelefono(),
				usuarioEntityAEnsamblar.isCorreoConfirmado(),
				usuarioEntityAEnsamblar.isTelefonoConfirmado(),
				usuarioEntityAEnsamblar.getPassword()
		);
	}

	@Override
	public List<UsuarioDomain> toDomain(List<UsuarioEntity> entityList) {
		var listaResultados = new ArrayList<UsuarioDomain>();
		for (UsuarioEntity usuarioEntity : entityList) {
			listaResultados.add(toDomain(usuarioEntity));
		}
		return listaResultados;
	}
}
