package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class ProductoProveedorEntity {

    private UUID id;
    private ProveedorEntity proveedor;
    private ProductoEntity producto;
    private double precioFinal;
    private int stock;
    private UnidadEntity unidad;

    public ProductoProveedorEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setProveedor(ProveedorEntity.obtenerValorDefecto());
        setProducto(ProductoEntity.obtenerValorDefecto());
        setPrecioFinal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setStock(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadEntity.obtenerValorDefecto());
    }

    public ProductoProveedorEntity(final UUID id) {
        setId(id);
        setProveedor(ProveedorEntity.obtenerValorDefecto());
        setProducto(ProductoEntity.obtenerValorDefecto());
        setPrecioFinal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setStock(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadEntity.obtenerValorDefecto());
    }

    public ProductoProveedorEntity(final UUID id, final ProveedorEntity proveedor, final ProductoEntity producto, final double precioFinal, final int stock, final UnidadEntity unidad) {
        setId(id);
        setProveedor(proveedor);
        setProducto(producto);
        setPrecioFinal(precioFinal);
        setStock(stock);
        setUnidad(unidad);
    }

    public static ProductoProveedorEntity obtenerValorDefecto() {
        return new ProductoProveedorEntity();
    }

    public static ProductoProveedorEntity obtenerValorDefecto(final ProductoProveedorEntity entity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entity, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(final ProveedorEntity proveedor) {
        this.proveedor = ProveedorEntity.obtenerValorDefecto(proveedor);
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(final ProductoEntity producto) {
        this.producto = ProductoEntity.obtenerValorDefecto(producto);
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(final double precioFinal) {
        this.precioFinal = UtilNumero.getInstance().obtenerValorDefecto(precioFinal);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(final int stock) {
        this.stock = UtilNumero.getInstance().obtenerValorDefecto(stock);
    }

    public UnidadEntity getUnidad() {
        return unidad;
    }

    public void setUnidad(final UnidadEntity unidad) {
        this.unidad = UnidadEntity.obtenerValorDefecto(unidad);
    }
}
