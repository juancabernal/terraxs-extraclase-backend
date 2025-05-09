package co.edu.uco.terraxs.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class DetallePedidoEntity {

    private UUID id;
    private ProductoProveedorEntity productoProveedor;
    private LocalDate fechaPedido;
    private int cantidad;
    private UnidadEntity unidad;
    private double precioUnitario;
    private double subTotal;
    private PedidoEntity pedido;

    public DetallePedidoEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setProductoProveedor(ProductoProveedorEntity.obtenerValorDefecto());
        setFechaPedido(UtilFecha.getInstance().obtenerFechaActual());
        setCantidad(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadEntity.obtenerValorDefecto());
        setPrecioUnitario(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setSubTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setPedido(PedidoEntity.obtenerValorDefecto());
    }

    public DetallePedidoEntity(final UUID id) {
        setId(id);
        setProductoProveedor(ProductoProveedorEntity.obtenerValorDefecto());
        setFechaPedido(UtilFecha.getInstance().obtenerFechaActual());
        setCantidad(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadEntity.obtenerValorDefecto());
        setPrecioUnitario(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setSubTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setPedido(PedidoEntity.obtenerValorDefecto());
    }

    public DetallePedidoEntity(final UUID id, final ProductoProveedorEntity productoProveedor, final LocalDate fechaPedido, final int cantidad, final UnidadEntity unidad, final double precioUnitario, final double subTotal, final PedidoEntity pedido) {
        setId(id);
        setProductoProveedor(productoProveedor);
        setFechaPedido(fechaPedido);
        setCantidad(cantidad);
        setUnidad(unidad);
        setPrecioUnitario(precioUnitario);
        setSubTotal(subTotal);
        setPedido(pedido);
    }

    public static DetallePedidoEntity obtenerValorDefecto() {
        return new DetallePedidoEntity();
    }

    public static DetallePedidoEntity obtenerValorDefecto(final DetallePedidoEntity entity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entity, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProductoProveedorEntity getProductoProveedor() {
        return productoProveedor;
    }

    public void setProductoProveedor(final ProductoProveedorEntity productoProveedor) {
        this.productoProveedor = ProductoProveedorEntity.obtenerValorDefecto(productoProveedor);
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(final LocalDate fechaPedido) {
        this.fechaPedido = UtilFecha.getInstance().obtenerValorDefecto(fechaPedido);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(final int cantidad) {
        this.cantidad = UtilNumero.getInstance().obtenerValorDefecto(cantidad);
    }

    public UnidadEntity getUnidad() {
        return unidad;
    }

    public void setUnidad(final UnidadEntity unidad) {
        this.unidad = UnidadEntity.obtenerValorDefecto(unidad);
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(final double precioUnitario) {
        this.precioUnitario = UtilNumero.getInstance().obtenerValorDefecto(precioUnitario);
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(final double subTotal) {
        this.subTotal = UtilNumero.getInstance().obtenerValorDefecto(subTotal);
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(final PedidoEntity pedido) {
        this.pedido = PedidoEntity.obtenerValorDefecto(pedido);
    }
}