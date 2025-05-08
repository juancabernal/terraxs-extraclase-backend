package co.edu.uco.terraxs.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class CarritoComprasDTO {

	private UUID id;
	private String codigoCarrito;
	private ClienteTiendaDTO cliente;
	private EstadoDTO estado;
	private LocalDateTime fechaHoraCreacion;

	public CarritoComprasDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigoCarrito(UtilTexto.getInstance().obtenerValorDefecto());
		setCliente(ClienteTiendaDTO.obtenerValorDefecto());
		setEstado(EstadoDTO.obtenerValorDefecto());
		setFechaHoraCreacion(UtilFecha.getInstance().obtenerFechaHoraActual());
	}

	public CarritoComprasDTO(final UUID id, final String codigoCarrito, final ClienteTiendaDTO cliente,
			final EstadoDTO estado, final LocalDateTime fechaHoraCreacion) {
		setId(id);
		setCodigoCarrito(codigoCarrito);
		setCliente(cliente);
		setEstado(estado);
		setFechaHoraCreacion(fechaHoraCreacion);
	}

	private CarritoComprasDTO(final Builder builder) {
		setId(builder.id);
		setCodigoCarrito(builder.codigoCarrito);
		setCliente(builder.cliente);
		setEstado(builder.estado);
		setFechaHoraCreacion(builder.fechaHoraCreacion);
	}

	public static CarritoComprasDTO obtenerValorDefecto() {
		return new CarritoComprasDTO();
	}

	public static CarritoComprasDTO obtenerValorDefecto(final CarritoComprasDTO dto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
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

	public ClienteTiendaDTO getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteTiendaDTO cliente) {
		this.cliente = ClienteTiendaDTO.obtenerValorDefecto(cliente);
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(final EstadoDTO estado) {
		this.estado = EstadoDTO.obtenerValorDefecto(estado);
	}

	public LocalDateTime getFechaHoraCreacion() {
		return fechaHoraCreacion;
	}

	public void setFechaHoraCreacion(final LocalDateTime fechaHoraCreacion) {
		this.fechaHoraCreacion = UtilFecha.getInstance().obtenerValorDefecto(fechaHoraCreacion);
	}

	@Override
	public String toString() {
		return "CarritoComprasDTO [id=" + id + ", codigoCarrito=" + codigoCarrito + ", cliente=" + cliente
				+ ", estado=" + estado + ", fechaHoraCreacion=" + fechaHoraCreacion + "]";
	}

	public static class Builder {

		private UUID id;
		private String codigoCarrito;
		private ClienteTiendaDTO cliente;
		private EstadoDTO estado;
		private LocalDateTime fechaHoraCreacion;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder codigoCarrito(final String codigoCarrito) {
			this.codigoCarrito = codigoCarrito;
			return this;
		}

		public Builder cliente(final ClienteTiendaDTO cliente) {
			this.cliente = cliente;
			return this;
		}

		public Builder estado(final EstadoDTO estado) {
			this.estado = estado;
			return this;
		}

		public Builder fechaHoraCreacion(final LocalDateTime fechaHoraCreacion) {
			this.fechaHoraCreacion = fechaHoraCreacion;
			return this;
		}

		public CarritoComprasDTO crear() {
			return new CarritoComprasDTO(this);
		}
	}
}
