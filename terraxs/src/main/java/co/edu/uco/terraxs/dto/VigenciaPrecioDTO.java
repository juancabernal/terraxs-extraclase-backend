package co.edu.uco.terraxs.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class VigenciaPrecioDTO {

    private UUID id;
    private double precio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ProductoProveedorDTO productoProveedor;

    public VigenciaPrecioDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setPrecio(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setFechaInicio(UtilFecha.getInstance().obtenerFechaActual());
        setFechaFin(UtilFecha.getInstance().obtenerFechaActual());
        setProductoProveedor(ProductoProveedorDTO.obtenerValorDefecto());
    }

    public VigenciaPrecioDTO(final UUID id) {
        setId(id);
        setPrecio(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setFechaInicio(UtilFecha.getInstance().obtenerFechaActual());
        setFechaFin(UtilFecha.getInstance().obtenerFechaActual());
        setProductoProveedor(ProductoProveedorDTO.obtenerValorDefecto());
    }

    public VigenciaPrecioDTO(final UUID id, final double precio, final LocalDate fechaInicio, final LocalDate fechaFin, final ProductoProveedorDTO productoProveedor) {
        setId(id);
        setPrecio(precio);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setProductoProveedor(productoProveedor);
    }

    public static VigenciaPrecioDTO obtenerValorDefecto() {
        return new VigenciaPrecioDTO();
    }

    public static VigenciaPrecioDTO obtenerValorDefecto(final VigenciaPrecioDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public VigenciaPrecioDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public double getPrecio() {
        return precio;
    }

    public VigenciaPrecioDTO setPrecio(final double precio) {
        this.precio = UtilNumero.getInstance().obtenerValorDefecto(precio);
        return this;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public VigenciaPrecioDTO setFechaInicio(final LocalDate fechaInicio) {
        this.fechaInicio = UtilFecha.getInstance().obtenerValorDefecto(fechaInicio);
        return this;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public VigenciaPrecioDTO setFechaFin(final LocalDate fechaFin) {
        this.fechaFin = UtilFecha.getInstance().obtenerValorDefecto(fechaFin);
        return this;
    }

    public ProductoProveedorDTO getProductoProveedor() {
        return productoProveedor;
    }

    public VigenciaPrecioDTO setProductoProveedor(final ProductoProveedorDTO productoProveedor) {
        this.productoProveedor = ProductoProveedorDTO.obtenerValorDefecto(productoProveedor);
        return this;
    }
}