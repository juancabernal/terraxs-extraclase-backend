package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class PedidoEntity {

    private UUID id;
    private String codigoReferencia;
    private CarritoComprasEntity carritoCompras;
    private EstadoEntity estado;
    private double valorTotal;

    public PedidoEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
        setCarritoCompras(CarritoComprasEntity.obtenerValorDefecto());
        setEstado(EstadoEntity.obtenerValorDefecto());
        setValorTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
    }

    public PedidoEntity(final UUID id) {
        setId(id);
        setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
        setCarritoCompras(CarritoComprasEntity.obtenerValorDefecto());
        setEstado(EstadoEntity.obtenerValorDefecto());
        setValorTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
    }

    public PedidoEntity(final UUID id, final String codigoReferencia, final CarritoComprasEntity carritoCompras, final EstadoEntity estado, final double valorTotal) {
        setId(id);
        setCodigoReferencia(codigoReferencia);
        setCarritoCompras(carritoCompras);
        setEstado(estado);
        setValorTotal(valorTotal);
    }

    public static PedidoEntity obtenerValorDefecto() {
        return new PedidoEntity();
    }

    public static PedidoEntity obtenerValorDefecto(final PedidoEntity entity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entity, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public void setCodigoReferencia(final String codigoReferencia) {
        this.codigoReferencia = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigoReferencia);
    }

    public CarritoComprasEntity getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(final CarritoComprasEntity carritoCompras) {
        this.carritoCompras = CarritoComprasEntity.obtenerValorDefecto(carritoCompras);
    }

    public EstadoEntity getEstado() {
        return estado;
    }

    public void setEstado(final EstadoEntity estado) {
        this.estado = EstadoEntity.obtenerValorDefecto(estado);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(final double valorTotal) {
        this.valorTotal = UtilNumero.getInstance().obtenerValorDefecto(valorTotal);
    }
}