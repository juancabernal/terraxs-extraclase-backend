package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.entity.PaisEntity;

public class PaisEntityAssembler implements EntityAssembler<PaisEntity, PaisDomain> {
	
	
	private static final PaisEntityAssembler INSTANCE = new PaisEntityAssembler();
	
	
	private PaisEntityAssembler() {
		super();
	}
	
	

	public static PaisEntityAssembler getInstance() {
		return INSTANCE;
	}



	@Override
	public PaisEntity toEntity(PaisDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? PaisEntity.obtenerValorDefecto()
						: new PaisEntity(domain.getId(),domain.getNombre());
		
		 
	}

	@Override
	public PaisDomain toDomain(PaisEntity entity) {
		var paisEntityAEnsamblar=PaisEntity.obtenerValorDefecto(entity);
		
		return new PaisDomain(paisEntityAEnsamblar.getId(),paisEntityAEnsamblar.getNombre());
	}


	@Override
	public List<PaisDomain> toDomain(List<PaisEntity> entityList) {
		var ListaResultados=new ArrayList<PaisDomain>();
		for (PaisEntity paisEntity: entityList) {
			ListaResultados.add(toDomain(paisEntity));
			
		}
		return ListaResultados;
	}
	

}
