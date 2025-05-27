package co.edu.uco.terraxs.data.dao.factory.postgresql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropiedadesBaseDatos {

    private static final String NOMBRE_ARCHIVO = "application.properties";
    private static final Properties propiedades = new Properties();

    static {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(NOMBRE_ARCHIVO)) {
            if (input == null) {
                throw new RuntimeException("Archivo " + NOMBRE_ARCHIVO + " no encontrado en el classpath.");
            }
            propiedades.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar propiedades de base de datos desde " + NOMBRE_ARCHIVO, e);
        }
    }

    private PropiedadesBaseDatos() {
    }

    public static String obtenerPropiedad(String clave) {
        String valor = propiedades.getProperty(clave);
        if (valor == null || valor.isBlank()) {
            throw new RuntimeException("Propiedad '" + clave + "' no encontrada o vacía en " + NOMBRE_ARCHIVO);
        }
        return valor;
    }
}


/*package co.edu.uco.terraxs.data.dao.factory.postgresql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropiedadesBaseDatos {
	
	private static final Properties propiedades = new Properties();

	static {
		  try (InputStream input = PropiedadesBaseDatos.class.getClassLoader()
		         .getResourceAsStream("application.properties")) {

		    if (input == null) {
		      throw new RuntimeException("No se encontró 'application.properties' en el classpath");
		    }
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

}*/
