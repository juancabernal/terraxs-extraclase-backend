package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.estado.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipoestado.dto.TipoEstadoDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.EstadoDTO;

public class EstadoDTOAssembler implements DTOAssembler<EstadoDTO, EstadoDomain>  {
	
	private static final EstadoDTOAssembler INSTANCE = new EstadoDTOAssembler();

	private EstadoDTOAssembler() {
		super();
	}

	public static EstadoDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public EstadoDTO toDTO(final EstadoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? EstadoDTO.obtenerValorDefecto()
				: new EstadoDTO(domain.getId(), domain.getNombre(),
						TipoEstadoDTOAssembler.getInstance().toDTO(domain.getTipoEstado()));
	}

	@Override
	public EstadoDomain toDomain(final EstadoDTO dto) {
		var estadoDTOAEnsamblar = EstadoDTO.obtenerValorDefecto(dto);
		return new EstadoDomain(estadoDTOAEnsamblar.getId(), estadoDTOAEnsamblar.getNombre(),
				TipoEstadoDTOAssembler.getInstance().toDomain(estadoDTOAEnsamblar.getTipoEstado()));
	}


	@Override
	public List<EstadoDomain> toDomain(List<EstadoDTO> dtoList) {
		var listaResultados = new ArrayList<EstadoDomain>();

		for (EstadoDTO dto : dtoList) {
			listaResultados.add(toDomain(dto));
		}

		return listaResultados;
	}

}
