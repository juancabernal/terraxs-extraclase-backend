
package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class ProductoCarritoComprasEntity {

    private UUID id;
    private ProductoEntity producto;
    private CarritoComprasEntity carrito;
    private int cantidadProducto;
    private UnidadEntity unidades;

    public ProductoCarritoComprasEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setProducto(ProductoEntity.obtenerValorDefecto());
        setCarrito(CarritoComprasEntity.obtenerValorDefecto());
        setCantidadProducto(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidades(UnidadEntity.obtenerValorDefecto());
    }

    public ProductoCarritoComprasEntity(final UUID id) {
        setId(id);
        setProducto(ProductoEntity.obtenerValorDefecto());
        setCarrito(CarritoComprasEntity.obtenerValorDefecto());
        setCantidadProducto(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidades(UnidadEntity.obtenerValorDefecto());
    }

    public ProductoCarritoComprasEntity(final UUID id, final ProductoEntity producto, final CarritoComprasEntity carrito, final int cantidadProducto, final UnidadEntity unidades) {
        setId(id);
        setProducto(producto);
        setCarrito(carrito);
        setCantidadProducto(cantidadProducto);
        setUnidades(unidades);
    }

    public static ProductoCarritoComprasEntity obtenerValorDefecto() {
        return new ProductoCarritoComprasEntity();
    }

    public static ProductoCarritoComprasEntity obtenerValorDefecto(final ProductoCarritoComprasEntity entity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entity, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(final ProductoEntity producto) {
        this.producto = ProductoEntity.obtenerValorDefecto(producto);
    }

    public CarritoComprasEntity getCarrito() {
        return carrito;
    }

    public void setCarrito(final CarritoComprasEntity carrito) {
        this.carrito = CarritoComprasEntity.obtenerValorDefecto(carrito);
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(final int cantidadProducto) {
        this.cantidadProducto = UtilNumero.getInstance().obtenerValorDefecto(cantidadProducto);
    }

    public UnidadEntity getUnidades() {
        return unidades;
    }

    public void setUnidades(final UnidadEntity unidades) {
        this.unidades = UnidadEntity.obtenerValorDefecto(unidades);
    }
}