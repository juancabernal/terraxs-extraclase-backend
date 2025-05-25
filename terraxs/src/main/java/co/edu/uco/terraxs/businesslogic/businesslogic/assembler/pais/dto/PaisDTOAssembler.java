package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.PaisDTO;

public final class PaisDTOAssembler implements DTOAssembler<PaisDTO, PaisDomain> {
	
	private static final PaisDTOAssembler INSTANCE = new PaisDTOAssembler();
	
	private PaisDTOAssembler() {
		super();
	}
	
	public static PaisDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public PaisDTO toDTO(final PaisDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? PaisDTO.obtenerValorDefecto()
						: new PaisDTO(domain.getId(),domain.getNombre());
	}

	@Override
	public PaisDomain toDomain(final PaisDTO dto) {
		var paisDTOAEnsamblar = PaisDTO.obtenerValorDefecto(dto);
		return new PaisDomain(paisDTOAEnsamblar.getId(), paisDTOAEnsamblar.getNombre());
	}

	@Override
	public List<PaisDomain> toDomain(List<PaisDTO> dtoList) {
		var listaResultados = new ArrayList<PaisDomain>();
		
		for (PaisDTO paisDTO : dtoList) {
			listaResultados.add(toDomain(paisDTO));	
		}
		
		return listaResultados;
	}


}
