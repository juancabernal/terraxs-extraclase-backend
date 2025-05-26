package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tokenconfirmacion.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.estado.dto.EstadoDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.notificacion.dto.NotificacionDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class TokenConfirmacionDTOAssembler implements DTOAssembler<TokenConfirmacionDTO, TokenConfirmacionDomain>{
	
	private static final TokenConfirmacionDTOAssembler INSTANCE = new TokenConfirmacionDTOAssembler();

	private TokenConfirmacionDTOAssembler() {
		super();
	}

	public static TokenConfirmacionDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public TokenConfirmacionDTO toDTO(final TokenConfirmacionDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? TokenConfirmacionDTO.obtenerValorDefecto()
				: new TokenConfirmacionDTO(
						domain.getId(),
						domain.getToken(),
						domain.getFechaSolicitud(),
						domain.getFechaExpiracion(),
						EstadoDTOAssembler.getInstance().toDTO(domain.getEstado()),
						NotificacionDTOAssembler.getInstance().toDTO(domain.getNotificacion()));
	}

	@Override
	public TokenConfirmacionDomain toDomain(final TokenConfirmacionDTO dto) {
		var tokenConfirmacionDTOAEnsamblar = TokenConfirmacionDTO.obtenerValorDefecto(dto);
		return new TokenConfirmacionDomain(
				tokenConfirmacionDTOAEnsamblar.getId(),
				tokenConfirmacionDTOAEnsamblar.getToken(),
				tokenConfirmacionDTOAEnsamblar.getFechaSolicitud(),
				tokenConfirmacionDTOAEnsamblar.getFechaExpiracion(),
				EstadoDTOAssembler.getInstance().toDomain(tokenConfirmacionDTOAEnsamblar.getEstado()),
				NotificacionDTOAssembler.getInstance().toDomain(tokenConfirmacionDTOAEnsamblar.getNotificacion()));
	}

	@Override
	public List<TokenConfirmacionDomain> toDomain(List<TokenConfirmacionDTO> dtoList) {
		var listaResultados = new ArrayList<TokenConfirmacionDomain>();
		for (TokenConfirmacionDTO dto : dtoList) {
			listaResultados.add(toDomain(dto));
		}
		return listaResultados;
	}

}
