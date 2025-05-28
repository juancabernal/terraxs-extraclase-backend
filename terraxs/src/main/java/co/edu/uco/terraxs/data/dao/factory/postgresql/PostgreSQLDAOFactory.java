
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
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema configurando el pool de conexiones.";
            var mensajeTecnico = "Excepción al configurar HikariCP DataSource. Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    private Connection obtenerConexionInterna() throws TerraxsException {
        try {
            Connection conn = conexionActual.get();
            if (conn == null || conn.isClosed()) {
                conn = dataSource.getConnection();
                conexionActual.set(conn);
            }
            return conn;
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema obteniendo una conexión segura con la base de datos.";
            var mensajeTecnico = "SQLException al intentar obtener una nueva conexión del pool. Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void abrirConexion() throws TerraxsException {
        try {
            obtenerConexionInterna(); // Garantiza que la conexión esté lista en ThreadLocal
        } catch (TerraxsException exception) {
            throw exception;
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO tratando de abrir una conexión con la base de datos.";
            var mensajeTecnico = "Excepción no controlada al abrir la conexión. Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
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
        } catch (SQLException exception) {
            var mensajeUsuario = "Se presentó un problema cerrando la conexión con la base de datos.";
            var mensajeTecnico = "SQLException al intentar cerrar la conexión activa. Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO cerrando la conexión.";
            var mensajeTecnico = "Excepción no controlada al cerrar la conexión. Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void iniciarTransaccion() throws TerraxsException {
        try {
            Connection conn = obtenerConexionInterna();
            conn.setAutoCommit(false);
        } catch (SQLException exception) {
            var mensajeUsuario = "Se presentó un problema iniciando la transacción con la base de datos.";
            var mensajeTecnico = "SQLException al hacer setAutoCommit(false). Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO iniciando la transacción.";
            var mensajeTecnico = "Excepción no controlada iniciando la transacción. Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void confirmarTransaccion() throws TerraxsException {
        try {
            Connection conn = conexionActual.get();
            if (conn != null) {
                conn.commit();
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se presentó un problema confirmando la transacción para guardar los cambios.";
            var mensajeTecnico = "SQLException al hacer commit(). Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO al confirmar la transacción.";
            var mensajeTecnico = "Excepción no controlada al hacer commit(). Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void cancelarTransaccion() throws TerraxsException {
        try {
            Connection conn = conexionActual.get();
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se presentó un problema cancelando la transacción para deshacer los cambios.";
            var mensajeTecnico = "SQLException al hacer rollback(). Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se presentó un problema INESPERADO cancelando la transacción.";
            var mensajeTecnico = "Excepción no controlada al hacer rollback(). Revise el log de errores para más dettalles";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
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
        return obtenerConexionInterna();
    }

}




