package co.edu.uco.terraxs.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class DetallePedidoDTO {

    private UUID id;
    private ProductoProveedorDTO productoProveedor;
    private LocalDate fechaPedido;
    private int cantidad;
    private UnidadDTO unidad;
    private double precioUnitario;
    private double subTotal;
    private PedidoDTO pedido;

    public DetallePedidoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setProductoProveedor(ProductoProveedorDTO.obtenerValorDefecto());
        setFechaPedido(UtilFecha.getInstance().obtenerFechaActual());
        setCantidad(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadDTO.obtenerValorDefecto());
        setPrecioUnitario(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setSubTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setPedido(PedidoDTO.obtenerValorDefecto());
    }

    public DetallePedidoDTO(final UUID id) {
        setId(id);
        setProductoProveedor(ProductoProveedorDTO.obtenerValorDefecto());
        setFechaPedido(UtilFecha.getInstance().obtenerFechaActual());
        setCantidad(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadDTO.obtenerValorDefecto());
        setPrecioUnitario(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setSubTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setPedido(PedidoDTO.obtenerValorDefecto());
    }

    public DetallePedidoDTO(final UUID id, final ProductoProveedorDTO productoProveedor, final LocalDate fechaPedido, final int cantidad, final UnidadDTO unidad, final double precioUnitario, final double subTotal, final PedidoDTO pedido) {
        setId(id);
        setProductoProveedor(productoProveedor);
        setFechaPedido(fechaPedido);
        setCantidad(cantidad);
        setUnidad(unidad);
        setPrecioUnitario(precioUnitario);
        setSubTotal(subTotal);
        setPedido(pedido);
    }

    public static DetallePedidoDTO obtenerValorDefecto() {
        return new DetallePedidoDTO();
    }

    public static DetallePedidoDTO obtenerValorDefecto(final DetallePedidoDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public DetallePedidoDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public ProductoProveedorDTO getProductoProveedor() {
        return productoProveedor;
    }

    public DetallePedidoDTO setProductoProveedor(final ProductoProveedorDTO productoProveedor) {
        this.productoProveedor = ProductoProveedorDTO.obtenerValorDefecto(productoProveedor);
        return this;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public DetallePedidoDTO setFechaPedido(final LocalDate fechaPedido) {
        this.fechaPedido = UtilFecha.getInstance().obtenerValorDefecto(fechaPedido);
        return this;
    }

    public int getCantidad() {
        return cantidad;
    }

    public DetallePedidoDTO setCantidad(final int cantidad) {
        this.cantidad = UtilNumero.getInstance().obtenerValorDefecto(cantidad);
        return this;
    }

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public DetallePedidoDTO setUnidad(final UnidadDTO unidad) {
        this.unidad = UnidadDTO.obtenerValorDefecto(unidad);
        return this;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public DetallePedidoDTO setPrecioUnitario(final double precioUnitario) {
        this.precioUnitario = UtilNumero.getInstance().obtenerValorDefecto(precioUnitario);
        return this;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public DetallePedidoDTO setSubTotal(final double subTotal) {
        this.subTotal = UtilNumero.getInstance().obtenerValorDefecto(subTotal);
        return this;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public DetallePedidoDTO setPedido(final PedidoDTO pedido) {
        this.pedido = PedidoDTO.obtenerValorDefecto(pedido);
        return this;
    }
}