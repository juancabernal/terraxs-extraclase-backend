package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class VigenciaPrecioDomain {

    private UUID id;
    private double precio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ProductoProveedorDomain productoProveedor;

    public VigenciaPrecioDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setPrecio(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setFechaInicio(UtilFecha.getInstance().obtenerFechaActual());
        setFechaFin(UtilFecha.getInstance().obtenerFechaActual());
        setProductoProveedor(ProductoProveedorDomain.obtenerValorDefecto());
    }

    public VigenciaPrecioDomain(final UUID id) {
        setId(id);
        setPrecio(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setFechaInicio(UtilFecha.getInstance().obtenerFechaActual());
        setFechaFin(UtilFecha.getInstance().obtenerFechaActual());
        setProductoProveedor(ProductoProveedorDomain.obtenerValorDefecto());
    }

    public VigenciaPrecioDomain(final UUID id, final double precio, final LocalDate fechaInicio, final LocalDate fechaFin, final ProductoProveedorDomain productoProveedor) {
        setId(id);
        setPrecio(precio);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setProductoProveedor(productoProveedor);
    }

    public static VigenciaPrecioDomain obtenerValorDefecto() {
        return new VigenciaPrecioDomain();
    }

    public static VigenciaPrecioDomain obtenerValorDefecto(final VigenciaPrecioDomain entity) {
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

    public ProductoProveedorDomain getProductoProveedor() {
        return productoProveedor;
    }

    public void setProductoProveedor(final ProductoProveedorDomain productoProveedor) {
        this.productoProveedor = ProductoProveedorDomain.obtenerValorDefecto(productoProveedor);
    }
}
