package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipodocumento.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.TipoDocumentoEntity;

public class TipoDocumentoEntityAssembler implements EntityAssembler<TipoDocumentoEntity, TipoDocumentoDomain> {

	private static final TipoDocumentoEntityAssembler INSTANCE = new TipoDocumentoEntityAssembler();

	private TipoDocumentoEntityAssembler() {
		super();
	}

	public static TipoDocumentoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoDocumentoEntity toEntity(TipoDocumentoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? TipoDocumentoEntity.obtenerValorDefecto()
				: new TipoDocumentoEntity(domain.getId(), domain.getNombre());
	}

	@Override
	public TipoDocumentoDomain toDomain(TipoDocumentoEntity entity) {
		var tipoDocumentoEntityAEnsamblar = TipoDocumentoEntity.obtenerValorDefecto(entity);
		return new TipoDocumentoDomain(
				tipoDocumentoEntityAEnsamblar.getId(),
				tipoDocumentoEntityAEnsamblar.getNombre()
		);
	}

	@Override
	public List<TipoDocumentoDomain> toDomain(List<TipoDocumentoEntity> entityList) {
		var listaResultados = new ArrayList<TipoDocumentoDomain>();
		for (TipoDocumentoEntity tipoDocumentoEntity : entityList) {
			listaResultados.add(toDomain(tipoDocumentoEntity));
		}
		return listaResultados;
	}
}
