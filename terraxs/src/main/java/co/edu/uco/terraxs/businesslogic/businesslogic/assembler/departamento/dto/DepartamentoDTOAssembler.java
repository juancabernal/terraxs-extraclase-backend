package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.departamento.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.dto.PaisDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.DepartamentoDTO;

public class DepartamentoDTOAssembler implements DTOAssembler<DepartamentoDTO, DepartamentoDomain> {
	
	private static final DepartamentoDTOAssembler INSTANCE = new DepartamentoDTOAssembler();
	
	private DepartamentoDTOAssembler() {
		super();
	}
	
	public static DepartamentoDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public DepartamentoDTO toDTO(final DepartamentoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? DepartamentoDTO.obtenerValorDefecto()
						: new DepartamentoDTO(domain.getId(),domain.getNombre(),  PaisDTOAssembler.getInstance().toDTO(domain.getPais()));
	}

	@Override
	public DepartamentoDomain toDomain(final DepartamentoDTO dto) {
		var departamentoDTOAEnsamblar = DepartamentoDTO.obtenerValorDefecto(dto);
		return new DepartamentoDomain(departamentoDTOAEnsamblar.getId(), departamentoDTOAEnsamblar.getNombre(), PaisDTOAssembler.getInstance().toDomain(departamentoDTOAEnsamblar.getPais()));
	}

	@Override
	public List<DepartamentoDomain> toDomain(List<DepartamentoDTO> dtoList) {
		var listaResultados = new ArrayList<DepartamentoDomain>();
		
		for (DepartamentoDTO departamentoDTO : dtoList) {
			listaResultados.add(toDomain(departamentoDTO));	
		}
		
		return listaResultados;
	}

}
