package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class DetallePedidoDomain {

    private UUID id;
    private ProductoProveedorDomain productoProveedor;
    private LocalDate fechaPedido;
    private int cantidad;
    private UnidadDomain unidad;
    private double precioUnitario;
    private double subTotal;
    private PedidoDomain pedido;

    public DetallePedidoDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setProductoProveedor(ProductoProveedorDomain.obtenerValorDefecto());
        setFechaPedido(UtilFecha.getInstance().obtenerFechaActual());
        setCantidad(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadDomain.obtenerValorDefecto());
        setPrecioUnitario(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setSubTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setPedido(PedidoDomain.obtenerValorDefecto());
    }

    public DetallePedidoDomain(final UUID id) {
        setId(id);
        setProductoProveedor(ProductoProveedorDomain.obtenerValorDefecto());
        setFechaPedido(UtilFecha.getInstance().obtenerFechaActual());
        setCantidad(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadDomain.obtenerValorDefecto());
        setPrecioUnitario(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setSubTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setPedido(PedidoDomain.obtenerValorDefecto());
    }

    public DetallePedidoDomain(final UUID id, final ProductoProveedorDomain productoProveedor, final LocalDate fechaPedido, final int cantidad, final UnidadDomain unidad, final double precioUnitario, final double subTotal, final PedidoDomain pedido) {
        setId(id);
        setProductoProveedor(productoProveedor);
        setFechaPedido(fechaPedido);
        setCantidad(cantidad);
        setUnidad(unidad);
        setPrecioUnitario(precioUnitario);
        setSubTotal(subTotal);
        setPedido(pedido);
    }

    public static DetallePedidoDomain obtenerValorDefecto() {
        return new DetallePedidoDomain();
    }

    public static DetallePedidoDomain obtenerValorDefecto(final DetallePedidoDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProductoProveedorDomain getProductoProveedor() {
        return productoProveedor;
    }

    public void setProductoProveedor(final ProductoProveedorDomain productoProveedor) {
        this.productoProveedor = ProductoProveedorDomain.obtenerValorDefecto(productoProveedor);
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

    public UnidadDomain getUnidad() {
        return unidad;
    }

    public void setUnidad(final UnidadDomain unidad) {
        this.unidad = UnidadDomain.obtenerValorDefecto(unidad);
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

    public PedidoDomain getPedido() {
        return pedido;
    }

    public void setPedido(final PedidoDomain pedido) {
        this.pedido = PedidoDomain.obtenerValorDefecto(pedido);
    }
}