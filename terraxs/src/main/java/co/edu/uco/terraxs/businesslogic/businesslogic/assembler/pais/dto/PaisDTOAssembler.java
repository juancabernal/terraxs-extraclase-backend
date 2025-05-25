package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.dto;

import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
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
	public PaisDTO toDto(final PaisDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDomain toDomain(final PaisDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDomain> toDomain( final List<PaisDTO> ddtoList) {
		// TODO Auto-generated method stub
		return null;
	}

}
