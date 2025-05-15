package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class CarritoComprasDomain {

	private UUID id;
	private String codigoCarrito;
	private ClienteTiendaDomain cliente;
	private EstadoDomain estado;
	private LocalDateTime fechaHoraCreacion;

	public CarritoComprasDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoCarrito(UtilTexto.getInstance().obtenerValorDefecto());
		setCliente(ClienteTiendaDomain.obtenerValorDefecto());
		setEstado(EstadoDomain.obtenerValorDefecto());
		setFechaHoraCreacion(UtilFecha.getInstance().obtenerFechaHoraActual());
	}

	public CarritoComprasDomain(final UUID id) {
		setId(id);
		setCodigoCarrito(UtilTexto.getInstance().obtenerValorDefecto());
		setCliente(ClienteTiendaDomain.obtenerValorDefecto());
		setEstado(EstadoDomain.obtenerValorDefecto());
		setFechaHoraCreacion(UtilFecha.getInstance().obtenerFechaHoraActual());
	}

	public CarritoComprasDomain(final UUID id, final String codigoCarrito, final ClienteTiendaDomain cliente,
			final EstadoDomain estado, final LocalDateTime fechaHoraCreacion) {
		setId(id);
		setCodigoCarrito(codigoCarrito);
		setCliente(cliente);
		setEstado(estado);
		setFechaHoraCreacion(fechaHoraCreacion);
	}

	public static CarritoComprasDomain obtenerValorDefecto() {
		return new CarritoComprasDomain();
	}

	public static CarritoComprasDomain obtenerValorDefecto(final CarritoComprasDomain carrito) {
		return UtilObjeto.getInstance().obtenerValorDefecto(carrito, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getCodigoCarrito() {
		return codigoCarrito;
	}

	public void setCodigoCarrito(final String codigoCarrito) {
		this.codigoCarrito = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigoCarrito);
	}

	public ClienteTiendaDomain getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteTiendaDomain cliente) {
		this.cliente = ClienteTiendaDomain.obtenerValorDefecto(cliente);
	}

	public EstadoDomain getEstado() {
		return estado;
	}

	public void setEstado(final EstadoDomain estado) {
		this.estado = EstadoDomain.obtenerValorDefecto(estado);
	}

	public LocalDateTime getFechaHoraCreacion() {
		return fechaHoraCreacion;
	}

	public void setFechaHoraCreacion(final LocalDateTime fechaHoraCreacion) {
		this.fechaHoraCreacion = UtilFecha.getInstance().obtenerValorDefecto(fechaHoraCreacion);
	}
}
