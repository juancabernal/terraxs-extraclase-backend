package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class ProductoCarritoComprasDTO {

    private UUID id;
    private ProductoDTO producto;
    private CarritoComprasDTO carrito;
    private int cantidadProducto;
    private UnidadDTO unidades;

    public ProductoCarritoComprasDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setProducto(ProductoDTO.obtenerValorDefecto());
        setCarrito(CarritoComprasDTO.obtenerValorDefecto());
        setCantidadProducto(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidades(UnidadDTO.obtenerValorDefecto());
    }

    public ProductoCarritoComprasDTO(final UUID id) {
        setId(id);
        setProducto(ProductoDTO.obtenerValorDefecto());
        setCarrito(CarritoComprasDTO.obtenerValorDefecto());
        setCantidadProducto(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidades(UnidadDTO.obtenerValorDefecto());
    }

    public ProductoCarritoComprasDTO(final UUID id, final ProductoDTO producto, final CarritoComprasDTO carrito, final int cantidadProducto, final UnidadDTO unidades) {
        setId(id);
        setProducto(producto);
        setCarrito(carrito);
        setCantidadProducto(cantidadProducto);
        setUnidades(unidades);
    }

    public static ProductoCarritoComprasDTO obtenerValorDefecto() {
        return new ProductoCarritoComprasDTO();
    }

    public static ProductoCarritoComprasDTO obtenerValorDefecto(final ProductoCarritoComprasDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public ProductoCarritoComprasDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public ProductoCarritoComprasDTO setProducto(final ProductoDTO producto) {
        this.producto = ProductoDTO.obtenerValorDefecto(producto);
        return this;
    }

    public CarritoComprasDTO getCarrito() {
        return carrito;
    }

    public ProductoCarritoComprasDTO setCarrito(final CarritoComprasDTO carrito) {
        this.carrito = CarritoComprasDTO.obtenerValorDefecto(carrito);
        return this;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public ProductoCarritoComprasDTO setCantidadProducto(final int cantidadProducto) {
        this.cantidadProducto = UtilNumero.getInstance().obtenerValorDefecto(cantidadProducto);
        return this;
    }

    public UnidadDTO getUnidades() {
        return unidades;
    }

    public ProductoCarritoComprasDTO setUnidades(final UnidadDTO unidades) {
        this.unidades = UnidadDTO.obtenerValorDefecto(unidades);
        return this;
    }
}