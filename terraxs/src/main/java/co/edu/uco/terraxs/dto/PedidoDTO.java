package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class PedidoDTO {

    private UUID id;
    private String codigoReferencia;
    private CarritoComprasDTO carritoCompras;
    private EstadoDTO estado;
    private double valorTotal;

    public PedidoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
        setCarritoCompras(CarritoComprasDTO.obtenerValorDefecto());
        setEstado(EstadoDTO.obtenerValorDefecto());
        setValorTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
    }

    public PedidoDTO(final UUID id) {
        setId(id);
        setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
        setCarritoCompras(CarritoComprasDTO.obtenerValorDefecto());
        setEstado(EstadoDTO.obtenerValorDefecto());
        setValorTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
    }

    public PedidoDTO(final UUID id, final String codigoReferencia, final CarritoComprasDTO carritoCompras, final EstadoDTO estado, final double valorTotal) {
        setId(id);
        setCodigoReferencia(codigoReferencia);
        setCarritoCompras(carritoCompras);
        setEstado(estado);
        setValorTotal(valorTotal);
    }

    public static PedidoDTO obtenerValorDefecto() {
        return new PedidoDTO();
    }

    public static PedidoDTO obtenerValorDefecto(final PedidoDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public PedidoDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public PedidoDTO setCodigoReferencia(final String codigoReferencia) {
        this.codigoReferencia = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigoReferencia);
        return this;
    }

    public CarritoComprasDTO getCarritoCompras() {
        return carritoCompras;
    }

    public PedidoDTO setCarritoCompras(final CarritoComprasDTO carritoCompras) {
        this.carritoCompras = CarritoComprasDTO.obtenerValorDefecto(carritoCompras);
        return this;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    public PedidoDTO setEstado(final EstadoDTO estado) {
        this.estado = EstadoDTO.obtenerValorDefecto(estado);
        return this;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public PedidoDTO setValorTotal(final double valorTotal) {
        this.valorTotal = UtilNumero.getInstance().obtenerValorDefecto(valorTotal);
        return this;
    }
}