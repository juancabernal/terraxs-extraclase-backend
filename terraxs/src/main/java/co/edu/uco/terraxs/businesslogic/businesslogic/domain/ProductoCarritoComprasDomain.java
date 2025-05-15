
package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;


public final class ProductoCarritoComprasDomain {

    private UUID id;
    private ProductoDomain producto;
    private CarritoComprasDomain carrito;
    private int cantidadProducto;
    private UnidadDomain unidades;

    public ProductoCarritoComprasDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setProducto(ProductoDomain.obtenerValorDefecto());
        setCarrito(CarritoComprasDomain.obtenerValorDefecto());
        setCantidadProducto(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidades(UnidadDomain.obtenerValorDefecto());
    }

    public ProductoCarritoComprasDomain(final UUID id) {
        setId(id);
        setProducto(ProductoDomain.obtenerValorDefecto());
        setCarrito(CarritoComprasDomain.obtenerValorDefecto());
        setCantidadProducto(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidades(UnidadDomain.obtenerValorDefecto());
    }

    public ProductoCarritoComprasDomain(final UUID id, final ProductoDomain producto, final CarritoComprasDomain carrito, final int cantidadProducto, final UnidadDomain unidades) {
        setId(id);
        setProducto(producto);
        setCarrito(carrito);
        setCantidadProducto(cantidadProducto);
        setUnidades(unidades);
    }

    public static ProductoCarritoComprasDomain obtenerValorDefecto() {
        return new ProductoCarritoComprasDomain();
    }

    public static ProductoCarritoComprasDomain obtenerValorDefecto(final ProductoCarritoComprasDomain entity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entity, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProductoDomain getProducto() {
        return producto;
    }

    public void setProducto(final ProductoDomain producto) {
        this.producto = ProductoDomain.obtenerValorDefecto(producto);
    }

    public CarritoComprasDomain getCarrito() {
        return carrito;
    }

    public void setCarrito(final CarritoComprasDomain carrito) {
        this.carrito = CarritoComprasDomain.obtenerValorDefecto(carrito);
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(final int cantidadProducto) {
        this.cantidadProducto = UtilNumero.getInstance().obtenerValorDefecto(cantidadProducto);
    }

    public UnidadDomain getUnidades() {
        return unidades;
    }

    public void setUnidades(final UnidadDomain unidades) {
        this.unidades = UnidadDomain.obtenerValorDefecto(unidades);
    }
}