package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.entity.PaisEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.BusinessLogicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.entity.PaisEntity;

public class PaisBusinessLogicImpl implements PaisBusinessLogic {
	
	private DAOFactory factory;
	
	public PaisBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void registrarNuevoPais(PaisDomain pais) throws TerraxsException {
		
		//1. se debe asegurar que los datos sean validos a nivel de tipo de dato,
		//longitud,obligatoriedad,formato,rango
		
		validarIntegridadInformacionRegistrarNuevoPais(pais);
		//2. validar que el nombre del pais no existe

		validarNoExistaPaisConMismoNombre(pais.getNombre());
		//3. generar identificador nuevo pais
		var id= generarIdentificadorNuevoPais();
		
		//4. recrear e domain con el id generado
		var paisDomainAcrear= new PaisDomain(id,pais.getNombre());
		
		//5. creamos el pais siempre y cuando se hayan creado todas las reglas
		var paisEntity =  PaisEntityAssembler.getInstance().toEntity(paisDomainAcrear);
		factory.getPaisDAO().create(paisEntity);
		
		
	}

	private void validarIntegridadInformacionRegistrarNuevoPais(PaisDomain pais) throws TerraxsException {
		validarIntegridadNombrePais(pais.getNombre());
		
		
	}
	
	private void validarIntegridadNombrePais(String nombrePais) throws TerraxsException {
		
		// nombre pais Obligatorio
		if(UtilTexto.getInstance().estaVacia(nombrePais)) {
			throw BusinessLogicTerraxsException.reportar("el nombre del pais es un dato obligatorio");
		}
		
		// nombre pais con longitud valida
		if(UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombrePais).length()>50) {
			throw BusinessLogicTerraxsException.reportar("el nombre del pais supera los 50 caracteres");

			
		}
		//validar que nombre de pais tenga solo letras
		if(!UtilTexto.getInstance().contieneSoloLetrasEspacios(nombrePais)){
			throw BusinessLogicTerraxsException.reportar("el nombre del pais solo puede contener letras o espacios");

			
		}
		
		
	}
	private void validarNoExistaPaisConMismoNombre(String nombrePais) throws TerraxsException {
		var filtro= new PaisEntity();
		filtro.setNombre(nombrePais);
		
		var ListaResultados= factory.getPaisDAO().listByFilter(filtro);
		//si la lista devolvio resultados, entonces si existe un pais con el mismo nombre
		if(!ListaResultados.isEmpty()) {
			throw BusinessLogicTerraxsException.reportar("Ya existe un pais con el mismo nombre");

			
		}
	}
	
	private UUID generarIdentificadorNuevoPais() throws TerraxsException {
		UUID nuevoId;
		var existeId=false;
		do {
			nuevoId=UtilUUID.generarNuevoUUID();
			var pais = factory.getPaisDAO().listById(nuevoId);
			existeId=!UtilUUID.esValorDefecto(pais.getId());	
		}while(existeId);
		
		return nuevoId;
	}
	
	
	@Override
	public void modificarPaisExistente(UUID id, PaisDomain pais) throws TerraxsException  {
		var paisEntity = PaisEntityAssembler.getInstance().toEntity(pais); //Magia de traducir de domain -> entity
		factory.getPaisDAO().update(id, paisEntity);
		
	}

	@Override
	public void darBajaDefinitivamentePaisExistente(UUID id) throws TerraxsException {
		factory.getPaisDAO().delete(id);
		
		
	}

	@Override
	public PaisDomain consultarPaisPorId(UUID id) throws TerraxsException {
		var paisEntity = factory.getPaisDAO().listById(id);
		return  PaisEntityAssembler.getInstance().toDomain(paisEntity);
		
	}
	@Override
	public List<PaisDomain> consultarPaises(PaisDomain filtro) throws TerraxsException {
		var paisFilter = PaisEntityAssembler.getInstance().toEntity(filtro);
		var paisEntities = factory.getPaisDAO().listByFilter(paisFilter);
		
		return PaisEntityAssembler.getInstance().toDomain(paisEntities);
	}
	



}