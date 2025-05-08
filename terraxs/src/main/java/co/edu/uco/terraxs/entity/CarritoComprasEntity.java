package co.edu.uco.terraxs.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class CarritoComprasEntity {

	private UUID id;
	private String codigoCarrito;
	private ClienteTiendaEntity cliente;
	private EstadoEntity estado;
	private LocalDateTime fechaHoraCreacion;

	public CarritoComprasEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoCarrito(UtilTexto.getInstance().obtenerValorDefecto());
		setCliente(ClienteTiendaEntity.obtenerValorDefecto());
		setEstado(EstadoEntity.obtenerValorDefecto());
		setFechaHoraCreacion(UtilFecha.getInstance().obtenerFechaHoraActual());
	}

	public CarritoComprasEntity(final UUID id) {
		setId(id);
		setCodigoCarrito(UtilTexto.getInstance().obtenerValorDefecto());
		setCliente(ClienteTiendaEntity.obtenerValorDefecto());
		setEstado(EstadoEntity.obtenerValorDefecto());
		setFechaHoraCreacion(UtilFecha.getInstance().obtenerFechaHoraActual());
	}

	public CarritoComprasEntity(final UUID id, final String codigoCarrito, final ClienteTiendaEntity cliente,
			final EstadoEntity estado, final LocalDateTime fechaHoraCreacion) {
		setId(id);
		setCodigoCarrito(codigoCarrito);
		setCliente(cliente);
		setEstado(estado);
		setFechaHoraCreacion(fechaHoraCreacion);
	}

	public static CarritoComprasEntity obtenerValorDefecto() {
		return new CarritoComprasEntity();
	}

	public static CarritoComprasEntity obtenerValorDefecto(final CarritoComprasEntity carrito) {
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

	public ClienteTiendaEntity getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteTiendaEntity cliente) {
		this.cliente = ClienteTiendaEntity.obtenerValorDefecto(cliente);
	}

	public EstadoEntity getEstado() {
		return estado;
	}

	public void setEstado(final EstadoEntity estado) {
		this.estado = EstadoEntity.obtenerValorDefecto(estado);
	}

	public LocalDateTime getFechaHoraCreacion() {
		return fechaHoraCreacion;
	}

	public void setFechaHoraCreacion(final LocalDateTime fechaHoraCreacion) {
		this.fechaHoraCreacion = UtilFecha.getInstance().obtenerValorDefecto(fechaHoraCreacion);
	}
}
