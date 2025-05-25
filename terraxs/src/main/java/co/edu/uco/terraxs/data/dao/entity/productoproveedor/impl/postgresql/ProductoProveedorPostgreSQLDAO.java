package co.edu.uco.terraxs.data.dao.entity.productoproveedor.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.excepciones.DataTerraxsException;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.data.dao.entity.productoproveedor.ProductoProveedorDAO;
import co.edu.uco.terraxs.entity.ProductoEntity;
import co.edu.uco.terraxs.entity.ProductoProveedorEntity;
import co.edu.uco.terraxs.entity.ProveedorEntity;
import co.edu.uco.terraxs.entity.UnidadEntity;

public class ProductoProveedorPostgreSQLDAO implements ProductoProveedorDAO {

	private final Connection conexion;

	public ProductoProveedorPostgreSQLDAO(final Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void create(ProductoProveedorEntity entity) throws TerraxsException {
		var sentenciaSQL = new StringBuilder();
		sentenciaSQL.append("INSERT INTO productoProveedor (id, proveedor, producto, preciofinal, stock, unidad) ");
		sentenciaSQL.append("VALUES (?, ?, ?, ?, ?, ?)");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getProveedor().getId());
			sentenciaPreparada.setObject(3, entity.getProducto().getId());
			sentenciaPreparada.setDouble(4, entity.getPrecioFinal());
			sentenciaPreparada.setInt(5, entity.getStock());
			sentenciaPreparada.setObject(6, entity.getUnidad().getId());

			sentenciaPreparada.executeUpdate();
		} catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la información del nuevo productoProveedor.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un INSERT en la tabla productoProveedor. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información del nuevo productoProveedor.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla productoProveedor. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    
	}

	@Override
	public List<ProductoProveedorEntity> listALL() throws TerraxsException {
	    var listaResultados = new ArrayList<ProductoProveedorEntity>();
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT id, proveedor, producto, precio_final, stock, unidad FROM producto_proveedor ORDER BY id ASC");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

	        try (var cursorResultados = sentenciaPreparada.executeQuery()) {

	            while (cursorResultados.next()) {
	                var entityRetorno = new ProductoProveedorEntity();

	                entityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));

	                var proveedor = new ProveedorEntity();
	                proveedor.setId(UtilUUID.convertirAUUID(cursorResultados.getString("proveedor")));
	                entityRetorno.setProveedor(proveedor);

	                var producto = new ProductoEntity();
	                producto.setId(UtilUUID.convertirAUUID(cursorResultados.getString("producto")));
	                entityRetorno.setProducto(producto);

	                entityRetorno.setPrecioFinal(cursorResultados.getDouble("precio_final"));
	                entityRetorno.setStock(cursorResultados.getInt("stock"));

	                var unidad = new UnidadEntity();
	                unidad.setId(UtilUUID.convertirAUUID(cursorResultados.getString("unidad")));
	                entityRetorno.setUnidad(unidad);

	                listaResultados.add(entityRetorno);
	            }
	        }

	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar todos los productos por proveedor.";
	        var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT * en la tabla producto_proveedor.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar todos los productos por proveedor.";
	        var mensajeTecnico = "Excepción NO CONTROLADA al consultar todos los registros de producto_proveedor.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return listaResultados;
	}

	@Override
	public ProductoProveedorEntity listById(UUID id) throws TerraxsException {
	    ProductoProveedorEntity entityRetorno = null;
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT id, proveedor, producto, precio_final, stock, unidad ");
	    sentenciaSQL.append("FROM producto_proveedor WHERE id = ?");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

	        sentenciaPreparada.setObject(1, id);

	        try (var cursorResultados = sentenciaPreparada.executeQuery()) {

	            if (cursorResultados.next()) {
	                entityRetorno = new ProductoProveedorEntity();

	                entityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));

	                var proveedor = new ProveedorEntity();
	                proveedor.setId(UtilUUID.convertirAUUID(cursorResultados.getString("proveedor")));
	                entityRetorno.setProveedor(proveedor);

	                var producto = new ProductoEntity();
	                producto.setId(UtilUUID.convertirAUUID(cursorResultados.getString("producto")));
	                entityRetorno.setProducto(producto);

	                entityRetorno.setPrecioFinal(cursorResultados.getDouble("precio_final"));
	                entityRetorno.setStock(cursorResultados.getInt("stock"));

	                var unidad = new UnidadEntity();
	                unidad.setId(UtilUUID.convertirAUUID(cursorResultados.getString("unidad")));
	                entityRetorno.setUnidad(unidad);
	            }
	        }

	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar el producto por proveedor con el ID dado.";
	        var mensajeTecnico = "Se presentó una SQLException al ejecutar SELECT WHERE ID en la tabla producto_proveedor.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar un producto por proveedor.";
	        var mensajeTecnico = "Excepción NO CONTROLADA al consultar un registro de la tabla producto_proveedor.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return entityRetorno;
	}


	@Override
	public void update(UUID id, ProductoProveedorEntity entity) throws TerraxsException {
		var sentenciaSQL = new StringBuilder();
		sentenciaSQL.append("UPDATE productoProveedor ");
		sentenciaSQL.append("SET proveedor = ?, producto = ?, preciofinal = ?, stock = ?, unidad = ? ");
		sentenciaSQL.append("WHERE id = ?");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, entity.getProveedor().getId());
			sentenciaPreparada.setObject(2, entity.getProducto().getId());
			sentenciaPreparada.setDouble(3, entity.getPrecioFinal());
			sentenciaPreparada.setInt(4, entity.getStock());
			sentenciaPreparada.setObject(5, entity.getUnidad().getId());
			sentenciaPreparada.setObject(6, id);

			sentenciaPreparada.executeUpdate();
		} catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del productoProveedor.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un UPDATE en la tabla productoProveedor. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información del productoProveedor.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla productoProveedor. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        
		}
	}

	@Override
	public void delete(UUID id) throws TerraxsException {
		var sentenciaSQL = new StringBuilder();
		sentenciaSQL.append("DELETE FROM productoProveedor WHERE id = ?");

		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
		}catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del productoProveedor.";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un DELETE en la tabla productoProveedor. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la información del productoProveedor.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla productoProveedor. Para tener más detalles, revise el log de errores.";
            throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
        
		}
	}

	@Override
	public List<ProductoProveedorEntity> listByFilter(ProductoProveedorEntity filter) throws TerraxsException {
	    var listaResultados = new ArrayList<ProductoProveedorEntity>();
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT id, proveedor, producto, precio_final, stock, unidad ");
	    sentenciaSQL.append("FROM producto_proveedor WHERE 1=1 ");

	    var parametros = new ArrayList<Object>();

	    if (filter.getId() != null) {
	        sentenciaSQL.append("AND id = ? ");
	        parametros.add(filter.getId());
	    }
	    if (filter.getProveedor() != null && filter.getProveedor().getId() != null) {
	        sentenciaSQL.append("AND proveedor = ? ");
	        parametros.add(filter.getProveedor().getId());
	    }
	    if (filter.getProducto() != null && filter.getProducto().getId() != null) {
	        sentenciaSQL.append("AND producto = ? ");
	        parametros.add(filter.getProducto().getId());
	    }
	    if (filter.getUnidad() != null && filter.getUnidad().getId() != null) {
	        sentenciaSQL.append("AND unidad = ? ");
	        parametros.add(filter.getUnidad().getId());
	    }
	    if (filter.getPrecioFinal() > 0) {
	        sentenciaSQL.append("AND precio_final = ? ");
	        parametros.add(filter.getPrecioFinal());
	    }
	    if (filter.getStock() > 0) {
	        sentenciaSQL.append("AND stock = ? ");
	        parametros.add(filter.getStock());
	    }

	    sentenciaSQL.append("ORDER BY id ASC");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

	        for (int i = 0; i < parametros.size(); i++) {
	            sentenciaPreparada.setObject(i + 1, parametros.get(i));
	        }

	        try (var cursorResultados = sentenciaPreparada.executeQuery()) {
	            while (cursorResultados.next()) {
	                var entityRetorno = new ProductoProveedorEntity();

	                entityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));

	                var proveedor = new ProveedorEntity();
	                proveedor.setId(UtilUUID.convertirAUUID(cursorResultados.getString("proveedor")));
	                entityRetorno.setProveedor(proveedor);

	                var producto = new ProductoEntity();
	                producto.setId(UtilUUID.convertirAUUID(cursorResultados.getString("producto")));
	                entityRetorno.setProducto(producto);

	                entityRetorno.setPrecioFinal(cursorResultados.getDouble("precio_final"));
	                entityRetorno.setStock(cursorResultados.getInt("stock"));

	                var unidad = new UnidadEntity();
	                unidad.setId(UtilUUID.convertirAUUID(cursorResultados.getString("unidad")));
	                entityRetorno.setUnidad(unidad);

	                listaResultados.add(entityRetorno);
	            }
	        }

	    } catch (SQLException exception) {
	        var mensajeUsuario = "Ocurrió un problema tratando de consultar los productos por proveedor con filtros.";
	        var mensajeTecnico = "SQLException al ejecutar SELECT con filtros en la tabla producto_proveedor.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Ocurrió un problema inesperado al consultar los productos por proveedor con filtros.";
	        var mensajeTecnico = "Excepción NO CONTROLADA durante la consulta filtrada en producto_proveedor.";
	        throw DataTerraxsException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return listaResultados;
	}
}

