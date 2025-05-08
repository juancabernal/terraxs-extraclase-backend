package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class ProductoProveedorDTO {

    private UUID id;
    private ProveedorDTO proveedor;
    private ProductoDTO producto;
    private double precioFinal;
    private int stock;
    private UnidadDTO unidad;

    public ProductoProveedorDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setProveedor(ProveedorDTO.obtenerValorDefecto());
        setProducto(ProductoDTO.obtenerValorDefecto());
        setPrecioFinal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setStock(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadDTO.obtenerValorDefecto());
    }

    public ProductoProveedorDTO(final UUID id) {
        setId(id);
        setProveedor(ProveedorDTO.obtenerValorDefecto());
        setProducto(ProductoDTO.obtenerValorDefecto());
        setPrecioFinal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setStock(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadDTO.obtenerValorDefecto());
    }

    public ProductoProveedorDTO(final UUID id, final ProveedorDTO proveedor, final ProductoDTO producto, final double precioFinal, final int stock, final UnidadDTO unidad) {
        setId(id);
        setProveedor(proveedor);
        setProducto(producto);
        setPrecioFinal(precioFinal);
        setStock(stock);
        setUnidad(unidad);
    }

    public static ProductoProveedorDTO obtenerValorDefecto() {
        return new ProductoProveedorDTO();
    }

    public static ProductoProveedorDTO obtenerValorDefecto(final ProductoProveedorDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public ProductoProveedorDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public ProductoProveedorDTO setProveedor(final ProveedorDTO proveedor) {
        this.proveedor = ProveedorDTO.obtenerValorDefecto(proveedor);
        return this;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public ProductoProveedorDTO setProducto(final ProductoDTO producto) {
        this.producto = ProductoDTO.obtenerValorDefecto(producto);
        return this;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public ProductoProveedorDTO setPrecioFinal(final double precioFinal) {
        this.precioFinal = UtilNumero.getInstance().obtenerValorDefecto(precioFinal);
        return this;
    }

    public int getStock() {
        return stock;
    }

    public ProductoProveedorDTO setStock(final int stock) {
        this.stock = UtilNumero.getInstance().obtenerValorDefecto(stock);
        return this;
    }

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public ProductoProveedorDTO setUnidad(final UnidadDTO unidad) {
        this.unidad = UnidadDTO.obtenerValorDefecto(unidad);
        return this;
    }
}