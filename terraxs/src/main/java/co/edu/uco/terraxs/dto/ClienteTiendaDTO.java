package co.edu.uco.terraxs.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class ClienteTiendaDTO {

	private UUID id;
	private ClienteDTO cliente;
	private TiendaDTO tienda;
	private LocalDate fechaRegistro;

	public ClienteTiendaDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setCliente(ClienteDTO.obtenerValorDefecto());
		setTienda(TiendaDTO.obtenerValorDefecto());
		setFechaRegistro(UtilFecha.getInstance().obtenerFechaActual());
	}
	
	public ClienteTiendaDTO(final UUID id) {
		setId(id);
		setCliente(ClienteDTO.obtenerValorDefecto());
		setTienda(TiendaDTO.obtenerValorDefecto());
		setFechaRegistro(UtilFecha.getInstance().obtenerFechaActual());
	}
	
	public ClienteTiendaDTO(final UUID id, final ClienteDTO cliente, final TiendaDTO tienda, final LocalDate fechaRegistro) {
		setId(id);
		setCliente(cliente);
		setTienda(tienda);
		setFechaRegistro(fechaRegistro);
	}

	public static ClienteTiendaDTO obtenerValorDefecto() {
		return new ClienteTiendaDTO();
	}
	
	public static ClienteTiendaDTO obtenerValorDefecto(final ClienteTiendaDTO clienteTienda) {
		return UtilObjeto.getInstance().obtenerValorDefecto(clienteTienda, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public ClienteTiendaDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public ClienteTiendaDTO setCliente(final ClienteDTO cliente) {
		this.cliente = UtilObjeto.getInstance().obtenerValorDefecto(cliente, ClienteDTO.obtenerValorDefecto());
		return this;
	}

	public TiendaDTO getTienda() {
		return tienda;
	}

	public ClienteTiendaDTO setTienda(final TiendaDTO tienda) {
		this.tienda = UtilObjeto.getInstance().obtenerValorDefecto(tienda, TiendaDTO.obtenerValorDefecto());
		return this;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(final LocalDate fechaRegistro) {
		this.fechaRegistro = UtilFecha.getInstance().obtenerValorDefecto(fechaRegistro);
	}
}
