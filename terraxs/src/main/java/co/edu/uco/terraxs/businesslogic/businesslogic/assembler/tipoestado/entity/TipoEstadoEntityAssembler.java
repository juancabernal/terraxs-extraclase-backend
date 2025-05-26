package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipoestado.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoEstadoDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.TipoEstadoEntity;

public class TipoEstadoEntityAssembler implements EntityAssembler<TipoEstadoEntity, TipoEstadoDomain> {
	
	private static final TipoEstadoEntityAssembler INSTANCE = new TipoEstadoEntityAssembler();

	private TipoEstadoEntityAssembler() {
		super();
	}
	
	public static TipoEstadoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoEstadoEntity toEntity(TipoEstadoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? TipoEstadoEntity.obtenerValorDefecto()
				: new TipoEstadoEntity(domain.getId(), domain.getNombre());
	}

	@Override
	public TipoEstadoDomain toDomain(TipoEstadoEntity entity) {
		var tipoEstadoEntityAEnsamblar = TipoEstadoEntity.obtenerValorDefecto(entity);
		return new TipoEstadoDomain(tipoEstadoEntityAEnsamblar.getId(), tipoEstadoEntityAEnsamblar.getNombre());
	}

	@Override
	public List<TipoEstadoDomain> toDomain(List<TipoEstadoEntity> entityList) {
		var listaResultados = new ArrayList<TipoEstadoDomain>();
		for (TipoEstadoEntity tipoEstadoEntity : entityList) {
			listaResultados.add(toDomain(tipoEstadoEntity));
		}
		return listaResultados;
	}
}
