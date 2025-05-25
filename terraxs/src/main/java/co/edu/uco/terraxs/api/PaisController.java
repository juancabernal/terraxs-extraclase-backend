package co.edu.uco.terraxs.api;

import java.util.List;
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

import co.edu.uco.terraxs.businesslogic.facade.PaisFacade;
import co.edu.uco.terraxs.businesslogic.facade.impl.PaisFacadeImpl;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.PaisDTO;

@RestController
@RequestMapping("/api/v1/paises")

public class PaisController {
	private PaisFacade paisFachada;
	
	public PaisController() throws TerraxsException {
		paisFachada=new PaisFacadeImpl();
	}
	
	
	@GetMapping("/dummy")
	public PaisDTO getDummy() {
		return new PaisDTO();
		
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<PaisDTO>  consultar(@PathVariable("id") UUID id) throws TerraxsException {
		var pais=paisFachada.consultarPaisPorId(id) ;
		return new ResponseEntity<>(pais,HttpStatus.OK) ;

		
		
	}
	@GetMapping
	public ResponseEntity<List<PaisDTO>> consultar() throws TerraxsException {
		var lista=paisFachada.consultarPaises(getDummy());
		
		return new ResponseEntity<>(lista,HttpStatus.OK) ;

		
	}
		
	@PostMapping
	public ResponseEntity<String> crear(@RequestBody PaisDTO pais) throws TerraxsException {
		paisFachada.registrarNuevoPais(pais);
		var mensajeExito= "EL pais"+ pais.getNombre()+ "se ha registrado exitosamente";
		return new ResponseEntity<>(mensajeExito,HttpStatus.OK) ;

		
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> modificar(@PathVariable("id") UUID id, @RequestBody PaisDTO pais) throws TerraxsException {
		paisFachada.modificarPaisExistente(id,pais);
		var mensajeExito= "EL pais"+ pais.getNombre()+ "se ha modificado exitosamente";
		return new ResponseEntity<>(mensajeExito,HttpStatus.OK) ;

		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") UUID id) throws TerraxsException {
		var pais= paisFachada.consultarPaisPorId(id);
		paisFachada.darBajaDefinitivamentePaisExistente(id);
		var mensajeExito= "EL pais"+ pais.getNombre()+ "se ha registrado exitosamente";
		return new ResponseEntity<>(mensajeExito,HttpStatus.OK) ;
		
		
	}
		
}
	

	
	
	
	


