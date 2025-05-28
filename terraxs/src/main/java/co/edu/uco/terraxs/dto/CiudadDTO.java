package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class CiudadDTO {

	private UUID id;
	private String nombre;
	private DepartamentoDTO departamento;

	public CiudadDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDepartamento(DepartamentoDTO.obtenerValorDefecto());
	}

	public CiudadDTO(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDepartamento(DepartamentoDTO.obtenerValorDefecto());
	}

	public CiudadDTO(final UUID id, final String nombre, final DepartamentoDTO departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	public static CiudadDTO obtenerValorDefecto() {
		return new CiudadDTO();
	}
	
	public static CiudadDTO obtenerValorDefecto(final CiudadDTO ciudad) {
		return UtilObjeto.getInstance().obtenerValorDefecto(ciudad, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public CiudadDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public CiudadDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
		return this;
	}

	public DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public CiudadDTO setDepartamento(final DepartamentoDTO departamento) {
		this.departamento = DepartamentoDTO.obtenerValorDefecto(departamento);
		return this;
	}
	
	@Override
	public String toString() {
		return "CiudadDTO{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", departamento=" + (departamento != null ? departamento.getNombre() : null) +
				'}';
	}

}
