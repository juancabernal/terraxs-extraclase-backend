package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public class ClienteTiendaDomain {

	private UUID id;
	private ClienteDomain cliente;
	private TiendaDomain tienda;
	private LocalDate fechaRegistro;

	public ClienteTiendaDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setCliente(ClienteDomain.obtenerValorDefecto());
		setTienda(TiendaDomain.obtenerValorDefecto());
		setFechaRegistro(UtilFecha.getInstance().obtenerFechaActual());
	}

	public ClienteTiendaDomain(final UUID id) {
		setId(id);
		setCliente(ClienteDomain.obtenerValorDefecto());
		setTienda(TiendaDomain.obtenerValorDefecto());
		setFechaRegistro(UtilFecha.getInstance().obtenerFechaActual());
	}
	
	public ClienteTiendaDomain(final UUID id, final ClienteDomain cliente, final TiendaDomain tienda, final LocalDate fechaRegistro) {
		setId(id);
		setCliente(cliente);
		setTienda(tienda);
		setFechaRegistro(fechaRegistro);
	}

	public static ClienteTiendaDomain obtenerValorDefecto() {
		return new ClienteTiendaDomain();
	}

	public static ClienteTiendaDomain obtenerValorDefecto(final ClienteTiendaDomain clienteTienda) {
		return UtilObjeto.getInstance().obtenerValorDefecto(clienteTienda, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteDomain getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDomain cliente) {
		this.cliente = ClienteDomain.obtenerValorDefecto(cliente);
	}

	public TiendaDomain getTienda() {
		return tienda;
	}

	public void setTienda(TiendaDomain tienda) {
		this.tienda = TiendaDomain.obtenerValorDefecto(tienda);
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = UtilFecha.getInstance().obtenerValorDefecto(fechaRegistro);
	}
}
