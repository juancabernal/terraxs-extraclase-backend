package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tiponotificacion.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.TipoNotificacionDTO;

public class TipoNotificacionDTOAssembler implements DTOAssembler<TipoNotificacionDTO, TipoNotificacionDomain>{
	
	private static final TipoNotificacionDTOAssembler INSTANCE = new TipoNotificacionDTOAssembler();

	private TipoNotificacionDTOAssembler() {
		super();
	}

	public static TipoNotificacionDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoNotificacionDTO toDTO(final TipoNotificacionDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) 
				? TipoNotificacionDTO.obtenerValorDefecto()
				: new TipoNotificacionDTO(domain.getId(), domain.getNombre(), domain.getMensaje());
	}

	@Override
	public TipoNotificacionDomain toDomain(final TipoNotificacionDTO dto) {
		var tipoNotificacionDTOAEnsamblar = TipoNotificacionDTO.obtenerValorDefecto(dto);
		return new TipoNotificacionDomain(tipoNotificacionDTOAEnsamblar.getId(), tipoNotificacionDTOAEnsamblar.getNombre(), tipoNotificacionDTOAEnsamblar.getMensaje());
	}

	@Override
	public List<TipoNotificacionDomain> toDomain(List<TipoNotificacionDTO> dtoList) {
		var listaResultados = new ArrayList<TipoNotificacionDomain>();

		for (TipoNotificacionDTO dto : dtoList) {
			listaResultados.add(toDomain(dto));
		}

		return listaResultados;
	}	

}
