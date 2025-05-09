package co.edu.uco.terraxs.dto;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class DetallePagoDTO {

	private UUID id;
	private String codigoReferencia;
	private PagoDTO pago;
	private MetodoPagoDTO metodoPago;
	private double cantidadPagada;

	public DetallePagoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setPago(PagoDTO.obtenerValorDefecto());
		setMetodoPago(MetodoPagoDTO.obtenerValorDefecto());
		setCantidadPagada(0.0);
	}

	private DetallePagoDTO(final Builder builder) {
		setId(builder.id);
		setCodigoReferencia(builder.codigoReferencia);
		setPago(builder.pago);
		setMetodoPago(builder.metodoPago);
		setCantidadPagada(builder.cantidadPagada);
	}

	public static DetallePagoDTO obtenerValorDefecto() {
		return new DetallePagoDTO();
	}

	public static DetallePagoDTO obtenerValorDefecto(final DetallePagoDTO detalle) {
		return UtilObjeto.getInstance().obtenerValorDefecto(detalle, obtenerValorDefecto());
	}

	public UUID getId() { return id; }

	public void setId(final UUID id) { this.id = UtilUUID.obtenerValorDefecto(id); }

	public String getCodigoReferencia() { return codigoReferencia; }

	public void setCodigoReferencia(final String codigoReferencia) {
		this.codigoReferencia = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigoReferencia);
	}

	public PagoDTO getPago() { return pago; }

	public void setPago(final PagoDTO pago) { this.pago = PagoDTO.obtenerValorDefecto(pago); }

	public MetodoPagoDTO getMetodoPago() { return metodoPago; }

	public void setMetodoPago(final MetodoPagoDTO metodoPago) {
		this.metodoPago = MetodoPagoDTO.obtenerValorDefecto(metodoPago);
	}

	public double getCantidadPagada() { return cantidadPagada; }

	public void setCantidadPagada(final double cantidadPagada) {
		this.cantidadPagada = UtilNumero.getInstance().obtenerValorDefecto(cantidadPagada);
	}

	public static class Builder {
		private UUID id;
		private String codigoReferencia;
		private PagoDTO pago;
		private MetodoPagoDTO metodoPago;
		private double cantidadPagada;

		public Builder id(final UUID id) { 
			this.id = id; 
			return this; 
		}

		public Builder codigoReferencia(final String codigoReferencia) { 
			this.codigoReferencia = codigoReferencia;
			return this;
		}

		public Builder pago(final PagoDTO pago) { 
			this.pago = pago; 
			return this; 
		}

		public Builder metodoPago(final MetodoPagoDTO metodoPago) {
			this.metodoPago = metodoPago;
			return this; 
		}

		public Builder cantidadPagada(final double cantidadPagada) {
			this.cantidadPagada = cantidadPagada; 
			return this;
		}

		public DetallePagoDTO crear() { 
			return new DetallePagoDTO(this); 
		}
	}
}
