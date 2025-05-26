package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipoestado.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoEstadoDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.TipoEstadoDTO;

public class TipoEstadoDTOAssembler implements DTOAssembler<TipoEstadoDTO, TipoEstadoDomain>  {
	
	private static final TipoEstadoDTOAssembler INSTANCE = new TipoEstadoDTOAssembler();

	private TipoEstadoDTOAssembler() {
		super();
	}

	public static TipoEstadoDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoEstadoDTO toDTO(final TipoEstadoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? TipoEstadoDTO.obtenerValorDefecto()
				: new TipoEstadoDTO(domain.getId(), domain.getNombre());
	}

	@Override
	public TipoEstadoDomain toDomain(final TipoEstadoDTO dto) {
		var tipoEstadoDTOAEnsamblar = TipoEstadoDTO.obtenerValorDefecto(dto);
		return new TipoEstadoDomain(tipoEstadoDTOAEnsamblar.getId(), tipoEstadoDTOAEnsamblar.getNombre());
	}

	@Override
	public List<TipoEstadoDomain> toDomain(List<TipoEstadoDTO> dtoList) {
		var listaResultados = new ArrayList<TipoEstadoDomain>();

		for (TipoEstadoDTO dto : dtoList) {
			listaResultados.add(toDomain(dto));
		}

		return listaResultados;
	}

}
