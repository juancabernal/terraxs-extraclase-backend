package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tokenconfirmacion.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.estado.entity.EstadoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.notificacion.entity.NotificacionEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.TokenConfirmacionEntity;

public class TokenConfirmacionEntityAssembler implements EntityAssembler<TokenConfirmacionEntity, TokenConfirmacionDomain> {

	private static final TokenConfirmacionEntityAssembler INSTANCE = new TokenConfirmacionEntityAssembler();

	private TokenConfirmacionEntityAssembler() {
		super();
	}

	public static TokenConfirmacionEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public TokenConfirmacionEntity toEntity(TokenConfirmacionDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? TokenConfirmacionEntity.obtenerValorDefecto()
				: new TokenConfirmacionEntity(
						domain.getId(),
						domain.getToken(),
						domain.getFechaSolicitud(),
						domain.getFechaExpiracion(),
						EstadoEntityAssembler.getInstance().toEntity(domain.getEstado()),
						NotificacionEntityAssembler.getInstance().toEntity(domain.getNotificacion())
				);
	}

	@Override
	public TokenConfirmacionDomain toDomain(TokenConfirmacionEntity entity) {
		var tokenEntityAEnsamblar = TokenConfirmacionEntity.obtenerValorDefecto(entity);
		return new TokenConfirmacionDomain(
				tokenEntityAEnsamblar.getId(),
				tokenEntityAEnsamblar.getToken(),
				tokenEntityAEnsamblar.getFechaSolicitud(),
				tokenEntityAEnsamblar.getFechaExpiracion(),
				EstadoEntityAssembler.getInstance().toDomain(tokenEntityAEnsamblar.getEstado()),
				NotificacionEntityAssembler.getInstance().toDomain(tokenEntityAEnsamblar.getNotificacion())
		);
	}

	@Override
	public List<TokenConfirmacionDomain> toDomain(List<TokenConfirmacionEntity> entityList) {
		var listaResultados = new ArrayList<TokenConfirmacionDomain>();
		for (TokenConfirmacionEntity tokenEntity : entityList) {
			listaResultados.add(toDomain(tokenEntity));
		}
		return listaResultados;
	}
}
