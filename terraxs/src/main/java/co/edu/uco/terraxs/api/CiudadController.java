package co.edu.uco.terraxs.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.terraxs.businesslogic.facade.CiudadFacade;
import co.edu.uco.terraxs.businesslogic.facade.impl.CiudadFacadeImpl;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.CiudadDTO;


@RestController
@RequestMapping("/api/v1/ciudad")
public class CiudadController {
	
	private CiudadFacade ciudadFachada;
	
	public CiudadController() throws TerraxsException {
		ciudadFachada = new CiudadFacadeImpl();
	}

	@GetMapping("/por-departamento/{departamentoId}")
	public ResponseEntity<List<CiudadDTO>> consultarPorDepartamento(@PathVariable("departamentoId") UUID departamentoId) throws TerraxsException {
		var ciudades = ciudadFachada.consultarCiudadesPorDepartamento(departamentoId);
		return new ResponseEntity<>(ciudades, HttpStatus.OK);
	}

}
