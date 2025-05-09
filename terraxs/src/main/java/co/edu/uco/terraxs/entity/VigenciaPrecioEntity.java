package co.edu.uco.terraxs.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class VigenciaPrecioEntity {

    private UUID id;
    private double precio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ProductoProveedorEntity productoProveedor;

    public VigenciaPrecioEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setPrecio(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setFechaInicio(UtilFecha.getInstance().obtenerFechaActual());
        setFechaFin(UtilFecha.getInstance().obtenerFechaActual());
        setProductoProveedor(ProductoProveedorEntity.obtenerValorDefecto());
    }

    public VigenciaPrecioEntity(final UUID id) {
        setId(id);
        setPrecio(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setFechaInicio(UtilFecha.getInstance().obtenerFechaActual());
        setFechaFin(UtilFecha.getInstance().obtenerFechaActual());
        setProductoProveedor(ProductoProveedorEntity.obtenerValorDefecto());
    }

    public VigenciaPrecioEntity(final UUID id, final double precio, final LocalDate fechaInicio, final LocalDate fechaFin, final ProductoProveedorEntity productoProveedor) {
        setId(id);
        setPrecio(precio);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setProductoProveedor(productoProveedor);
    }

    public static VigenciaPrecioEntity obtenerValorDefecto() {
        return new VigenciaPrecioEntity();
    }

    public static VigenciaPrecioEntity obtenerValorDefecto(final VigenciaPrecioEntity entity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entity, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(final double precio) {
        this.precio = UtilNumero.getInstance().obtenerValorDefecto(precio);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(final LocalDate fechaInicio) {
        this.fechaInicio = UtilFecha.getInstance().obtenerValorDefecto(fechaInicio);
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(final LocalDate fechaFin) {
        this.fechaFin = UtilFecha.getInstance().obtenerValorDefecto(fechaFin);
    }

    public ProductoProveedorEntity getProductoProveedor() {
        return productoProveedor;
    }

    public void setProductoProveedor(final ProductoProveedorEntity productoProveedor) {
        this.productoProveedor = ProductoProveedorEntity.obtenerValorDefecto(productoProveedor);
    }
}
