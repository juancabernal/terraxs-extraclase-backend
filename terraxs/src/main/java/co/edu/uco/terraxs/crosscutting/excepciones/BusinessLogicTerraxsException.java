package co.edu.uco.terraxs.crosscutting.excepciones;

public class BusinessLogicTerraxsException extends TerraxsException {


	private static final long serialVersionUID = 1L;

	private BusinessLogicTerraxsException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.BUSINESS_LOGIC);
	}
	
	
	
	public static TerraxsException reportar(String mensajeUsuario) {
		return new BusinessLogicTerraxsException(mensajeUsuario,mensajeUsuario,new Exception());
	}
	
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico) {
		return new BusinessLogicTerraxsException(mensajeUsuario,mensajeTecnico,new Exception());
	}
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico,Exception excepcionRaiz) {
		return new BusinessLogicTerraxsException(mensajeUsuario,mensajeTecnico,excepcionRaiz);
	}


}
