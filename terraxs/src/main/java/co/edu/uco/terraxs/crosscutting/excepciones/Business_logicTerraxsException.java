package co.edu.uco.terraxs.crosscutting.excepciones;

public class Business_logicTerraxsException extends TerraxsException {


	private static final long serialVersionUID = 1L;

	private Business_logicTerraxsException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.BUSINESS_LOGIC);
	}
	
	
	
	public static TerraxsException reportar(String mensajeUsuario) {
		return new Business_logicTerraxsException(mensajeUsuario,mensajeUsuario,new Exception());
	}
	
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico) {
		return new Business_logicTerraxsException(mensajeUsuario,mensajeTecnico,new Exception());
	}
	
	public static TerraxsException reportar(String mensajeUsuario,String mensajeTecnico,Exception excepcionRaiz) {
		return new Business_logicTerraxsException(mensajeUsuario,mensajeTecnico,excepcionRaiz);
	}


}
