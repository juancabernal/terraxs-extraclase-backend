package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.notificacion.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tiponotificacion.entity.TipoNotificacionEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.usuario.entity.UsuarioEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.NotificacionEntity;

public class NotificacionEntityAssembler implements EntityAssembler<NotificacionEntity, NotificacionDomain> {

	private static final NotificacionEntityAssembler INSTANCE = new NotificacionEntityAssembler();

	private NotificacionEntityAssembler() {
		super();
	}

	public static NotificacionEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public NotificacionEntity toEntity(NotificacionDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? NotificacionEntity.obtenerValorDefecto()
				: new NotificacionEntity(
						domain.getId(),
						domain.getCodigoReferencia(),
						TipoNotificacionEntityAssembler.getInstance().toEntity(domain.getTipoNotificacion()),
						domain.getMensajeAdicional(),
						domain.getFechaHoraEnvio(),
						UsuarioEntityAssembler.getInstance().toEntity(domain.getUsuarioReceptor())
				);
	}

	@Override
	public NotificacionDomain toDomain(NotificacionEntity entity) {
		var notificacionEntityAEnsamblar = NotificacionEntity.obtenerValorDefecto(entity);
		return new NotificacionDomain(
				notificacionEntityAEnsamblar.getId(),
				notificacionEntityAEnsamblar.getCodigoReferencia(),
				TipoNotificacionEntityAssembler.getInstance().toDomain(notificacionEntityAEnsamblar.getTipoNotificacion()),
				notificacionEntityAEnsamblar.getMensajeAdicional(),
				notificacionEntityAEnsamblar.getFechaHoraEnvio(),
				UsuarioEntityAssembler.getInstance().toDomain(notificacionEntityAEnsamblar.getUsuarioReceptor())
		);
	}

	@Override
	public List<NotificacionDomain> toDomain(List<NotificacionEntity> entityList) {
		var listaResultados = new ArrayList<NotificacionDomain>();
		for (NotificacionEntity notificacionEntity : entityList) {
			listaResultados.add(toDomain(notificacionEntity));
		}
		return listaResultados;
	}
}
