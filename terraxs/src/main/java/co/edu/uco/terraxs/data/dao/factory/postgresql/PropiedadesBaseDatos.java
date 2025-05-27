package co.edu.uco.terraxs.data.dao.factory.postgresql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropiedadesBaseDatos {
	
	private static final Properties propiedades = new Properties();

	static {
		try (InputStream input = PropiedadesBaseDatos.class.getClassLoader()
				.getResourceAsStream("application.properties")) {
			propiedades.load(input);
		} catch (IOException e) {
			throw new RuntimeException("Error cargando archivo de configuración de base de datos", e);
		}
	}

	private PropiedadesBaseDatos() {
	}

	public static String obtenerPropiedad(String clave) {
		return propiedades.getProperty(clave);
	}

}
