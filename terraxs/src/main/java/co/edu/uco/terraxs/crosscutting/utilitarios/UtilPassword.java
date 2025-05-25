package co.edu.uco.terraxs.crosscutting.utilitarios;

import org.mindrot.jbcrypt.BCrypt;

public class UtilPassword {
	
	private static UtilPassword instancia = new UtilPassword();
	
	private UtilPassword() {

	}

	public static UtilPassword getInstance() {
		return instancia;
	}
	
	public static String encriptarPassword(String passwordInicial) {
	    return BCrypt.hashpw(passwordInicial, BCrypt.gensalt());
	}

	public static boolean verificarPassword(String passwordInicial, String passwordHash) {
	    return BCrypt.checkpw(passwordInicial, passwordHash);
	}
}
