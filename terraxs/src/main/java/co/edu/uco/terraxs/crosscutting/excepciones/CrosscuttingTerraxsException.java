package co.edu.uco.terraxs.crosscutting.excepciones;

public class CrosscuttingTerraxsException extends TerraxsException {


	private static final long serialVersionUID = 1L;

	private CrosscuttingTerraxsException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.CROSSCUTTING);
	}
	
	
	
	public static TerraxsException reportar(String mensajeUsuario) {
		return new CrosscuttingTerraxsException(mensajeUsuario,mensajeUsuario,new Exception());
	}
	
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico) {
		return new CrosscuttingTerraxsException(mensajeUsuario,mensajeTecnico,new Exception());
	}
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico,Exception excepcionRaiz) {
		return new CrosscuttingTerraxsException(mensajeUsuario,mensajeTecnico,excepcionRaiz);
	}


}
