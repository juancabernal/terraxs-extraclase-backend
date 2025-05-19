package co.edu.uco.terraxs.crosscutting.excepciones;

public class ApiTerraxsException extends TerraxsException {


	private static final long serialVersionUID = 1L;

	private ApiTerraxsException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.API);
	}
	
	
	
	public static TerraxsException reportar(String mensajeUsuario) {
		return new ApiTerraxsException(mensajeUsuario,mensajeUsuario,new Exception());
	}
	
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico) {
		return new ApiTerraxsException(mensajeUsuario,mensajeTecnico,new Exception());
	}
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico,Exception excepcionRaiz) {
		return new ApiTerraxsException(mensajeUsuario,mensajeTecnico,excepcionRaiz);
	}


}
