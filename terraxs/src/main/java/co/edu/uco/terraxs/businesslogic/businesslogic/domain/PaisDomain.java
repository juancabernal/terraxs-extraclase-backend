package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import java.util.UUID;


public final  class PaisDomain {
	
	private UUID id;
	private String nombre;
	

	
	PaisDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	
	
	public PaisDomain(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		
	}
	
	public PaisDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	 static PaisDomain obtenerValorDefecto() {
		return new PaisDomain();
	}
	
	
	 static PaisDomain obtenerValorDefecto(final PaisDomain pais) {
		return UtilObjeto.getInstance().obtenerValorDefecto(pais, obtenerValorDefecto());
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
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre) ;
	}
	



	
	


}

