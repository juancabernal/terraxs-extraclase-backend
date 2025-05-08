package co.edu.uco.terraxs.crosscutting.utilitarios;

public final class UtilNumero {

	private static final UtilNumero instancia = new UtilNumero();

	public static final int ENTERO_DEFECTO = 0;
	public static final double DOUBLE_DEFECTO = 0.0;

	private UtilNumero() {
		// Constructor privado para evitar instanciación externa
	}

	public static UtilNumero getInstance() {
		return instancia;
	}

	public int obtenerValorDefecto(final Integer valor, final int valorDefecto) {
		return UtilObjeto.getInstance().esNulo(valor) ? valorDefecto : valor;
	}

	public int obtenerValorDefecto(final Integer valor) {
		return obtenerValorDefecto(valor, ENTERO_DEFECTO);
	}

	public double obtenerValorDefecto(final Double valor, final double valorDefecto) {
		return UtilObjeto.getInstance().esNulo(valor) ? valorDefecto : valor;
	}

	public double obtenerValorDefecto(final Double valor) {
		return obtenerValorDefecto(valor, DOUBLE_DEFECTO);
	}

	public boolean esPositivo(final int valor) {
		return valor > 0;
	}

	public boolean esPositivo(final double valor) {
		return valor > 0;
	}
}
