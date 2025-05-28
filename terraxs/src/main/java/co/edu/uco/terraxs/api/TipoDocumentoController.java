package co.edu.uco.terraxs.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.terraxs.businesslogic.facade.TipoDocumentoFacade;
import co.edu.uco.terraxs.businesslogic.facade.impl.TipoDocumentoFacadeImpl;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;



@RestController
@RequestMapping("/api/v1/tipoDocumento")
public class TipoDocumentoController {
	
	private TipoDocumentoFacade tipoDocumentoFachada;
	
	public TipoDocumentoController() throws TerraxsException {
		tipoDocumentoFachada = new TipoDocumentoFacadeImpl();
	}
	
	
	@GetMapping("/dummy")
	public TipoDocumentoDTO getDummy() {
		return new TipoDocumentoDTO();
		
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<TipoDocumentoDTO>  consultar(@PathVariable("id") UUID id) throws TerraxsException {
		var tipoDocumento=tipoDocumentoFachada.consultarTipoDocumentoPorId(id) ;
		return new ResponseEntity<>(tipoDocumento,HttpStatus.OK) ;

		
		
	}
	@GetMapping
	public ResponseEntity<List<TipoDocumentoDTO>> consultar() throws TerraxsException {
		var lista=tipoDocumentoFachada.consultarTiposDocumento(getDummy());
		
		return new ResponseEntity<>(lista,HttpStatus.OK) ;
	}


}
