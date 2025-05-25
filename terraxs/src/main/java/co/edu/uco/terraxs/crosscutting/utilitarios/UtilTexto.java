package co.edu.uco.terraxs.crosscutting.utilitarios;

public final class UtilTexto {

	private static UtilTexto instancia = new UtilTexto();
	private static final String PATRON_SOLO_LETRAS_ESPACIOS="^[a-zA-ZáéÉíÍóÓúÚñÑ ]+$";

	public final static String VACIO = "";
	
	private UtilTexto() {

	}

	public static UtilTexto getInstance() {
		return instancia;
	}

	public boolean esNula(final String valor) {
		return UtilObjeto.getInstance().esNulo(valor);
	}
	public boolean estaVacia(final String valor) {
		return  VACIO.equals(quitarEspaciosBlancoInicioFin(valor));
	}
	public boolean patronEsValido(final String valor, final String patron) {
		return obtenerValorDefecto(valor).matches(obtenerValorDefecto(patron));
	}
	public boolean contieneSoloLetrasEspacios(final String valor) {
		return patronEsValido(quitarEspaciosBlancoInicioFin(valor),PATRON_SOLO_LETRAS_ESPACIOS);
	}
	
	
	public String obtenerValorDefecto(final String valorOriginal,final String valorDefecto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
	}
	
	public String obtenerValorDefecto(final String valor) {
		return obtenerValorDefecto(valor, VACIO);
	}
	
	public String obtenerValorDefecto() {
		return VACIO;
	}
	
	public String quitarEspaciosBlancoInicioFin(final String valor) {
		return obtenerValorDefecto(valor).trim();
	}
	
}
