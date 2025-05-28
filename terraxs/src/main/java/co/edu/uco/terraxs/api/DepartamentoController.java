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

	@GetMapping
	public ResponseEntity<List<DepartamentoDTO>> consultar() throws TerraxsException {
		var lista = departamentoFachada.consultarDepartamentos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
