package co.edu.uco.terraxs.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class PagoEntity {

	private UUID id;
	private String codigoPago;
	private EstadoEntity estado;
	private double montoTotal;
	private String moneda;
	private LocalDateTime fechaPago;
	private PedidoEntity pedido;

	public PagoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoPago(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(EstadoEntity.obtenerValorDefecto());
		setMontoTotal(0.0);
		setMoneda(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaPago(UtilFecha.getInstance().obtenerFechaHoraActual());
		setPedido(PedidoEntity.obtenerValorDefecto());
	}

	public PagoEntity(final UUID id) {
		setId(id);
		setCodigoPago(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(EstadoEntity.obtenerValorDefecto());
		setMontoTotal(0.0);
		setMoneda(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaPago(UtilFecha.getInstance().obtenerFechaHoraActual());
		setPedido(PedidoEntity.obtenerValorDefecto());
	}

	public PagoEntity(final UUID id, final String codigoPago, final EstadoEntity estado, final double montoTotal,
					  final String moneda, final LocalDateTime fechaPago, final PedidoEntity pedido) {
		setId(id);
		setCodigoPago(codigoPago);
		setEstado(estado);
		setMontoTotal(montoTotal);
		setMoneda(moneda);
		setFechaPago(fechaPago);
		setPedido(pedido);
	}

	public static PagoEntity obtenerValorDefecto() {
		return new PagoEntity();
	}

	public static PagoEntity obtenerValorDefecto(final PagoEntity pago) {
		return UtilObjeto.getInstance().obtenerValorDefecto(pago, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(final String codigoPago) {
		this.codigoPago = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigoPago);
	}

	public EstadoEntity getEstado() {
		return estado;
	}

	public void setEstado(final EstadoEntity estado) {
		this.estado = EstadoEntity.obtenerValorDefecto(estado);
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(final double montoTotal) {
		this.montoTotal = UtilNumero.getInstance().obtenerValorDefecto(montoTotal);
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(final String moneda) {
		this.moneda = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(moneda);
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(final LocalDateTime fechaPago) {
		this.fechaPago = UtilFecha.getInstance().obtenerValorDefecto(fechaPago);
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(final PedidoEntity pedido) {
		this.pedido = PedidoEntity.obtenerValorDefecto(pedido);
	}
}
