package co.edu.uco.terraxs.data.dao.factory.postgresql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.terraxs.data.dao.entity.ciudad.impl.postgresql.CiudadPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.impl.postgresql.DepartamentoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.PaisDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.impl.postgresql.PaisPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.proveedor.ProveedorDAO;
import co.edu.uco.terraxs.data.dao.entity.proveedor.impl.postgresql.ProveedorPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.TokenConfirmacionDAO;
import co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.impl.postgresql.TokenConfirmacionPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;



public class PostgreSQLDAOFactory extends DAOFactory {

	private final DataSource dataSource;
	private Connection conexion;
	private boolean transaccionEstaIniciada;
	private boolean conexionEstaAbierta;
	
	public PostgreSQLDAOFactory() throws TerraxsException {
	    this(DataSourceBuilder.create()
	            .url("jdbc:postgresql://localhost:5432/DOO2025TERRAXS")
	            .username("postgres")
	            .password("1036778928")
	            .driverClassName("org.postgresql.Driver")
	            .build());
	}


	public PostgreSQLDAOFactory(final DataSource dataSource) throws TerraxsException {
		this.dataSource = dataSource;
		abrirConexion();
		this.transaccionEstaIniciada = false;
		this.conexionEstaAbierta = true;
	}

	@Override
    protected void abrirConexion()  throws TerraxsException{
		
		var baseDatos="DOOTERRAXSDB";
		var servidor="ORION.UCO.EDU.CO";
		
    	try {
            this.conexion = dataSource.getConnection();

    	}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de obtener la conexión con la fuente de datos para llevar a cabo la operación deseada.";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de obtener la conexión con la base de datos "+ baseDatos +" en el servidor "+ servidor +" Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de obtener la conexión con la fuente de datos para llevar a cabo la operación deseada.";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de obtener la conexión con la base de datos "+ baseDatos +" en el servidor "+ servidor +" Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
	}
    	

	@Override
	public void iniciarTransaccion()  throws TerraxsException{
		
		
		try {
			asegurarConexionAbierta();
    		conexion.setAutoCommit(false);
    		transaccionEstaIniciada = true;

    	}catch(TerraxsException exception){
    		throw exception;
    	}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de iniciar la transacción con la fuente de datos para llevar a cabo la operación deseada.";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de iniciar la transacción sobre la conexión con la base de datos. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de iniciar la transacción con la fuente de datos para llevar a cabo la operación deseada.";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de iniciar la transacción sobre la conexión con la base de datos. Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
	}
	

	@Override
	public void confirmarTransaccion() throws TerraxsException {
		try {
			asegurarConexionAbierta();
			asegurarTransaccionIniciada();
    		conexion.commit();
    	}catch(TerraxsException exception){
    		throw exception;
    	}catch(SQLException exception) {
    		var mensajeUsuario="Se ha presentado un problema tratando de confirmar la transacción con la fuente de datos para guardar los cambios..";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer COMMIT en la conexión activa con la base de datos. Para más detalles, revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de confirmar la transacción con la fuente de datos para guardar los cambios.";
    		var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception al intentar hacer COMMIT en la conexión activa con la base de datos. Para más detalles, revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
	}
		
	
	@Override
	public void cancelarTransaccion() throws TerraxsException {
		
		try {
			asegurarTransaccionIniciada();
    		conexion.rollback();
    	}catch(TerraxsException exception){
    		throw exception;
    	}catch(SQLException exception) {
    	    var mensajeUsuario="Se ha presentado un problema tratando de cancelar la transacción con la fuente de datos para deshacer los cambios.";
    	    var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de hacer ROLLBACK en la conexión activa con la base de datos. Para más detalles, revise el log de errores.";
    	    throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    	    var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de cancelar la transacción con la fuente de datos para deshacer los cambios.";
    	    var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception al intentar hacer ROLLBACK en la conexión activa con la base de datos. Para más detalles, revise el log de errores.";
    	    throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
	}
		

	@Override
	public void cerrarConexion()  throws TerraxsException {
		
		try {
			asegurarConexionAbierta();
    		conexion.close();
    	}catch(TerraxsException exception){
    		throw exception;
    	}catch(SQLException exception) {
    	    var mensajeUsuario="Se ha presentado un problema tratando de cerrar la conexión con la fuente de datos luego de realizar la operación.";
    	    var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de cerrar la conexión con la base de datos. Para más detalles, revise el log de errores.";
    	    throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    	    var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de cerrar la conexión con la fuente de datos luego de realizar la operación.";
    	    var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de cerrar la conexión con la base de datos. Para más detalles, revise el log de errores.";
    	    throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}
	}
		

	private void asegurarTransaccionIniciada() throws TerraxsException{
		if(!transaccionEstaIniciada) {
			var mensajeUsuario="Se ha presentado un problema tratando de gestionar la transacción con la fuente de datos para llevar a cabo la operación deseada.";
    		var mensajeTecnico="Se intentó gestionar (COMMIT/ROLLBACK) una transacción que previamente no fue iniciada";
    		
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico);
		}
	}
	
	
	private void asegurarConexionAbierta() throws TerraxsException{
		if(!conexionEstaAbierta) {
			var mensajeUsuario="Se ha presentado un problema tratando de llevar a cabo la operación deseada con una conexión cerrada...";
    		var mensajeTecnico="Se intentó gestionar (COMMIT/ROLLBACK) una transacción que previamente no fue iniciada";
    		
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico);
		}
	}

	

	@Override
	public PaisDAO getPaisDAO() throws TerraxsException{
		 asegurarConexionAbierta();
		return new PaisPostgreSQLDAO(conexion);
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() throws TerraxsException{
		asegurarConexionAbierta();
		return new DepartamentoPostgreSQLDAO(conexion);
	}

	@Override
	public CiudadDAO getCiudadDAO() throws TerraxsException{
		asegurarConexionAbierta();
		return new CiudadPostgreSQLDAO(conexion);
	}
	
	@Override
	public ProveedorDAO getProveedorDAO() throws TerraxsException{
		 asegurarConexionAbierta();
		return new ProveedorPostgreSQLDAO(conexion);
	}
	
	@Override
	public TokenConfirmacionDAO getTokenConfirmacionDAO() throws TerraxsException{
		 asegurarConexionAbierta();
		return new TokenConfirmacionPostgreSQLDAO(conexion);
	}
    

}



