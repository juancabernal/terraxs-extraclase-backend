package co.edu.uco.terraxs.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class PagoDTO {

	private UUID id;
	private String codigoPago;
	private EstadoDTO estado;
	private double montoTotal;
	private String moneda;
	private LocalDateTime fechaPago;
	private PedidoDTO pedido;

	public PagoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoPago(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(EstadoDTO.obtenerValorDefecto());
		setMontoTotal(0.0);
		setMoneda(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaPago(UtilFecha.getInstance().obtenerFechaHoraActual());
		setPedido(PedidoDTO.obtenerValorDefecto());
	}

	private PagoDTO(final Builder builder) {
		setId(builder.id);
		setCodigoPago(builder.codigoPago);
		setEstado(builder.estado);
		setMontoTotal(builder.montoTotal);
		setMoneda(builder.moneda);
		setFechaPago(builder.fechaPago);
		setPedido(builder.pedido);
	}

	public static PagoDTO obtenerValorDefecto() {
		return new PagoDTO();
	}

	public static PagoDTO obtenerValorDefecto(final PagoDTO pago) {
		return UtilObjeto.getInstance().obtenerValorDefecto(pago, obtenerValorDefecto());
	}

	public UUID getId() { return id; }

	public void setId(final UUID id) { this.id = UtilUUID.obtenerValorDefecto(id); }

	public String getCodigoPago() { return codigoPago; }

	public void setCodigoPago(final String codigoPago) { this.codigoPago = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigoPago); }

	public EstadoDTO getEstado() { return estado; }

	public void setEstado(final EstadoDTO estado) { this.estado = EstadoDTO.obtenerValorDefecto(estado); }

	public double getMontoTotal() { return montoTotal; }

	public void setMontoTotal(final double montoTotal) { this.montoTotal = UtilNumero.getInstance().obtenerValorDefecto(montoTotal); }

	public String getMoneda() { return moneda; }

	public void setMoneda(final String moneda) { this.moneda = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(moneda); }

	public LocalDateTime getFechaPago() { return fechaPago; }

	public void setFechaPago(final LocalDateTime fechaPago) { this.fechaPago = UtilFecha.getInstance().obtenerValorDefecto(fechaPago); }

	public PedidoDTO getPedido() { return pedido; }

	public void setPedido(final PedidoDTO pedido) { this.pedido = PedidoDTO.obtenerValorDefecto(pedido); }

	public static class Builder {
		private UUID id;
		private String codigoPago;
		private EstadoDTO estado;
		private double montoTotal;
		private String moneda;
		private LocalDateTime fechaPago;
		private PedidoDTO pedido;

		public Builder id(final UUID id) { 
			this.id = id; 
			return this; 
		}

		public Builder codigoPago(final String codigoPago) { 
			this.codigoPago = codigoPago; 
			return this; 
		}

		public Builder estado(final EstadoDTO estado) {
			this.estado = estado; 
			return this; 
		}

		public Builder montoTotal(final double montoTotal) { 
			this.montoTotal = montoTotal; 
			return this; 
		}

		public Builder moneda(final String moneda) { 
			this.moneda = moneda; 
			return this; 
		}

		public Builder fechaPago(final LocalDateTime fechaPago) { 
			this.fechaPago = fechaPago; 
			return this; 
		}

		public Builder pedido(final PedidoDTO pedido) {
			this.pedido = pedido; 
			return this; 
		}

		public PagoDTO crear() { 
			return new PagoDTO(this); 
		}
	}
}
