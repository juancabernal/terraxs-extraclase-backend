package co.edu.uco.terraxs.crosscutting.utilitarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class UtilFecha {

	private static final UtilFecha INSTANCIA = new UtilFecha();
	private static final LocalDateTime FECHA_DEFECTO = LocalDateTime.MIN;
	private static final LocalDate FECHA_SOLO_DIA_DEFECTO = LocalDate.MIN;
	private static final String FORMATO_FECHA_HORA = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMATO_FECHA = "yyyy-MM-dd";

	private UtilFecha() {
		super();
	}

	public static UtilFecha getInstance() {
		return INSTANCIA;
	}

	public LocalDateTime obtenerValorDefecto(final LocalDateTime fecha) {
		return UtilObjeto.getInstance().obtenerValorDefecto(fecha, FECHA_DEFECTO);
	}

	public LocalDate obtenerValorDefecto(final LocalDate fecha) {
		return UtilObjeto.getInstance().obtenerValorDefecto(fecha, FECHA_SOLO_DIA_DEFECTO);
	}

	public LocalDateTime obtenerFechaHoraActual() {
		return LocalDateTime.now();
	}

	public LocalDate obtenerFechaActual() {
		return LocalDate.now();
	}

	public String convertirEnTexto(final LocalDateTime fecha) {
		return UtilObjeto.getInstance().esNulo(fecha)
			? UtilTexto.getInstance().obtenerValorDefecto()
			: fecha.format(DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA));
	}

	public String convertirEnTexto(final LocalDate fecha) {
		return UtilObjeto.getInstance().esNulo(fecha)
			? UtilTexto.getInstance().obtenerValorDefecto()
			: fecha.format(DateTimeFormatter.ofPattern(FORMATO_FECHA));
	}

	public LocalDateTime construirLocalDateTimeDesdeTexto(final String fechaTexto) {
		try {
			return LocalDateTime.parse(UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(fechaTexto),
					DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA));
		} catch (final Exception e) {
			return FECHA_DEFECTO;
		}
	}

	public LocalDate construirLocalDateDesdeTexto(final String fechaTexto) {
		try {
			return LocalDate.parse(UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(fechaTexto),
					DateTimeFormatter.ofPattern(FORMATO_FECHA));
		} catch (final Exception e) {
			return FECHA_SOLO_DIA_DEFECTO;
		}
	}

	public boolean estaExpirada(final LocalDateTime fechaExpiracion) {
		return !UtilObjeto.getInstance().esNulo(fechaExpiracion) && fechaExpiracion.isBefore(obtenerFechaHoraActual());
	}

	public boolean esFutura(final LocalDateTime fecha) {
		return !UtilObjeto.getInstance().esNulo(fecha) && fecha.isAfter(obtenerFechaHoraActual());
	}
}
