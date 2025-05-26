package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.departamento.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.entity.PaisEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.DepartamentoEntity;

public class DepartamentoEntityAssembler implements EntityAssembler<DepartamentoEntity, DepartamentoDomain> {

	private static final DepartamentoEntityAssembler INSTANCE = new DepartamentoEntityAssembler();

	private DepartamentoEntityAssembler() {
		super();
	}

	public static DepartamentoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public DepartamentoEntity toEntity(DepartamentoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? DepartamentoEntity.obtenerValorDefecto()
				: new DepartamentoEntity(domain.getId(), domain.getNombre(),
						PaisEntityAssembler.getInstance().toEntity(domain.getPais()));
	}

	@Override
	public DepartamentoDomain toDomain(DepartamentoEntity entity) {
		var departamentoEntityAEnsamblar = DepartamentoEntity.obtenerValorDefecto(entity);
		return new DepartamentoDomain(
				departamentoEntityAEnsamblar.getId(),
				departamentoEntityAEnsamblar.getNombre(),
				PaisEntityAssembler.getInstance().toDomain(departamentoEntityAEnsamblar.getPais())
		);
	}

	@Override
	public List<DepartamentoDomain> toDomain(List<DepartamentoEntity> entityList) {
		var listaResultados = new ArrayList<DepartamentoDomain>();
		for (DepartamentoEntity departamentoEntity : entityList) {
			listaResultados.add(toDomain(departamentoEntity));
		}
		return listaResultados;
	}
}
