package co.edu.uco.terraxs.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;

@ControllerAdvice
public class ControladorGlobalExcepciones {
	
	@ExceptionHandler(TerraxsException.class)
	public ResponseEntity<String> controlarOnlineTestException(TerraxsException excepcion){
		excepcion.printStackTrace();
		return new ResponseEntity<>(excepcion.getMensajeUsuario(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> controlarException(TerraxsException excepcion){
		excepcion.printStackTrace();
		return new ResponseEntity<>("se ha presentado un problema inesperado ttratando de llevar a cabo la operacion deseada",HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
