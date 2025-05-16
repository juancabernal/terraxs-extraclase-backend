package co.edu.uco.terraxs.data.dao.factory.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.terraxs.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.terraxs.data.dao.entity.ciudad.impl.postgresql.CiudadPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.terraxs.data.dao.entity.departamento.impl.postgresql.DepartamentoPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.PaisDAO;
import co.edu.uco.terraxs.data.dao.entity.pais.impl.postgresql.PaisPostgreSQLDAO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class PostgreSQLDAOFactory extends DAOFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/DOO2025TERRAXS";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1036778928";
    private static final String DRIVER = "org.postgresql.Driver";

    private Connection conexion;

    public PostgreSQLDAOFactory() {
        abrirConexion();
    }

    @Override
    protected void abrirConexion() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            conexion.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error al abrir conexión con la base de datos PostgreSQL", e);
        }
    }

    @Override
    public void iniciarTransaccion() {
        try {
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al iniciar la transacción", e);
        }
    }

    @Override
    public void confirmarTransaccion() {
        try {
            conexion.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Error al confirmar la transacción", e);
        }
    }

    @Override
    public void cancelarTransaccion() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            throw new RuntimeException("Error al cancelar la transacción", e);
        }
    }

    @Override
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexión", e);
        }
    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisPostgreSQLDAO(conexion);
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoPostgreSQLDAO(conexion);
    }

    @Override
    public CiudadDAO getCiudadDAO() {
        return new CiudadPostgreSQLDAO(conexion);
    }
    

}


