package co.edu.uco.terraxs.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.uco.terraxs.businesslogic.facade.ProveedorFacade;
import co.edu.uco.terraxs.businesslogic.facade.impl.ProveedorFacadeImpl;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.ProveedorDTO;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {

	private final ProveedorFacade proveedorFachada;

	public ProveedorController() throws TerraxsException {
		this.proveedorFachada = new ProveedorFacadeImpl();
	}

	// Dummy para pruebas
	@GetMapping("/dummy")
	public ProveedorDTO getDummy() {
		return new ProveedorDTO();
	}

	// Obtener proveedor por ID
	@GetMapping("/{id}")
	public ResponseEntity<ProveedorDTO> consultar(@PathVariable("id") UUID id) throws TerraxsException {
		var proveedor = proveedorFachada.consultarProveedorPorId(id);
		return new ResponseEntity<>(proveedor, HttpStatus.OK);
	}

	// Consultar todos los proveedores
	@GetMapping
	public ResponseEntity<List<ProveedorDTO>> consultar() throws TerraxsException {
		var lista = proveedorFachada.consultarProveedores(getDummy());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	// Crear un proveedor
	@PostMapping
	public ResponseEntity<String> crear(@RequestBody ProveedorDTO proveedor) throws TerraxsException {
		proveedorFachada.registrarProveedor(proveedor);
		var mensajeExito = "El proveedor " + proveedor.getNombres() + " se ha registrado exitosamente.";
		return new ResponseEntity<>(mensajeExito, HttpStatus.CREATED);
	}

	// Modificar un proveedor
	@PutMapping("/{id}")
	public ResponseEntity<String> modificar(@PathVariable("id") UUID id, @RequestBody ProveedorDTO proveedor)
			throws TerraxsException {
		proveedorFachada.modificarDatosProveedor(id, proveedor);
		var mensajeExito = "El proveedor " + proveedor.getNombres() + " se ha modificado exitosamente.";
		return new ResponseEntity<>(mensajeExito, HttpStatus.OK);
	}

	// Eliminar un proveedor
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") UUID id) throws TerraxsException {
		var proveedor = proveedorFachada.consultarProveedorPorId(id);
		proveedorFachada.eliminarProveedor(id);
		var mensajeExito = "El proveedor " + proveedor.getNombres() + " se ha eliminado exitosamente.";
		return new ResponseEntity<>(mensajeExito, HttpStatus.OK);
	}
}
