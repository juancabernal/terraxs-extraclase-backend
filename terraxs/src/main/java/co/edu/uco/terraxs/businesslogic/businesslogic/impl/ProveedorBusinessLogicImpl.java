package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ProveedorBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.departamento.entity.DepartamentoEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.assembler.proveedor.entity.ProveedorEntityAssembler;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
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
import co.edu.uco.terraxs.entity.ProveedorEntity;

public class ProveedorBusinessLogicImpl implements ProveedorBusinessLogic{
	
	private DAOFactory factory;
	
	public ProveedorBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	

	@Override
	public void registrarProveedor(ProveedorDomain proveedor)  throws TerraxsException{
		
	    // 1. Generar identificador nuevo proveedor ANTES de cualquier validación
	    var idGenerado = generarIdentificadorNuevoProveedor();
	    
	    // 2. Validar que el id generado no exista (esto es una doble verificación, pero por seguridad)
	    validarNoExistaProveedorConMismoId(idGenerado);
	    
	    // 3. Actualizar el ID del proveedor (dependiendo de si ProveedorDomain tiene setter o no)
	    // Si ProveedorDomain es inmutable, crear nuevo objeto con id generado:
	    proveedor = new ProveedorDomain(
	        idGenerado,
	        proveedor.getTipoDocumento(),
	        proveedor.getNumeroIdentificacion(),
	        proveedor.getNombres(),
	        proveedor.getApellidos(),
	        proveedor.getCorreo(),
	        proveedor.getTelefono(),
	        proveedor.isCorreoConfirmado(),
	        proveedor.isTelefonoConfirmado(),
	        proveedor.getDireccionResidencia(),
	        proveedor.getCiudad(),
	        proveedor.getPassword()
	    );
	    
	    // 4. Validar integridad de la información (ahora con ID actualizado)
	    validarIntegridadInformacionRegistrarNuevoProveedor(proveedor);
	    
	    // 5. Validar que no exista otro proveedor con el mismo número de identificación
	    validarNoExistaProveedorConMismoNumeroIdentificacion(proveedor.getNumeroIdentificacion());
	    
	    // 6. Validar que no exista otro proveedor con el mismo correo electrónico
	    validarNoExistaProveedorConMismoCorreo(proveedor.getCorreo());
	    
	    // 7. Validar que no exista otro proveedor con el mismo teléfono
	    validarNoExistaProveedorConMismoTelefono(proveedor.getTelefono());
	    
		//validarCoinicidenciaContraseña(proveedor.getPassword(),proveedor.getConfirmPassword())

	    
	    // 8. Hashear la contraseña
	    var passwordHasheada = UtilPassword.getInstance().encriptarPassword(proveedor.getPassword());
	    
	    // 9. Crear nuevo domain con el id generado y la contraseña hasheada (ya que la password cambia)
	    var proveedorDomainAcrear = new ProveedorDomain(
	        idGenerado,
	        proveedor.getTipoDocumento(),
	        proveedor.getNumeroIdentificacion(),
	        proveedor.getNombres(),
	        proveedor.getApellidos(),
	        proveedor.getCorreo(),
	        proveedor.getTelefono(),
	        proveedor.isCorreoConfirmado(),
	        proveedor.isTelefonoConfirmado(),
	        proveedor.getDireccionResidencia(),
	        proveedor.getCiudad(),
	        passwordHasheada
	    );
	    
	    // 10. Crear entidad y persistir
	    var proveedorEntity = ProveedorEntityAssembler.getInstance().toEntity(proveedorDomainAcrear);
	    factory.getProveedorDAO().create(proveedorEntity);
	}
		
	
	
	
	
	private void validarIntegridadInformacionRegistrarNuevoProveedor(ProveedorDomain proveedor) throws TerraxsException {
		validarIntegridadTipoDocumentoProveedor(proveedor.getTipoDocumento());
		validarIntegridadNumeroIdentificacionProveedor(proveedor.getNumeroIdentificacion());
		validarIntegridadNombresProveedor(proveedor.getNombres());
		validarIntegridadApellidosProveedor(proveedor.getApellidos());
		validarIntegridadCorreoProveedor(proveedor.getCorreo());
		validarIntegridadTelefonoProveedor(proveedor.getTelefono());
		/*validarIntegridadCorreoConfirmadoProveedor(proveedor.isCorreoConfirmado());
		validarIntegridadTelefonoConfirmadoProveedor(proveedor.isTelefonoConfirmado());*/
		validarIntegridadDireccionResidenciaProveedor(proveedor.getDireccionResidencia());
		validarIntegridadCiudadProveedor(proveedor.getCiudad());
		validarIntegridadPasswordProveedor(proveedor.getPassword());

	}
	
	
	
	private void validarIntegridadNumeroIdentificacionProveedor(String numeroIdentificacionProveedor) throws TerraxsException {
		if(UtilTexto.getInstance().estaVacia(numeroIdentificacionProveedor)) {
			throw BusinessLogicTerraxsException.reportar("El numero de identificación es un dato obligatorio");
		}
		if(UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(numeroIdentificacionProveedor).length()>20) {
			throw BusinessLogicTerraxsException.reportar("El número de identificación no puede superar los 20 caracteres");
		}
		if(UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(numeroIdentificacionProveedor).length()<5) {
			throw BusinessLogicTerraxsException.reportar("El número de identificación no puede ser inferior a 5 caracteres");
		}
		if(!UtilTexto.getInstance().contieneSoloNumeros(numeroIdentificacionProveedor)){
			throw BusinessLogicTerraxsException.reportar("El número de identificación del proveedor sólo puede contener caracteres numéricos");	
		}
	}
	
	
	private void validarIntegridadNombresProveedor(String nombreProveedor) throws TerraxsException {
		if(UtilTexto.getInstance().estaVacia(nombreProveedor)) {
			throw BusinessLogicTerraxsException.reportar("El nombre del proveedor es un dato obligatorio");
		}
		if(UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombreProveedor).length()>40) {
			throw BusinessLogicTerraxsException.reportar("El nombre del proveedor no puede superar los 40 caracteres");
		}
		if(UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombreProveedor).length()<3) {
			throw BusinessLogicTerraxsException.reportar("El nombre del proveedor no puede ser inferior a 3 caracteres");
		}
		if(!UtilTexto.getInstance().contieneSoloLetrasEspacios(nombreProveedor)){
			throw BusinessLogicTerraxsException.reportar("El nombre del proveedor sólo puede contener letras o espacios");	
		}
	}
	
	private void validarIntegridadApellidosProveedor(String apellidosProveedor) throws TerraxsException {
		if (UtilTexto.getInstance().estaVacia(apellidosProveedor)) {
			throw BusinessLogicTerraxsException.reportar("El apellido del proveedor es un dato obligatorio.");
		}
		if (UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(apellidosProveedor).length() > 30) {
			throw BusinessLogicTerraxsException.reportar("El apellido del proveedor no puede superar los 30 caracteres.");
		}
		if (UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(apellidosProveedor).length() < 3) {
			throw BusinessLogicTerraxsException.reportar("El apellido del proveedor no puede ser inferior a 3 caracteres.");
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
		if (correoProveedor.length() < 10) {
			throw BusinessLogicTerraxsException.reportar("El correo electrónico no debe ser inferios a los 10 caracteres.");
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

	/*private void validarIntegridadCorreoConfirmadoProveedor(boolean correoConfirmado) throws TerraxsException {
		if (!correoConfirmado) {
			throw BusinessLogicTerraxsException.reportar("El correo electrónico del proveedor debe estar confirmado.");
		}
	}

	private void validarIntegridadTelefonoConfirmadoProveedor(boolean telefonoConfirmado) throws TerraxsException {
		if (!telefonoConfirmado) {
			throw BusinessLogicTerraxsException.reportar("El teléfono del proveedor debe estar confirmado.");
		}
	}*/
	
	private void validarIntegridadDireccionResidenciaProveedor(String direccionResidencia) throws TerraxsException {
		if (UtilTexto.getInstance().estaVacia(direccionResidencia)) {
			throw BusinessLogicTerraxsException.reportar("La dirección de residencia del proveedor es obligatoria.");
		}
		if (direccionResidencia.length() > 100) {
			throw BusinessLogicTerraxsException.reportar("La dirección de residencia no puede superar los 100 caracteres.");
		}
		if (direccionResidencia.length() < 10) {
			throw BusinessLogicTerraxsException.reportar("La dirección de residencia no puede ser inferior a 10 caracteres.");
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
	
	/*private void validarCoincidenciaContrasena(String password, String confirmPassword) {
	    if (!password.equals(confirmPassword)) {
	        throw new TerraxsException("La contraseña y su confirmación no coinciden.");
	    }
	}*/


	private void validarIntegridadPasswordProveedor(String password) throws TerraxsException {
		if (UtilTexto.getInstance().estaVacia(password)) {
			throw BusinessLogicTerraxsException.reportar("La contraseña del proveedor es obligatoria.");
		}
		if (password.length() < 8 || password.length() > 30) {
			throw BusinessLogicTerraxsException.reportar("La contraseña debe tener entre 8 y 30 caracteres.");
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
	public TipoDocumentoDomain elegirTipoDocumento(UUID idTipoDocumento) throws TerraxsException {
		if (UtilUUID.esValorDefecto(idTipoDocumento)) {
			throw BusinessLogicTerraxsException.reportar("El identificador del tipo de documento es obligatorio y no puede ser por defecto.");
		}

		var entidad = factory.getTipoDocumentoDAO().listById(idTipoDocumento);

		if (UtilObjeto.getInstance().esNulo(entidad) || UtilUUID.esValorDefecto(entidad.getId())) {
			throw BusinessLogicTerraxsException.reportar("No existe un tipo de documento con el ID especificado.");
		}

		return new TipoDocumentoDomain(entidad.getId(), entidad.getNombre());
	}

	
	@Override
	public CiudadDomain elegirCiudad(UUID idCiudad) throws TerraxsException {
		if (UtilUUID.esValorDefecto(idCiudad)) {
			throw BusinessLogicTerraxsException.reportar("El identificador de la ciudad es obligatorio y no puede ser por defecto.");
		}

		var entidad = factory.getCiudadDAO().listById(idCiudad);

		if (UtilObjeto.getInstance().esNulo(entidad) || UtilUUID.esValorDefecto(entidad.getId())) {
			throw BusinessLogicTerraxsException.reportar("No existe una ciudad con el ID especificado.");
		}

		return new CiudadDomain(entidad.getId(), entidad.getNombre(), DepartamentoEntityAssembler.getInstance().toDomain(entidad.getDepartamento()));
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
