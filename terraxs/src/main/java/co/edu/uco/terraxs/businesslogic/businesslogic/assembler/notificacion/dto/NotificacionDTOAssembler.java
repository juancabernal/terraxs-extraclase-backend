package co.edu.uco.terraxs.businesslogic.businesslogic.assembler.notificacion.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.tiponotificacion.dto.TipoNotificacionDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.usuario.dto.UsuarioDTOAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.dto.NotificacionDTO;

public class NotificacionDTOAssembler implements DTOAssembler<NotificacionDTO, NotificacionDomain>{
	
	private static final NotificacionDTOAssembler INSTANCE = new NotificacionDTOAssembler();

	private NotificacionDTOAssembler() {
		super();
	}

	public static NotificacionDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public NotificacionDTO toDTO(final NotificacionDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain)
				? NotificacionDTO.obtenerValorDefecto()
				: new NotificacionDTO(
						domain.getId(),
						domain.getCodigoReferencia(),
						TipoNotificacionDTOAssembler.getInstance().toDTO(domain.getTipoNotificacion()),
						domain.getMensajeAdicional(),
						domain.getFechaHoraEnvio(),
						UsuarioDTOAssembler.getInstance().toDTO(domain.getUsuarioReceptor()));
	}

	@Override
	public NotificacionDomain toDomain(final NotificacionDTO dto) {
		var notificacionDTOAEnsamblar = NotificacionDTO.obtenerValorDefecto(dto);
		return new NotificacionDomain(
				notificacionDTOAEnsamblar.getId(),
				notificacionDTOAEnsamblar.getCodigoReferencia(),
				TipoNotificacionDTOAssembler.getInstance().toDomain(notificacionDTOAEnsamblar.getTipoNotificacion()),
				notificacionDTOAEnsamblar.getMensajeAdicional(),
				notificacionDTOAEnsamblar.getFechaHoraEnvio(),
				UsuarioDTOAssembler.getInstance().toDomain(notificacionDTOAEnsamblar.getUsuarioReceptor()));
	}

	@Override
	public List<NotificacionDomain> toDomain(List<NotificacionDTO> dtoList) {
		var listaResultados = new ArrayList<NotificacionDomain>();

		for (NotificacionDTO dto : dtoList) {
			listaResultados.add(toDomain(dto));
		}

		return listaResultados;
	}


}
