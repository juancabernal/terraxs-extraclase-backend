package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.proveedor.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.PaisDTO;
import co.edu.uco.terraxs.dto.ProveedorDTO;

public final class ProveedorDTOAssembler implements DTOAssembler<ProveedorDTO, ProveedorDomain> {
	
	private static final ProveedorDTOAssembler INSTANCE = new ProveedorDTOAssembler();
	
	private ProveedorDTOAssembler() {
		super();
	}
	
	public static ProveedorDTOAssembler getInstance() {
		return INSTANCE;
	}
/*
	@Override
	public ProveedorDTO toDTO(final ProveedorDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? ProveedorDTO.obtenerValorDefecto()
						: new ProveedorDTO(domain.getId(),domain.getNombres());
	}

	@Override
	public ProveedorDomain toDomain(final ProveedorDTO dto) {
		var proveedorDTOAEnsamblar = ProveedorDTO.obtenerValorDefecto(dto);
		return new ProveedorDomain(proveedorDTOAEnsamblar.getId(), proveedorDTOAEnsamblar.getNombre());
	} */

	@Override
	public List<ProveedorDomain> toDomain(List<ProveedorDTO> dtoList) {
		var listaResultados = new ArrayList<ProveedorDomain>();
		
		for (ProveedorDTO proveedorDTO : dtoList) {
			listaResultados.add(toDomain(proveedorDTO));	
		}
		
		return listaResultados;
	}

@Override
public ProveedorDTO toDTO(ProveedorDomain domain) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ProveedorDomain toDomain(ProveedorDTO dto) {
	// TODO Auto-generated method stub
	return null;
}


}
