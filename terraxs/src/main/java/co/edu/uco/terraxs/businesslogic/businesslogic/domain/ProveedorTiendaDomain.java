package co.edu.uco.terraxs.businesslogic.businesslogic.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class ProveedorTiendaDomain {
	

	private UUID id;
	private ProveedorDomain proveedor;
	private TiendaDomain tienda;
	private LocalDate fechaAsociacion;

	public ProveedorTiendaDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setProveedor(ProveedorDomain.obtenerValorDefecto());
		setTienda(TiendaDomain.obtenerValorDefecto());
		setFechaAsociacion(UtilFecha.getInstance().obtenerFechaActual());
	}
	
	public ProveedorTiendaDomain(final UUID id) {
		setId(id);
		setProveedor(ProveedorDomain.obtenerValorDefecto());
		setTienda(TiendaDomain.obtenerValorDefecto());
		setFechaAsociacion(UtilFecha.getInstance().obtenerFechaActual());
	}

	public ProveedorTiendaDomain(final UUID id, final ProveedorDomain proveedor, final TiendaDomain tienda, final LocalDate fechaAsociacion) {
		setId(id);
		setProveedor(proveedor);
		setTienda(tienda);
		setFechaAsociacion(fechaAsociacion);
	}

	public static ProveedorTiendaDomain obtenerValorDefecto() {
		return new ProveedorTiendaDomain();
	}

	public static ProveedorTiendaDomain obtenerValorDefecto(final ProveedorTiendaDomain proveedorTienda) {
		return UtilObjeto.getInstance().obtenerValorDefecto(proveedorTienda, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ProveedorDomain getProveedor() {
		return proveedor;
	}

	public void setProveedor(final ProveedorDomain proveedor) {
		this.proveedor = ProveedorDomain.obtenerValorDefecto(proveedor);
	}

	public TiendaDomain getTienda() {
		return tienda;
	}

	public void setTienda(final TiendaDomain tienda) {
		this.tienda = TiendaDomain.obtenerValorDefecto(tienda);
	}

	public LocalDate getFechaAsociacion() {
		return fechaAsociacion;
	}

	public void setFechaAsociacion(final LocalDate fechaAsociacion) {
		this.fechaAsociacion = UtilFecha.getInstance().obtenerValorDefecto(fechaAsociacion);
	}
}
