package co.edu.uco.terraxs.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public class ClienteTiendaEntity {

	private UUID id;
	private ClienteEntity cliente;
	private TiendaEntity tienda;
	private LocalDate fechaRegistro;

	public ClienteTiendaEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setCliente(ClienteEntity.obtenerValorDefecto());
		setTienda(TiendaEntity.obtenerValorDefecto());
		setFechaRegistro(UtilFecha.obtenerFechaActual());
	}

	public ClienteTiendaEntity(final UUID id) {
		setId(id);
		setCliente(ClienteEntity.obtenerValorDefecto());
		setTienda(TiendaEntity.obtenerValorDefecto());
		setFechaRegistro(UtilFecha.obtenerFechaActual());
	}
	
	public ClienteTiendaEntity(final UUID id, final ClienteEntity cliente, final TiendaEntity tienda, final LocalDate fechaRegistro) {
		setId(id);
		setCliente(cliente);
		setTienda(tienda);
		setFechaRegistro(fechaRegistro);
	}

	public static ClienteTiendaEntity obtenerValorDefecto() {
		return new ClienteTiendaEntity();
	}

	public static ClienteTiendaEntity obtenerValorDefecto(final ClienteTiendaEntity clienteTienda) {
		return UtilObjeto.getInstance().obtenerValorDefecto(clienteTienda, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = ClienteEntity.obtenerValorDefecto(cliente);
	}

	public TiendaEntity getTienda() {
		return tienda;
	}

	public void setTienda(TiendaEntity tienda) {
		this.tienda = TiendaEntity.obtenerValorDefecto(tienda);
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = UtilFecha.obtenerValorDefecto(fechaRegistro);
	}
}
