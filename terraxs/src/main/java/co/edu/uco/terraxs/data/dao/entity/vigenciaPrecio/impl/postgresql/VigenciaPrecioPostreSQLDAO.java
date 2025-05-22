package co.edu.uco.terraxs.data.dao.entity.vigenciaPrecio.impl.postgresql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.vigenciaPrecio.VigenciaPrecioDAO;
import co.edu.uco.terraxs.entity.ProductoProveedorEntity;
import co.edu.uco.terraxs.entity.VigenciaPrecioEntity;

public class VigenciaPrecioPostreSQLDAO implements VigenciaPrecioDAO {

    private Connection conexion;

    public VigenciaPrecioPostreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(VigenciaPrecioEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO VigenciaPrecio(id, precio, fechaInicio, fechaFin, producto) VALUES (?, ?, ?, ?, ?)");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setDouble(2, entity.getPrecio());
            sentenciaPreparada.setDate(3, Date.valueOf(entity.getFechaInicio()));
            sentenciaPreparada.setDate(4, Date.valueOf(entity.getFechaFin()));
            sentenciaPreparada.setObject(5, entity.getProductoProveedor().getId());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la información de la nueva vigencia de precio.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla VigenciaPrecio. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información de la nueva vigencia de precio.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla VigenciaPrecio. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<VigenciaPrecioEntity> listALL() throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, precio, fechaInicio, fechaFin, producto FROM VigenciaPrecio");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {
                List<VigenciaPrecioEntity> listaResultados = new java.util.ArrayList<>();

                while (cursorResultados.next()) {
                    VigenciaPrecioEntity entity = new VigenciaPrecioEntity();
                    entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    entity.setPrecio(cursorResultados.getDouble("precio"));
                    entity.setFechaInicio(cursorResultados.getDate("fechaInicio").toLocalDate());
                    entity.setFechaFin(cursorResultados.getDate("fechaFin").toLocalDate());

                    ProductoProveedorEntity productoProveedor = new ProductoProveedorEntity();
                    productoProveedor.setId(UtilUUID.convertirAUUID(cursorResultados.getString("producto")));
                    entity.setProductoProveedor(productoProveedor);

                    listaResultados.add(entity);
                }

                return listaResultados;
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar todas las vigencias de precios.";
            var mensajeTecnico = "Se presentó una SQLException ejecutando un SELECT general en la tabla VigenciaPrecio.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO consultando todas las vigencias de precios.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA ejecutando un SELECT general en la tabla VigenciaPrecio.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<VigenciaPrecioEntity> listByFilter(VigenciaPrecioEntity filter) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, precio, fechaInicio, fechaFin, producto FROM VigenciaPrecio WHERE 1=1 ");

        List<Object> parametros = new java.util.ArrayList<>();

        if (filter.getId() != null) {
            sentenciaSQL.append("AND id = ? ");
            parametros.add(filter.getId());
        }
        if (filter.getPrecio() > 0) {
            sentenciaSQL.append("AND precio = ? ");
            parametros.add(filter.getPrecio());
        }
        if (filter.getFechaInicio() != null) {
            sentenciaSQL.append("AND fechaInicio = ? ");
            parametros.add(Date.valueOf(filter.getFechaInicio()));
        }
        if (filter.getFechaFin() != null) {
            sentenciaSQL.append("AND fechaFin = ? ");
            parametros.add(Date.valueOf(filter.getFechaFin()));
        }
        if (filter.getProductoProveedor() != null && filter.getProductoProveedor().getId() != null) {
            sentenciaSQL.append("AND producto = ? ");
            parametros.add(filter.getProductoProveedor().getId());
        }

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaPreparada.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {
                List<VigenciaPrecioEntity> listaResultados = new java.util.ArrayList<>();

                while (cursorResultados.next()) {
                    VigenciaPrecioEntity entity = new VigenciaPrecioEntity();
                    entity.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    entity.setPrecio(cursorResultados.getDouble("precio"));
                    entity.setFechaInicio(cursorResultados.getDate("fechaInicio").toLocalDate());
                    entity.setFechaFin(cursorResultados.getDate("fechaFin").toLocalDate());

                    ProductoProveedorEntity productoProveedor = new ProductoProveedorEntity();
                    productoProveedor.setId(UtilUUID.convertirAUUID(cursorResultados.getString("producto")));
                    entity.setProductoProveedor(productoProveedor);

                    listaResultados.add(entity);
                }

                return listaResultados;
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar vigencias de precios por filtro.";
            var mensajeTecnico = "Se presentó una SQLException ejecutando un SELECT filtrado en la tabla VigenciaPrecio.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO consultando vigencias de precios por filtro.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA ejecutando un SELECT filtrado en la tabla VigenciaPrecio.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public VigenciaPrecioEntity listById(UUID id) throws TerraxsException {
        VigenciaPrecioEntity vigenciaPrecioEntityRetorno = new VigenciaPrecioEntity();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, precio, fechaInicio, fechaFin, producto FROM VigenciaPrecio WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);
            try (ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {

                if (cursorResultados.next()) {
                    vigenciaPrecioEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    vigenciaPrecioEntityRetorno.setPrecio(cursorResultados.getDouble("precio"));
                    vigenciaPrecioEntityRetorno.setFechaInicio(cursorResultados.getDate("fechaInicio").toLocalDate());
                    vigenciaPrecioEntityRetorno.setFechaFin(cursorResultados.getDate("fechaFin").toLocalDate());

                    ProductoProveedorEntity productoProveedor = new ProductoProveedorEntity();
                    productoProveedor.setId(UtilUUID.convertirAUUID(cursorResultados.getString("producto")));
                    vigenciaPrecioEntityRetorno.setProductoProveedor(productoProveedor);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de la vigencia de precio con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla VigenciaPrecio por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de la vigencia de precio con el identificador deseado.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla VigenciaPrecio por id. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return vigenciaPrecioEntityRetorno;
    }

    @Override
    public void update(UUID id, VigenciaPrecioEntity entity) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE VigenciaPrecio SET precio = ?, fechaInicio = ?, fechaFin = ?, producto = ? WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setDouble(1, entity.getPrecio());
            sentenciaPreparada.setDate(2, Date.valueOf(entity.getFechaInicio()));
            sentenciaPreparada.setDate(3, Date.valueOf(entity.getFechaFin()));
            sentenciaPreparada.setObject(4, entity.getProductoProveedor().getId());
            sentenciaPreparada.setObject(5, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información de la vigencia de precio.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla VigenciaPrecio. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información de la vigencia de precio.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla VigenciaPrecio. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID id) throws TerraxsException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM VigenciaPrecio WHERE id = ?");

        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información de la vigencia de precio.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla VigenciaPrecio. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información de la vigencia de precio.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla VigenciaPrecio. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}