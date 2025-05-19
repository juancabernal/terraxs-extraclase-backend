package co.edu.uco.terraxs.crosscutting.excepciones;

public class DataTerraxsException extends TerraxsException {


	private static final long serialVersionUID = 2151718273608862250L;

	private DataTerraxsException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.DATA);
	}
	
	
	
	public static TerraxsException reportar(String mensajeUsuario) {
		return new DataTerraxsException(mensajeUsuario,mensajeUsuario,new Exception());
	}
	
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico) {
		return new DataTerraxsException(mensajeUsuario,mensajeTecnico,new Exception());
	}
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico,Exception excepcionRaiz) {
		return new DataTerraxsException(mensajeUsuario,mensajeTecnico,excepcionRaiz);
	}


}
