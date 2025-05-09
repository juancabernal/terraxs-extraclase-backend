package co.edu.uco.terraxs.entity;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class DetallePagoEntity {

	private UUID id;
	private String codigoReferencia;
	private PagoEntity pago;
	private MetodoPagoEntity metodoPago;
	private double cantidadPagada;

	public DetallePagoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setPago(PagoEntity.obtenerValorDefecto());
		setMetodoPago(MetodoPagoEntity.obtenerValorDefecto());
		setCantidadPagada(0.0);
	}

	public DetallePagoEntity(final UUID id) {
		setId(id);
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setPago(PagoEntity.obtenerValorDefecto());
		setMetodoPago(MetodoPagoEntity.obtenerValorDefecto());
		setCantidadPagada(0.0);
	}

	public DetallePagoEntity(final UUID id, final String codigoReferencia, final PagoEntity pago,
							 final MetodoPagoEntity metodoPago, final double cantidadPagada) {
		setId(id);
		setCodigoReferencia(codigoReferencia);
		setPago(pago);
		setMetodoPago(metodoPago);
		setCantidadPagada(cantidadPagada);
	}

	public static DetallePagoEntity obtenerValorDefecto() {
		return new DetallePagoEntity();
	}

	public static DetallePagoEntity obtenerValorDefecto(final DetallePagoEntity detalle) {
		return UtilObjeto.getInstance().obtenerValorDefecto(detalle, obtenerValorDefecto());
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

	public PagoEntity getPago() {
		return pago;
	}

	public void setPago(final PagoEntity pago) {
		this.pago = PagoEntity.obtenerValorDefecto(pago);
	}

	public MetodoPagoEntity getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(final MetodoPagoEntity metodoPago) {
		this.metodoPago = MetodoPagoEntity.obtenerValorDefecto(metodoPago);
	}

	public double getCantidadPagada() {
		return cantidadPagada;
	}

	public void setCantidadPagada(final double cantidadPagada) {
		this.cantidadPagada = UtilNumero.getInstance().obtenerValorDefecto(cantidadPagada);
	}
}
