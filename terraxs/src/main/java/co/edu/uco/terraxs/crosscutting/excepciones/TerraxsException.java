package co.edu.uco.terraxs.crosscutting.excepciones;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;

public class TerraxsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String mensajeUsuario;
	private LayerException capa;
	
	public LayerException getCapa() {
		return capa;
	}

	public void setCapa(LayerException capa) {
		this.capa =UtilObjeto.getInstance().obtenerValorDefecto(capa, LayerException.GENERAL);
	}

	protected TerraxsException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz,LayerException capa) {
		super(mensajeTecnico, excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setCapa(capa);
	}
	
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
	
	private void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(mensajeUsuario);
	}
	

	
	public String getMensajeTecnico() {
		return UtilTexto.getInstance().obtenerValorDefecto(getMessage());
	}
	public Throwable getExcepcecionRaiz() {
		return UtilObjeto.getInstance().obtenerValorDefecto(getCause(), new Exception(getMensajeUsuario()));
	}



}