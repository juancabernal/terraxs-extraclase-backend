package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.usuario.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipodocumento.dto.TipoDocumentoDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.UsuarioDTO;

public class UsuarioDTOAssembler implements DTOAssembler<UsuarioDTO, UsuarioDomain>{
	
	private static final UsuarioDTOAssembler INSTANCE = new UsuarioDTOAssembler();

	private UsuarioDTOAssembler() {
		super();
	}

	public static UsuarioDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public UsuarioDTO toDTO(final UsuarioDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? UsuarioDTO.obtenerValorDefecto()
				: new UsuarioDTO(
						domain.getId(),
						TipoDocumentoDTOAssembler.getInstance().toDTO(domain.getTipoDocumento()),
						domain.getNumeroIdentificacion(),
						domain.getNombres(),
						domain.getApellidos(),
						domain.getCorreo(),
						domain.getTelefono(),
						domain.isCorreoConfirmado(),
						domain.isTelefonoConfirmado(),
						domain.getPassword());
	}

	@Override
	public UsuarioDomain toDomain(final UsuarioDTO dto) {
		var usuarioDTOAEnsamblar = UsuarioDTO.obtenerValorDefecto(dto);
		return new UsuarioDomain(
				usuarioDTOAEnsamblar.getId(),
				TipoDocumentoDTOAssembler.getInstance().toDomain(usuarioDTOAEnsamblar.getTipoDocumento()),
				usuarioDTOAEnsamblar.getNumeroIdentificacion(),
				usuarioDTOAEnsamblar.getNombres(),
				usuarioDTOAEnsamblar.getApellidos(),
				usuarioDTOAEnsamblar.getCorreo(),
				usuarioDTOAEnsamblar.getTelefono(),
				usuarioDTOAEnsamblar.isCorreoConfirmado(),
				usuarioDTOAEnsamblar.isTelefonoConfirmado(),
				usuarioDTOAEnsamblar.getPassword());
	}

	@Override
	public List<UsuarioDomain> toDomain(List<UsuarioDTO> dtoList) {
		var listaResultados = new ArrayList<UsuarioDomain>();

		for (UsuarioDTO dto : dtoList) {
			listaResultados.add(toDomain(dto));
		}

		return listaResultados;
	}

}
