/*package co.edu.uco.terraxs.data.dao.factory.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.terraxs.data.dao.entity.ciudad.impl.postgresql.CiudadPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.impl.postgresql.DepartamentoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.estado.EstadoDAO;
import co.edu.uco.terraxs.data.dao.entity.estado.impl.postgresql.EstadoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.notificacion.NotificacionDAO;
import co.edu.uco.terraxs.data.dao.entity.notificacion.impl.postgresql.NotificacionPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.PaisDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.impl.postgresql.PaisPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.proveedor.ProveedorDAO;
import co.edu.uco.terraxs.data.dao.entity.proveedor.impl.postgresql.ProveedorPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.tipodocumento.TipoDocumentoDAO;
import co.edu.uco.terraxs.data.dao.entity.tipodocumento.impl.postgresql.TipoDocumentoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.tipoestado.TipoEstadoDAO;
import co.edu.uco.terraxs.data.dao.entity.tipoestado.impl.postgresql.TipoEstadoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.tiponotificacion.TipoNotificacionDAO;
import co.edu.uco.terraxs.data.dao.entity.tiponotificacion.impl.postgresql.TipoNotificacionPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.TokenConfirmacionDAO;
import co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.impl.postgresql.TokenConfirmacionPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;



public class PostgreSQLDAOFactory extends DAOFactory {

    private HikariDataSource dataSource;
    private Connection conexion;
    private boolean transaccionEstaIniciada;
    private boolean conexionEstaAbierta;

    public PostgreSQLDAOFactory() throws TerraxsException {
        configurarDataSource();
        abrirConexion();
        this.transaccionEstaIniciada = false;
        this.conexionEstaAbierta = true;
    }

    private void configurarDataSource() throws TerraxsException {
        try {
            var url = PropiedadesBaseDatos.obtenerPropiedad("spring.datasource.url");
            var usuario = PropiedadesBaseDatos.obtenerPropiedad("spring.datasource.username");
            var clave = PropiedadesBaseDatos.obtenerPropiedad("spring.datasource.password");
            var driver = PropiedadesBaseDatos.obtenerPropiedad("spring.datasource.driver-class-name");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(usuario);
            config.setPassword(clave);
            config.setDriverClassName(driver);

            // Opciones adicionales recomendadas:
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(2);
            config.setConnectionTimeout(30000); // 30 segundos
            config.setIdleTimeout(600000);      // 10 minutos
            config.setMaxLifetime(1800000);     // 30 minutos

            this.dataSource = new HikariDataSource(config);

        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema configurando el pool de conexiones.";
            var mensajeTecnico = "Excepción al configurar HikariCP DataSource.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    protected void abrirConexion() throws TerraxsException {
    	
		var baseDatos="DOO2025TERRAXS";
		var servidor="ORION.UCO.EDU.CO";
		
        try {
            this.conexion = dataSource.getConnection();
            this.conexionEstaAbierta = true;

    	}catch(SQLException exception) {
    		exception.printStackTrace();
    		var mensajeUsuario="Se ha presentado un problema tratando de obtener la conexión con la fuente de datos para llevar a cabo la operación deseada.";
    		var mensajeTecnico="Se presentó una excepción de tipo SQLException tratando de obtener la conexión con la base de datos "+ baseDatos +" en el servidor "+ servidor +" Para tener más detalles revise el log de errores.";
    		throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
    	}catch(Exception exception) {
    		exception.printStackTrace();
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
    
	@Override
	public EstadoDAO getEstadoDAO() throws TerraxsException{
		 asegurarConexionAbierta();
		return new EstadoPostgreSQLDAO(conexion);
	}
	
	@Override
	public TipoEstadoDAO getTipoEstadoDAO() throws TerraxsException{
		 asegurarConexionAbierta();
		return new TipoEstadoPostgreSQLDAO(conexion);
	}
	
	@Override
	public NotificacionDAO getNotificacionDAO() throws TerraxsException{
		 asegurarConexionAbierta();
		return new NotificacionPostgreSQLDAO(conexion);
	}
	
	@Override
	public TipoNotificacionDAO getTipoNotificacionDAO() throws TerraxsException{
		 asegurarConexionAbierta();
		return new TipoNotificacionPostgreSQLDAO(conexion);
	}
	
	@Override
	public TipoDocumentoDAO getTipoDocumentoDAO() throws TerraxsException{
		 asegurarConexionAbierta();
		return new TipoDocumentoPostgreSQLDAO(conexion);
	}
	

}*/

package co.edu.uco.terraxs.data.dao.factory.postgresql;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.terraxs.data.dao.entity.ciudad.impl.postgresql.CiudadPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.impl.postgresql.DepartamentoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.estado.EstadoDAO;
import co.edu.uco.terraxs.data.dao.entity.estado.impl.postgresql.EstadoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.notificacion.NotificacionDAO;
import co.edu.uco.terraxs.data.dao.entity.notificacion.impl.postgresql.NotificacionPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.PaisDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.impl.postgresql.PaisPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.proveedor.ProveedorDAO;
import co.edu.uco.terraxs.data.dao.entity.proveedor.impl.postgresql.ProveedorPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.tipodocumento.TipoDocumentoDAO;
import co.edu.uco.terraxs.data.dao.entity.tipodocumento.impl.postgresql.TipoDocumentoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.tipoestado.TipoEstadoDAO;
import co.edu.uco.terraxs.data.dao.entity.tipoestado.impl.postgresql.TipoEstadoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.tiponotificacion.TipoNotificacionDAO;
import co.edu.uco.terraxs.data.dao.entity.tiponotificacion.impl.postgresql.TipoNotificacionPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.TokenConfirmacionDAO;
import co.edu.uco.terraxs.data.dao.entity.tokenconfirmacion.impl.postgresql.TokenConfirmacionPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class PostgreSQLDAOFactory extends DAOFactory {

    private HikariDataSource dataSource;
    private final ThreadLocal<Connection> conexionActual = new ThreadLocal<>();

    public PostgreSQLDAOFactory() throws TerraxsException {
        configurarDataSource();
    }

    private void configurarDataSource() throws TerraxsException {
        try {
            var url = PropiedadesBaseDatos.obtenerPropiedad("spring.datasource.url");
            var usuario = PropiedadesBaseDatos.obtenerPropiedad("spring.datasource.username");
            var clave = PropiedadesBaseDatos.obtenerPropiedad("spring.datasource.password");
            var driver = PropiedadesBaseDatos.obtenerPropiedad("spring.datasource.driver-class-name");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(usuario);
            config.setPassword(clave);
            config.setDriverClassName(driver);
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(2);
            config.setConnectionTimeout(30000);
            config.setIdleTimeout(600000);
            config.setMaxLifetime(1800000);

            this.dataSource = new HikariDataSource(config);

        } catch (Exception e) {
            throw DataTerraxsException.reportar("Error configurando el pool de conexiones.", "Excepción en HikariCP", e);
        }
    }

    private Connection obtenerConexionInterna() throws SQLException {
        Connection conn = conexionActual.get();
        if (conn == null || conn.isClosed()) {
            conn = dataSource.getConnection();
            conexionActual.set(conn);
        }
        return conn;
    }

    @Override
    public void abrirConexion() throws TerraxsException {
        try {
            obtenerConexionInterna();
        } catch (SQLException e) {
            throw DataTerraxsException.reportar(
                "Error al abrir conexión con la base de datos.",
                "SQLException al abrir conexión.",
                e
            );
        }
    }

    @Override
    public void cerrarConexion() throws TerraxsException {
        try {
            Connection conn = conexionActual.get();
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            conexionActual.remove();
        } catch (SQLException e) {
            throw DataTerraxsException.reportar("Error cerrando conexión.", "SQLException al cerrar conexión.", e);
        }
    }

    @Override
    public void iniciarTransaccion() throws TerraxsException {
        try {
            Connection conn = obtenerConexionInterna();
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw DataTerraxsException.reportar("Error iniciando transacción.", "SQLException al iniciar transacción.", e);
        }
    }

    @Override
    public void confirmarTransaccion() throws TerraxsException {
        try {
            Connection conn = conexionActual.get();
            if (conn != null) {
                conn.commit();
            }
        } catch (SQLException e) {
            throw DataTerraxsException.reportar("Error confirmando transacción.", "SQLException en commit().", e);
        }
    }

    @Override
    public void cancelarTransaccion() throws TerraxsException {
        try {
            Connection conn = conexionActual.get();
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException e) {
            throw DataTerraxsException.reportar("Error cancelando transacción.", "SQLException en rollback().", e);
        }
    }

    @Override
    public CiudadDAO getCiudadDAO() throws TerraxsException {
        return new CiudadPostgreSQLDAO(obtenerConexionSegura());
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() throws TerraxsException {
        return new DepartamentoPostgreSQLDAO(obtenerConexionSegura());
    }

    @Override
    public EstadoDAO getEstadoDAO() throws TerraxsException {
        return new EstadoPostgreSQLDAO(obtenerConexionSegura());
    }

    @Override
    public TipoEstadoDAO getTipoEstadoDAO() throws TerraxsException {
        return new TipoEstadoPostgreSQLDAO(obtenerConexionSegura());
    }

    @Override
    public PaisDAO getPaisDAO() throws TerraxsException {
        return new PaisPostgreSQLDAO(obtenerConexionSegura());
    }

    @Override
    public ProveedorDAO getProveedorDAO() throws TerraxsException {
        return new ProveedorPostgreSQLDAO(obtenerConexionSegura());
    }

    @Override
    public TipoDocumentoDAO getTipoDocumentoDAO() throws TerraxsException {
        return new TipoDocumentoPostgreSQLDAO(obtenerConexionSegura());
    }

    @Override
    public NotificacionDAO getNotificacionDAO() throws TerraxsException {
        return new NotificacionPostgreSQLDAO(obtenerConexionSegura());
    }

    @Override
    public TipoNotificacionDAO getTipoNotificacionDAO() throws TerraxsException {
        return new TipoNotificacionPostgreSQLDAO(obtenerConexionSegura());
    }

    @Override
    public TokenConfirmacionDAO getTokenConfirmacionDAO() throws TerraxsException {
        return new TokenConfirmacionPostgreSQLDAO(obtenerConexionSegura());
    }

    private Connection obtenerConexionSegura() throws TerraxsException {
        try {
            return obtenerConexionInterna();
        } catch (SQLException e) {
            throw DataTerraxsException.reportar("No se pudo obtener conexión segura.", "SQLException", e);
        }
    }
}




