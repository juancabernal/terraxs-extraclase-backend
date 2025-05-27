package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProveedorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.pais.entity.PaisEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.proveedor.entity.ProveedorEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProveedorDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;
import co.edu.uco.terraxs.crosscutting.excepciones.BusinessLogicTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilPassword;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.entity.PaisEntity;
import co.edu.uco.terraxs.entity.ProveedorEntity;

public class ProveedorBusinessLogicImpl implements ProveedorBusinessLogic{
	
	private DAOFactory factory;
	
	public ProveedorBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void registrarProveedor(ProveedorDomain proveedor)  throws TerraxsException{
		
		//1. se debe asegurar que los datos sean validos a nivel de tipo de dato, longitud,obligatoriedad,formato,rango
		validarIntegridadInformacionRegistrarNuevoProveedor(proveedor);
		
		//2. validar que el id del proveedor no existe
		validarNoExistaProveedorConMismoId(proveedor.getId());
		
		//3. validar que el numero de identificación del proveedor no existe
		validarNoExistaProveedorConMismoNumeroIdentificacion(proveedor.getNumeroIdentificacion());
		
		//4. validar que el correo electrónico del proveedor no existe
		validarNoExistaProveedorConMismoCorreo(proveedor.getCorreo());
		
		//5. validar que el teléfono del proveedor no existe
		validarNoExistaProveedorConMismoTelefono(proveedor.getTelefono());
		
		//5. validar que el teléfono del proveedor no existe
		//confirmarDatosProveedor(proveedor.g);
		
		//6. generar identificador nuevo proveedor
		var id= generarIdentificadorNuevoProveedor();
		
		//7. recrear el domain con el id generado
		var proveedorDomainAcrear= new ProveedorDomain(id,proveedor.getTipoDocumento(),proveedor.getNumeroIdentificacion(),proveedor.getNombres(),
				proveedor.getApellidos(), proveedor.getCorreo(), proveedor.getTelefono(), proveedor.isCorreoConfirmado(), proveedor.isTelefonoConfirmado(),
				proveedor.getDireccionResidencia(), proveedor.getCiudad(), proveedor.getPassword());
		
		//8. creamos el proveedor siempre y cuando se hayan creado todas las reglas
		var proveedorEntity =  ProveedorEntityAssembler.getInstance().toEntity(proveedorDomainAcrear);
		factory.getProveedorDAO().create(proveedorEntity);
		
	}
	
	
	
	private void validarIntegridadInformacionRegistrarNuevoProveedor(ProveedorDomain proveedor) throws TerraxsException {
		validarIntegridadTipoDocumentoProveedor(proveedor.getTipoDocumento());
		validarIntegridadNombresProveedor(proveedor.getNombres());
		validarIntegridadApellidosProveedor(proveedor.getApellidos());
		validarIntegridadCorreoProveedor(proveedor.getCorreo());
		validarIntegridadTelefonoProveedor(proveedor.getTelefono());
		validarIntegridadCorreoConfirmadoProveedor(proveedor.isCorreoConfirmado());
		validarIntegridadTelefonoConfirmadoProveedor(proveedor.isTelefonoConfirmado());
		validarIntegridadDireccionResidenciaProveedor(proveedor.getDireccionResidencia());
		validarIntegridadCiudadProveedor(proveedor.getCiudad());
		validarIntegridadPasswordProveedor(proveedor.getPassword());
		
	}
	
	
	
	private void validarIntegridadNombresProveedor(String nombreProveedor) throws TerraxsException {
		// nombre proveedor Obligatorio
		if(UtilTexto.getInstance().estaVacia(nombreProveedor)) {
			throw BusinessLogicTerraxsException.reportar("el nombre del proveedor es un dato obligatorio");
		}
		// nombre proveedor con longitud valida
		if(UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombreProveedor).length()>40) {
			throw BusinessLogicTerraxsException.reportar("el nombre del proveedor supera los 40 caracteres");
		}
		//validar que nombre de proveedor tenga solo letras
		if(!UtilTexto.getInstance().contieneSoloLetrasEspacios(nombreProveedor)){
			throw BusinessLogicTerraxsException.reportar("el nombre del proveedor sólo puede contener letras o espacios");	
		}
	}
	
	private void validarIntegridadApellidosProveedor(String apellidosProveedor) throws TerraxsException {
		if (UtilTexto.getInstance().estaVacia(apellidosProveedor)) {
			throw BusinessLogicTerraxsException.reportar("El apellido del proveedor es un dato obligatorio.");
		}
		if (UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(apellidosProveedor).length() > 40) {
			throw BusinessLogicTerraxsException.reportar("El apellido del proveedor supera los 40 caracteres.");
		}
		if (!UtilTexto.getInstance().contieneSoloLetrasEspacios(apellidosProveedor)) {
			throw BusinessLogicTerraxsException.reportar("El apellido del proveedor solo puede contener letras o espacios.");
		}
	}

	private void validarIntegridadCorreoProveedor(String correoProveedor) throws TerraxsException {
		if (UtilTexto.getInstance().estaVacia(correoProveedor)) {
			throw BusinessLogicTerraxsException.reportar("El correo electrónico del proveedor es obligatorio.");
		}
		if (!UtilTexto.getInstance().cumplePatronCorreo(correoProveedor)) {
			throw BusinessLogicTerraxsException.reportar("El formato del correo electrónico no es válido.");
		}
		if (correoProveedor.length() > 100) {
			throw BusinessLogicTerraxsException.reportar("El correo electrónico no debe superar los 100 caracteres.");
		}
	}

	private void validarIntegridadTelefonoProveedor(String telefonoProveedor) throws TerraxsException {
		if (UtilTexto.getInstance().estaVacia(telefonoProveedor)) {
			throw BusinessLogicTerraxsException.reportar("El número de teléfono del proveedor es obligatorio.");
		}
		if (!UtilTexto.getInstance().contieneSoloNumeros(telefonoProveedor)) {
			throw BusinessLogicTerraxsException.reportar("El número de teléfono solo puede contener dígitos.");
		}
		if (telefonoProveedor.length() != 10) {
			throw BusinessLogicTerraxsException.reportar("El número de teléfono debe tener exactamente 10 dígitos.");
		}
	}

	private void validarIntegridadCorreoConfirmadoProveedor(boolean correoConfirmado) throws TerraxsException {
		if (!correoConfirmado) {
			throw BusinessLogicTerraxsException.reportar("El correo electrónico del proveedor debe estar confirmado.");
		}
	}

	private void validarIntegridadTelefonoConfirmadoProveedor(boolean telefonoConfirmado) throws TerraxsException {
		if (!telefonoConfirmado) {
			throw BusinessLogicTerraxsException.reportar("El teléfono del proveedor debe estar confirmado.");
		}
	}

	private void validarIntegridadDireccionResidenciaProveedor(String direccionResidencia) throws TerraxsException {
		if (UtilTexto.getInstance().estaVacia(direccionResidencia)) {
			throw BusinessLogicTerraxsException.reportar("La dirección de residencia del proveedor es obligatoria.");
		}
		if (direccionResidencia.length() > 100) {
			throw BusinessLogicTerraxsException.reportar("La dirección de residencia no puede superar los 100 caracteres.");
		}
	}

	private void validarIntegridadCiudadProveedor(CiudadDomain ciudad) throws TerraxsException {
		if (UtilObjeto.getInstance().esNulo(ciudad) || UtilUUID.esValorDefecto(ciudad.getId())) {
			throw BusinessLogicTerraxsException.reportar("La ciudad del proveedor es obligatoria y debe ser válida.");
		}
	}

	private void validarIntegridadTipoDocumentoProveedor(TipoDocumentoDomain tipoDocumento) throws TerraxsException {
		if (UtilObjeto.getInstance().esNulo(tipoDocumento) || UtilUUID.esValorDefecto(tipoDocumento.getId())) {
			throw BusinessLogicTerraxsException.reportar("El tipo de documento del proveedor es obligatorio y debe ser válido.");
		}
	}

	private void validarIntegridadPasswordProveedor(String password) throws TerraxsException {
		if (UtilTexto.getInstance().estaVacia(password)) {
			throw BusinessLogicTerraxsException.reportar("La contraseña del proveedor es obligatoria.");
		}
		if (password.length() < 8 || password.length() > 50) {
			throw BusinessLogicTerraxsException.reportar("La contraseña debe tener entre 8 y 50 caracteres.");
		}
		if (!UtilPassword.getInstance().cumplePatronPasswordSeguro(password)) {
			throw BusinessLogicTerraxsException.reportar("La contraseña debe contener mayúsculas, minúsculas, números y caracteres especiales.");
		}
	}

	

	
	private void validarNoExistaProveedorConMismoId(UUID idProveedor) throws TerraxsException {
		var filtro= new ProveedorEntity();
		filtro.setId(idProveedor);
		
		var ListaResultados= factory.getProveedorDAO().listByFilter(filtro);
		//si la lista devolvio resultados, entonces si existe un proveedor con el mismo id
		if(!ListaResultados.isEmpty()) {
			throw BusinessLogicTerraxsException.reportar("Ya existe un proveedor con el mismo id");
		}
	}
	
	private void validarNoExistaProveedorConMismoNumeroIdentificacion(String numeroIdentificacionProveedor) throws TerraxsException {
		var filtro= new ProveedorEntity();
		filtro.setNumeroIdentificacion(numeroIdentificacionProveedor);
		
		var ListaResultados= factory.getProveedorDAO().listByFilter(filtro);
		//si la lista devolvio resultados, entonces si existe un proveedor con el mismo número de identificación
		if(!ListaResultados.isEmpty()) {
			throw BusinessLogicTerraxsException.reportar("Ya existe un proveedor con el mismo número de identificación");
		}
	}
	
	private void validarNoExistaProveedorConMismoCorreo(String correoProveedor) throws TerraxsException {
		var filtro = new ProveedorEntity();
		filtro.setCorreo(correoProveedor);

		var listaResultados = factory.getProveedorDAO().listByFilter(filtro);
		if (!listaResultados.isEmpty()) {
			throw BusinessLogicTerraxsException.reportar("Ya existe un proveedor con el mismo correo electrónico.");
		}
	}

	private void validarNoExistaProveedorConMismoTelefono(String telefonoProveedor) throws TerraxsException {
		var filtro = new ProveedorEntity();
		filtro.setTelefono(telefonoProveedor);

		var listaResultados = factory.getProveedorDAO().listByFilter(filtro);
		if (!listaResultados.isEmpty()) {
			throw BusinessLogicTerraxsException.reportar("Ya existe un proveedor con el mismo número de teléfono.");
		}
	}

	
	
	private UUID generarIdentificadorNuevoProveedor() throws TerraxsException {
		UUID nuevoId;
		var existeId=false;
		do {
			nuevoId=UtilUUID.generarNuevoUUID();
			var proveedor = factory.getProveedorDAO().listById(nuevoId);
			existeId=!UtilUUID.esValorDefecto(proveedor.getId());	
		}while(existeId);
		
		return nuevoId;
	}
	
	

	@Override
	public boolean confirmarDatosProveedor(ProveedorDomain proveedor, TokenConfirmacionDomain token)  throws TerraxsException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento)  throws TerraxsException{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void elegirCiudad(List<CiudadDomain> ciudad) throws TerraxsException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ProveedorDomain consultarProveedorPorId(UUID id)  throws TerraxsException{
		var proveedorEntity = factory.getProveedorDAO().listById(id);
		return  ProveedorEntityAssembler.getInstance().toDomain(proveedorEntity);
	}

	@Override
	public List<ProveedorDomain> consultarProveedores(ProveedorDomain filtro)  throws TerraxsException{
		var proveedorFilter = ProveedorEntityAssembler.getInstance().toEntity(filtro);
		var proveedorEntities = factory.getProveedorDAO().listByFilter(proveedorFilter);
		
		return ProveedorEntityAssembler.getInstance().toDomain(proveedorEntities);
	}

	@Override
	public void modificarDatosProveedor(UUID id, ProveedorDomain proveedor) throws TerraxsException {
		var proveedorEntity = ProveedorEntityAssembler.getInstance().toEntity(proveedor); //Magia de traducir de domain -> entity
		factory.getProveedorDAO().update(id, proveedorEntity);
	}

	@Override
	public void eliminarProveedor(UUID id) throws TerraxsException {
		factory.getProveedorDAO().delete(id);
	}

}
