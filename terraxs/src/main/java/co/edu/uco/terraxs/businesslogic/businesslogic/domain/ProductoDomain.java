package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;




public final class ProductoDomain {

    private UUID id;
    private String nombre;
    private String descripcion;
    private double precioSugerido;
    private int cantidad;
    public UnidadDomain unidad;
    public CategoriaProductoDomain categoria;

    public ProductoDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecioSugerido(0.0);
        setCantidad(0);
        setUnidad(UnidadDomain.obtenerValorDefecto());
        setCategoria(CategoriaProductoDomain.obtenerValorDefecto());
    }

    public ProductoDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecioSugerido(0.0);
        setCantidad(0);
        setUnidad(UnidadDomain.obtenerValorDefecto());
        setCategoria(CategoriaProductoDomain.obtenerValorDefecto());
    }

    public ProductoDomain(final UUID id, final String nombre, final String descripcion, final double precioSugerido,
                          final int cantidad, final UnidadDomain unidad, final CategoriaProductoDomain categoria) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecioSugerido(precioSugerido);
        setCantidad(cantidad);
        setUnidad(unidad);
        setCategoria(categoria);
    }

    public static ProductoDomain obtenerValorDefecto() {
        return new ProductoDomain();
    }

    public static ProductoDomain obtenerValorDefecto(final ProductoDomain producto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(producto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
    }

    public double getPrecioSugerido() {
        return precioSugerido;
    }

    public void setPrecioSugerido(final double precioSugerido) {
        this.precioSugerido = precioSugerido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(final int cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadDomain getUnidad() {
        return unidad;
    }

    public void setUnidad(final UnidadDomain unidad) {
        this.unidad = UnidadDomain.obtenerValorDefecto(unidad);
    }

    public CategoriaProductoDomain getCategoria() {
        return categoria;
    }

    public void setCategoria(final CategoriaProductoDomain categoria) {
        this.categoria = CategoriaProductoDomain.obtenerValorDefecto(categoria);
    }


    
}

