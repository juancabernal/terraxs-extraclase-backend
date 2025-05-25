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

import co.edu.uco.terraxs.businesslogic.facade.ProveedorFacade;
import co.edu.uco.terraxs.businesslogic.facade.impl.ProveedorFacadeImpl;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.ProveedorDTO;

@RestController
@RequestMapping("/api/v1/proveedores")

public class ProveedorController {
	private ProveedorFacade proveedorFachada;
	
	public ProveedorController() throws TerraxsException {
		proveedorFachada=new ProveedorFacadeImpl();
	}
	
	
	@GetMapping("/dummy")
	public ProveedorDTO getDummy() {
		return new ProveedorDTO();
		
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<ProveedorDTO>  consultar(@PathVariable("id") UUID id) throws TerraxsException {
		var proveedor=proveedorFachada.consultarProveedorPorId(id) ;
		return new ResponseEntity<>(proveedor,HttpStatus.OK) ;

		
		
	}
	@GetMapping
	public ResponseEntity<List<ProveedorDTO>> consultar() throws TerraxsException {
		var lista=proveedorFachada.consultarProveedores(getDummy());
		
		return new ResponseEntity<>(lista,HttpStatus.OK) ;

		
	}
		
	@PostMapping
	public ResponseEntity<String> crear(@RequestBody ProveedorDTO proveedor) throws TerraxsException {
		proveedorFachada.registrarProveedor(proveedor);
		var mensajeExito= "EL proveedor"+ proveedor.getNombres()+ "se ha registrado exitosamente";
		return new ResponseEntity<>(mensajeExito,HttpStatus.OK) ;

		
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> modificar(@PathVariable("id") UUID id, @RequestBody ProveedorDTO proveedor) throws TerraxsException {
		proveedorFachada.modificarDatosProveedor(id,proveedor);
		var mensajeExito= "EL proveedor"+ proveedor.getNombres()+ "se ha modificado exitosamente";
		return new ResponseEntity<>(mensajeExito,HttpStatus.OK) ;

		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") UUID id) throws TerraxsException {
		var proveedor= proveedorFachada.consultarProveedorPorId(id);
		proveedorFachada.eliminarProveedor(id);
		var mensajeExito= "EL proveedor"+ proveedor.getNombres()+ "se ha eliminado exitosamente";
		return new ResponseEntity<>(mensajeExito,HttpStatus.OK) ;
		
		
	}
		
}
	

	
	
	
	


