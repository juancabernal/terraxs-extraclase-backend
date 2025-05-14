package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class CiudadDomain {

	private UUID id;
	private String nombre;
	private DepartamentoDomain departamento;

	CiudadDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDepartamento(DepartamentoDomain.obtenerValorDefecto());
	}

	CiudadDomain(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDepartamento(DepartamentoDomain.obtenerValorDefecto());
	}

	public CiudadDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
		setDepartamento(DepartamentoDomain.obtenerValorDefecto());
	}

	public CiudadDomain(final UUID id, final String nombre, final DepartamentoDomain departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	 static CiudadDomain obtenerValorDefecto() {
		return new CiudadDomain();
	}
	
	 static CiudadDomain obtenerValorDefecto(final CiudadDomain ciudad) {
		return UtilObjeto.getInstance().obtenerValorDefecto(ciudad, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public DepartamentoDomain getDepartamento() {
		return departamento;
	}

	private void setDepartamento(final DepartamentoDomain departamento) {
		this.departamento = DepartamentoDomain.obtenerValorDefecto(departamento);
	}

}