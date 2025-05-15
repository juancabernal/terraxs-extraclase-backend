package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class PagoDomain {

	private UUID id;
	private String codigoPago;
	private EstadoDomain estado;
	private double montoTotal;
	private String moneda;
	private LocalDateTime fechaPago;
	private PedidoDomain pedido;

	public PagoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoPago(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(EstadoDomain.obtenerValorDefecto());
		setMontoTotal(0.0);
		setMoneda(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaPago(UtilFecha.getInstance().obtenerFechaHoraActual());
		setPedido(PedidoDomain.obtenerValorDefecto());
	}

	public PagoDomain(final UUID id) {
		setId(id);
		setCodigoPago(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(EstadoDomain.obtenerValorDefecto());
		setMontoTotal(0.0);
		setMoneda(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaPago(UtilFecha.getInstance().obtenerFechaHoraActual());
		setPedido(PedidoDomain.obtenerValorDefecto());
	}

	public PagoDomain(final UUID id, final String codigoPago, final EstadoDomain estado, final double montoTotal,
					  final String moneda, final LocalDateTime fechaPago, final PedidoDomain pedido) {
		setId(id);
		setCodigoPago(codigoPago);
		setEstado(estado);
		setMontoTotal(montoTotal);
		setMoneda(moneda);
		setFechaPago(fechaPago);
		setPedido(pedido);
	}

	public static PagoDomain obtenerValorDefecto() {
		return new PagoDomain();
	}

	public static PagoDomain obtenerValorDefecto(final PagoDomain pago) {
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

	public EstadoDomain getEstado() {
		return estado;
	}

	public void setEstado(final EstadoDomain estado) {
		this.estado = EstadoDomain.obtenerValorDefecto(estado);
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

	public PedidoDomain getPedido() {
		return pedido;
	}

	public void setPedido(final PedidoDomain pedido) {
		this.pedido = PedidoDomain.obtenerValorDefecto(pedido);
	}
}
