package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipodocumento.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;

public class TipoDocumentoDTOAssembler implements DTOAssembler<TipoDocumentoDTO, TipoDocumentoDomain>  {
	
	private static final TipoDocumentoDTOAssembler INSTANCE = new TipoDocumentoDTOAssembler();
	
	private TipoDocumentoDTOAssembler() {
		super();
	}
	
	public static TipoDocumentoDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoDocumentoDTO toDTO(final TipoDocumentoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? TipoDocumentoDTO.obtenerValorDefecto()
						: new TipoDocumentoDTO(domain.getId(),domain.getNombre());
	}

	@Override
	public TipoDocumentoDomain toDomain(final TipoDocumentoDTO dto) {
		var tipoDocumentoDTOAEnsamblar = TipoDocumentoDTO.obtenerValorDefecto(dto);
		return new TipoDocumentoDomain(tipoDocumentoDTOAEnsamblar.getId(), tipoDocumentoDTOAEnsamblar.getNombre());
	}

	@Override
	public List<TipoDocumentoDomain> toDomain(List<TipoDocumentoDTO> dtoList) {
		var listaResultados = new ArrayList<TipoDocumentoDomain>();
		
		for (TipoDocumentoDTO tipoDocumentoDTO : dtoList) {
			listaResultados.add(toDomain(tipoDocumentoDTO));	
		}
		
		return listaResultados;
	}


}
