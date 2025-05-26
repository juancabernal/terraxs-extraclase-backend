package co.edu.uco.terraxs.crosscutting.utilitarios;

import org.mindrot.jbcrypt.BCrypt;

public class UtilPassword {
	
	private static UtilPassword instancia = new UtilPassword();
	private static final String PATRON_PASSWORD_SEGURA= "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&\\-_#^+=])[A-Za-z\\d@$!%*?&\\-_#^+=]{8,}$";
	
	private UtilPassword() {

	}

	public static UtilPassword getInstance() {
		return instancia;
	}
	
	public String encriptarPassword(String passwordInicial) {
	    return BCrypt.hashpw(passwordInicial, BCrypt.gensalt());
	}

	public boolean verificarPassword(String passwordInicial, String passwordHash) {
	    return BCrypt.checkpw(passwordInicial, passwordHash);
	}
	
	public boolean cumplePatronPasswordSeguro(String password) {
		return password != null && password.matches(PATRON_PASSWORD_SEGURA);
	}

}
