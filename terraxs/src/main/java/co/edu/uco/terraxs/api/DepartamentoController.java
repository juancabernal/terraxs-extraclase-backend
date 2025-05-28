package co.edu.uco.terraxs.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.terraxs.businesslogic.facade.DepartamentoFacade;
import co.edu.uco.terraxs.businesslogic.facade.impl.DepartamentoFacadeImpl;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.DepartamentoDTO;

@RestController
@RequestMapping("/api/v1/departamento")
public class DepartamentoController {

	private DepartamentoFacade departamentoFachada;

	public DepartamentoController() throws TerraxsException {
		departamentoFachada = new DepartamentoFacadeImpl();
	}

	@GetMapping("/dummy")
	public DepartamentoDTO getDummy() {
		return new DepartamentoDTO();
	}

	@GetMapping("/{id}")
	public ResponseEntity<DepartamentoDTO> consultar(@PathVariable("id") UUID id) throws TerraxsException {
		var departamento = departamentoFachada.consultarDepartamentoPorId(id);
		return new ResponseEntity<>(departamento, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<DepartamentoDTO>> consultar() throws TerraxsException {
		var lista = departamentoFachada.consultarDepartamentos(getDummy());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/por-pais/{paisId}")
	public ResponseEntity<List<DepartamentoDTO>> consultarPorPais(@PathVariable("paisId") UUID paisId) throws TerraxsException {
		var departamentos = departamentoFachada.consultarDepartamentosPorPais(paisId);
		return new ResponseEntity<>(departamentos, HttpStatus.OK);
	}
}
