package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;


import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilNumero;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class PedidoDomain {

    private UUID id;
    private String codigoReferencia;
    private CarritoComprasDomain carritoCompras;
    private EstadoDomain estado;
    private double valorTotal;

    public PedidoDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
        setCarritoCompras(CarritoComprasDomain.obtenerValorDefecto());
        setEstado(EstadoDomain.obtenerValorDefecto());
        setValorTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
    }

    public PedidoDomain(final UUID id) {
        setId(id);
        setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
        setCarritoCompras(CarritoComprasDomain.obtenerValorDefecto());
        setEstado(EstadoDomain.obtenerValorDefecto());
        setValorTotal(UtilNumero.getInstance().obtenerValorDefecto(0.0));
    }

    public PedidoDomain(final UUID id, final String codigoReferencia, final CarritoComprasDomain carritoCompras, final EstadoDomain estado, final double valorTotal) {
        setId(id);
        setCodigoReferencia(codigoReferencia);
        setCarritoCompras(carritoCompras);
        setEstado(estado);
        setValorTotal(valorTotal);
    }

    public static PedidoDomain obtenerValorDefecto() {
        return new PedidoDomain();
    }

    public static PedidoDomain obtenerValorDefecto(final PedidoDomain entity) {
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

    public CarritoComprasDomain getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(final CarritoComprasDomain carritoCompras) {
        this.carritoCompras = CarritoComprasDomain.obtenerValorDefecto(carritoCompras);
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public void setEstado(final EstadoDomain estado) {
        this.estado = EstadoDomain.obtenerValorDefecto(estado);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(final double valorTotal) {
        this.valorTotal = UtilNumero.getInstance().obtenerValorDefecto(valorTotal);
    }
}