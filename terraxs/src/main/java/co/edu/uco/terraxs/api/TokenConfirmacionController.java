package co.edu.uco.terraxs.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.terraxs.businesslogic.facade.TokenConfirmacionFacade;
import co.edu.uco.terraxs.businesslogic.facade.impl.TokenConfirmacionFacadeImpl;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.ProveedorDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

@RestController
@RequestMapping("/api/v1/tokenConfirmaciones")

public class TokenConfirmacionController {
	private TokenConfirmacionFacade tokenConfirmacionFachada;
	
	public TokenConfirmacionController() throws TerraxsException {
		tokenConfirmacionFachada=new TokenConfirmacionFacadeImpl();
	}
	
	
	@GetMapping("/dummy")
	public TokenConfirmacionDTO getDummy() {
		return new TokenConfirmacionDTO();
		
	}
	
	

		
	@PostMapping
	public ResponseEntity<String> crear(@RequestBody TokenConfirmacionDTO tokenConfirmacion) throws TerraxsException {
		tokenConfirmacionFachada.crearToken(tokenConfirmacion);
		var mensajeExito= "EL token de Confirmacion" + tokenConfirmacion.getToken()+ "se ha creado exitosamente";
		return new ResponseEntity<>(mensajeExito,HttpStatus.OK) ;

		
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<TokenConfirmacionDTO>  consultar(@PathVariable("id") UUID id) throws TerraxsException {
		var tokenConfirmacion=tokenConfirmacionFachada.consultarToken(id) ;
		return new ResponseEntity<>(tokenConfirmacion,HttpStatus.OK) ;

		
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") UUID id) throws TerraxsException {
		tokenConfirmacionFachada.eliminarToken(id);
		var mensajeExito= "EL token de confirmacion se ha eliminado exitosamente";
		return new ResponseEntity<>(mensajeExito,HttpStatus.OK) ;
		
		
	}
		
}
	

	
	
	
	


