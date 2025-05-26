package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.proveedor.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.ciudad.dto.CiudadDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tipodocumento.dto.TipoDocumentoDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.ProveedorDTO;

public final class ProveedorDTOAssembler implements DTOAssembler<ProveedorDTO, ProveedorDomain> {
	
	private static final ProveedorDTOAssembler INSTANCE = new ProveedorDTOAssembler();
	
	private ProveedorDTOAssembler() {
		super();
	}
	
	public static ProveedorDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public ProveedorDTO toDTO(final ProveedorDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? ProveedorDTO.obtenerValorDefecto()
						: new ProveedorDTO(domain.getId(), TipoDocumentoDTOAssembler.getInstance().toDTO(domain.getTipoDocumento()), 
								domain.getNumeroIdentificacion(), domain.getNombres(), domain.getApellidos(), domain.getCorreo(),
								domain.getTelefono(), domain.isCorreoConfirmado(), domain.isTelefonoConfirmado(), domain.getDireccionResidencia(), 
								CiudadDTOAssembler.getInstance().toDTO(domain.getCiudad()), domain.getPassword());
	}

	@Override
	public ProveedorDomain toDomain(final ProveedorDTO dto) {
		var proveedorDTOAEnsamblar = ProveedorDTO.obtenerValorDefecto(dto);
		return new ProveedorDomain(proveedorDTOAEnsamblar.getId(), TipoDocumentoDTOAssembler.getInstance().toDomain(proveedorDTOAEnsamblar.getTipoDocumento()),
				proveedorDTOAEnsamblar.getNumeroIdentificacion(), proveedorDTOAEnsamblar.getNombres(), proveedorDTOAEnsamblar.getApellidos(), 
				proveedorDTOAEnsamblar.getCorreo(), proveedorDTOAEnsamblar.getTelefono(), proveedorDTOAEnsamblar.isCorreoConfirmado(), 
				proveedorDTOAEnsamblar.isTelefonoConfirmado(), proveedorDTOAEnsamblar.getDireccionResidencia(), 
				CiudadDTOAssembler.getInstance().toDomain(proveedorDTOAEnsamblar.getCiudad()), proveedorDTOAEnsamblar.getPassword());
	}

	@Override
	public List<ProveedorDomain> toDomain(List<ProveedorDTO> dtoList) {
		var listaResultados = new ArrayList<ProveedorDomain>();
		
		for (ProveedorDTO proveedorDTO : dtoList) {
			listaResultados.add(toDomain(proveedorDTO));	
		}
		
		return listaResultados;
	}



}
