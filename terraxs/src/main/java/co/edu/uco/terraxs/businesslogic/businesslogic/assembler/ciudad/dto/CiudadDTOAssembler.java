package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.ciudad.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.departamento.dto.DepartamentoDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.CiudadDTO;

public class CiudadDTOAssembler implements DTOAssembler<CiudadDTO, CiudadDomain>{
	
	private static final CiudadDTOAssembler INSTANCE = new CiudadDTOAssembler();
	
	private CiudadDTOAssembler() {
		super();
	}
	
	public static CiudadDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public CiudadDTO toDTO(final CiudadDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? CiudadDTO.obtenerValorDefecto()
						: new CiudadDTO(domain.getId(),domain.getNombre(), DepartamentoDTOAssembler.getInstance().toDTO(domain.getDepartamento()));
	}
	

	@Override
	public CiudadDomain toDomain(final CiudadDTO dto) {
		var ciudadDTOAEnsamblar = CiudadDTO.obtenerValorDefecto(dto);
		return new CiudadDomain(ciudadDTOAEnsamblar.getId(), ciudadDTOAEnsamblar.getNombre(), DepartamentoDTOAssembler.getInstance().toDomain(ciudadDTOAEnsamblar.getDepartamento()));
	}

	@Override
	public List<CiudadDomain> toDomain(List<CiudadDTO> dtoList) {
		var listaResultados = new ArrayList<CiudadDomain>();
		
		for (CiudadDTO ciudadDTO : dtoList) {
			listaResultados.add(toDomain(ciudadDTO));	
		}
		
		return listaResultados;
	}

}
