package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

public final class CategoriaProductoDTO{

	private UUID id;
	private String nombre;
	private String descripcion;

	public CategoriaProductoDTO(){
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());

	}

	public CategoriaProductoDTO(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
	}

	public CategoriaProductoDTO(final UUID id, final String nombre,final String descripcion) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
	}

	public static CategoriaProductoDTO obtenerValorDefecto() {
		return new CategoriaProductoDTO();
	}

	public static CategoriaProductoDTO obtenerValorDefecto(final CategoriaProductoDTO categoriaProducto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(categoriaProducto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
	}
	

}
