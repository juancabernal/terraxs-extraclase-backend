package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.*;

public final class DetallePagoDomain {

	private UUID id;
	private String codigoReferencia;
	private PagoDomain pago;
	private MetodoPagoDomain metodoPago;
	private double cantidadPagada;

	public DetallePagoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setPago(PagoDomain.obtenerValorDefecto());
		setMetodoPago(MetodoPagoDomain.obtenerValorDefecto());
		setCantidadPagada(0.0);
	}

	public DetallePagoDomain(final UUID id) {
		setId(id);
		setCodigoReferencia(UtilTexto.getInstance().obtenerValorDefecto());
		setPago(PagoDomain.obtenerValorDefecto());
		setMetodoPago(MetodoPagoDomain.obtenerValorDefecto());
		setCantidadPagada(0.0);
	}

	public DetallePagoDomain(final UUID id, final String codigoReferencia, final PagoDomain pago,
							 final MetodoPagoDomain metodoPago, final double cantidadPagada) {
		setId(id);
		setCodigoReferencia(codigoReferencia);
		setPago(pago);
		setMetodoPago(metodoPago);
		setCantidadPagada(cantidadPagada);
	}

	public static DetallePagoDomain obtenerValorDefecto() {
		return new DetallePagoDomain();
	}

	public static DetallePagoDomain obtenerValorDefecto(final DetallePagoDomain detalle) {
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

	public PagoDomain getPago() {
		return pago;
	}

	public void setPago(final PagoDomain pago) {
		this.pago = PagoDomain.obtenerValorDefecto(pago);
	}

	public MetodoPagoDomain getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(final MetodoPagoDomain metodoPago) {
		this.metodoPago = MetodoPagoDomain.obtenerValorDefecto(metodoPago);
	}

	public double getCantidadPagada() {
		return cantidadPagada;
	}

	public void setCantidadPagada(final double cantidadPagada) {
		this.cantidadPagada = UtilNumero.getInstance().obtenerValorDefecto(cantidadPagada);
	}
}
