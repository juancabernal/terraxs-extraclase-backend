package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;





public final class ProductoDTO {

    private UUID id;
    private String nombre;
    private String descripcion;
    private double precioSugerido;
    private int cantidad;
    public UnidadDTO unidad;
    public CategoriaProductoDTO categoria;

    public ProductoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecioSugerido(UtilNumero.getInstance().obtenerValorDefecto(0.0));
        setCantidad(UtilNumero.getInstance().obtenerValorDefecto(0));
        setUnidad(UnidadDTO.obtenerValorDefecto());
        setCategoria(CategoriaProductoDTO.obtenerValorDefecto());
    }

    public ProductoDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecioSugerido(0.0);
        setCantidad(0);
        setUnidad(UnidadDTO.obtenerValorDefecto());
        setCategoria(CategoriaProductoDTO.obtenerValorDefecto());
    }

    public ProductoDTO(final UUID id, final String nombre, final String descripcion, final double precioSugerido,
                          final int cantidad, final UnidadDTO unidad, final CategoriaProductoDTO categoria) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecioSugerido(precioSugerido);
        setCantidad(cantidad);
        setUnidad(unidad);
        setCategoria(categoria);
    }

    public static ProductoDTO obtenerValorDefecto() {
        return new ProductoDTO();
    }

    public static ProductoDTO obtenerValorDefecto(final ProductoDTO producto) {
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

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(final UnidadDTO unidad) {
        this.unidad = UnidadDTO.obtenerValorDefecto(unidad);
    }

    public CategoriaProductoDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(final CategoriaProductoDTO categoria) {
        this.categoria = CategoriaProductoDTO.obtenerValorDefecto(categoria);
    }


    
}

