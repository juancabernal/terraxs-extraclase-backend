package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class ProductoProveedorDomain {

    private UUID id;
    private ProveedorDomain proveedor;
    private ProductoDomain producto;
    private double precioFinal;
    private int stock;
    private UnidadDomain unidad;

    public ProductoProveedorDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setProveedor(ProveedorDomain.obtenerValorDefecto());
        setProducto(ProductoDomain.obtenerValorDefecto());
        setPrecioFinal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setStock(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadDomain.obtenerValorDefecto());
    }

    public ProductoProveedorDomain(final UUID id) {
        setId(id);
        setProveedor(ProveedorDomain.obtenerValorDefecto());
        setProducto(ProductoDomain.obtenerValorDefecto());
        setPrecioFinal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setStock(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadDomain.obtenerValorDefecto());
    }

    public ProductoProveedorDomain(final UUID id, final ProveedorDomain proveedor, final ProductoDomain producto, final double precioFinal, final int stock, final UnidadDomain unidad) {
        setId(id);
        setProveedor(proveedor);
        setProducto(producto);
        setPrecioFinal(precioFinal);
        setStock(stock);
        setUnidad(unidad);
    }

    public static ProductoProveedorDomain obtenerValorDefecto() {
        return new ProductoProveedorDomain();
    }

    public static ProductoProveedorDomain obtenerValorDefecto(final ProductoProveedorDomain entity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entity, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProveedorDomain getProveedor() {
        return proveedor;
    }

    public void setProveedor(final ProveedorDomain proveedor) {
        this.proveedor = ProveedorDomain.obtenerValorDefecto(proveedor);
    }

    public ProductoDomain getProducto() {
        return producto;
    }

    public void setProducto(final ProductoDomain producto) {
        this.producto = ProductoDomain.obtenerValorDefecto(producto);
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

    public UnidadDomain getUnidad() {
        return unidad;
    }

    public void setUnidad(final UnidadDomain unidad) {
        this.unidad = UnidadDomain.obtenerValorDefecto(unidad);
    }
}
