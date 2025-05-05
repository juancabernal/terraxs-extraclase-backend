package co.edu.uco.terraxs.crosscutting.utilitarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class UtilFecha {

	private static final LocalDateTime FECHA_DEFECTO = LocalDateTime.MIN;
	private static final String FORMATO_FECHA_HORA = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMATO_FECHA = "yyyy-MM-dd";

	private UtilFecha() {
		super();
	}

	public static LocalDateTime obtenerValorDefecto(final LocalDateTime fecha) {
		return fecha != null ? fecha : FECHA_DEFECTO;
	}

	public static LocalDate obtenerValorDefecto(final LocalDate fecha) {
		return fecha != null ? fecha : LocalDate.MIN;
	}

	public static LocalDateTime obtenerFechaHoraActual() {
		return LocalDateTime.now();
	}

	public static LocalDate obtenerFechaActual() {
		return LocalDate.now();
	}

	public static String convertirEnTexto(final LocalDateTime fecha) {
		return fecha != null ? fecha.format(DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA)) : "";
	}

	public static String convertirEnTexto(final LocalDate fecha) {
		return fecha != null ? fecha.format(DateTimeFormatter.ofPattern(FORMATO_FECHA)) : "";
	}

	public static LocalDateTime construirLocalDateTimeDesdeTexto(final String fechaTexto) {
		try {
			return LocalDateTime.parse(fechaTexto, DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA));
		} catch (final Exception e) {
			return FECHA_DEFECTO;
		}
	}

	public static LocalDate construirLocalDateDesdeTexto(final String fechaTexto) {
		try {
			return LocalDate.parse(fechaTexto, DateTimeFormatter.ofPattern(FORMATO_FECHA));
		} catch (final Exception e) {
			return LocalDate.MIN;
		}
	}

	public static boolean estaExpirada(final LocalDateTime fechaExpiracion) {
		return fechaExpiracion != null && fechaExpiracion.isBefore(LocalDateTime.now());
	}

	public static boolean esFutura(final LocalDateTime fecha) {
		return fecha != null && fecha.isAfter(LocalDateTime.now());
	}
}
