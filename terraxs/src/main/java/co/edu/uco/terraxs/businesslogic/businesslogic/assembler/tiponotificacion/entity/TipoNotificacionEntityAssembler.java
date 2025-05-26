package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tiponotificacion.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.TipoNotificacionEntity;

public class TipoNotificacionEntityAssembler implements EntityAssembler<TipoNotificacionEntity, TipoNotificacionDomain> {
	
	private static final TipoNotificacionEntityAssembler INSTANCE = new TipoNotificacionEntityAssembler();
	
	private TipoNotificacionEntityAssembler() {
		super();
	}
	
	public static TipoNotificacionEntityAssembler getInstance() {
		return INSTANCE;
	}
	
	@Override
	public TipoNotificacionEntity toEntity(TipoNotificacionDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? TipoNotificacionEntity.obtenerValorDefecto()
				: new TipoNotificacionEntity(domain.getId(), domain.getNombre(), domain.getMensaje());
	}
	
	@Override
	public TipoNotificacionDomain toDomain(TipoNotificacionEntity entity) {
		var tipoNotificacionEntityAEnsamblar = TipoNotificacionEntity.obtenerValorDefecto(entity);
		return new TipoNotificacionDomain(
				tipoNotificacionEntityAEnsamblar.getId(),
				tipoNotificacionEntityAEnsamblar.getNombre(),
				tipoNotificacionEntityAEnsamblar.getMensaje()
		);
	}
	
	@Override
	public List<TipoNotificacionDomain> toDomain(List<TipoNotificacionEntity> entityList) {
		var listaResultados = new ArrayList<TipoNotificacionDomain>();
		for (TipoNotificacionEntity tipoNotificacionEntity : entityList) {
			listaResultados.add(toDomain(tipoNotificacionEntity));
		}
		return listaResultados;
	}
}
