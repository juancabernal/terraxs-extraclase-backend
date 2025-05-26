package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.estado.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipoestado.entity.TipoEstadoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.EstadoEntity;

public class EstadoEntityAssembler implements EntityAssembler<EstadoEntity, EstadoDomain> {

	private static final EstadoEntityAssembler INSTANCE = new EstadoEntityAssembler();

	private EstadoEntityAssembler() {
		super();
	}

	public static EstadoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public EstadoEntity toEntity(EstadoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? EstadoEntity.obtenerValorDefecto()
				: new EstadoEntity(domain.getId(), domain.getNombre(),
						TipoEstadoEntityAssembler.getInstance().toEntity(domain.getTipoEstado()));
	}

	@Override
	public EstadoDomain toDomain(EstadoEntity entity) {
		var estadoEntityAEnsamblar = EstadoEntity.obtenerValorDefecto(entity);
		return new EstadoDomain(
				estadoEntityAEnsamblar.getId(),
				estadoEntityAEnsamblar.getNombre(),
				TipoEstadoEntityAssembler.getInstance().toDomain(estadoEntityAEnsamblar.getTipoEstado())
		);
	}

	@Override
	public List<EstadoDomain> toDomain(List<EstadoEntity> entityList) {
		var listaResultados = new ArrayList<EstadoDomain>();
		for (EstadoEntity estadoEntity : entityList) {
			listaResultados.add(toDomain(estadoEntity));
		}
		return listaResultados;
	}
}
