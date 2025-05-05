package co.edu.uco.terraxs.dto;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class DepartamentoDTO {

	private UUID id;
	private String nombre;
	private PaisDTO pais;

	public DepartamentoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setPais(PaisDTO.obtenerValorDefecto());
	}

	public DepartamentoDTO(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setPais(PaisDTO.obtenerValorDefecto());
	}

	public DepartamentoDTO(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
		setPais(PaisDTO.obtenerValorDefecto());
	}

	public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}

	public static DepartamentoDTO obtenerValorDefecto() {
		return new DepartamentoDTO();
	}

	public static DepartamentoDTO obtenerValorDefecto(final DepartamentoDTO departamento) {
		return UtilObjeto.getInstance().obtenerValorDefecto(departamento, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public DepartamentoDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public PaisDTO getPais() {
		return pais;
	}

	public DepartamentoDTO setPais(final PaisDTO pais) {
		this.pais = PaisDTO.obtenerValorDefecto(pais);
		return this;
	}

}
