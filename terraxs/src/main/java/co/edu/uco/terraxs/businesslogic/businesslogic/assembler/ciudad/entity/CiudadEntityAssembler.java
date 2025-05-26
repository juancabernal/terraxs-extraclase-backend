package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.ciudad.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.departamento.entity.DepartamentoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.CiudadEntity;

public class CiudadEntityAssembler implements EntityAssembler<CiudadEntity, CiudadDomain> {

	private static final CiudadEntityAssembler INSTANCE = new CiudadEntityAssembler();

	private CiudadEntityAssembler() {
		super();
	}

	public static CiudadEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public CiudadEntity toEntity(CiudadDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? CiudadEntity.obtenerValorDefecto()
				: new CiudadEntity(domain.getId(), domain.getNombre(),
						DepartamentoEntityAssembler.getInstance().toEntity(domain.getDepartamento()));
	}

	@Override
	public CiudadDomain toDomain(CiudadEntity entity) {
		var ciudadEntityAEnsamblar = CiudadEntity.obtenerValorDefecto(entity);
		return new CiudadDomain(
				ciudadEntityAEnsamblar.getId(),
				ciudadEntityAEnsamblar.getNombre(),
				DepartamentoEntityAssembler.getInstance().toDomain(ciudadEntityAEnsamblar.getDepartamento())
		);
	}

	@Override
	public List<CiudadDomain> toDomain(List<CiudadEntity> entityList) {
		var listaResultados = new ArrayList<CiudadDomain>();
		for (CiudadEntity ciudadEntity : entityList) {
			listaResultados.add(toDomain(ciudadEntity));
		}
		return listaResultados;
	}
}
