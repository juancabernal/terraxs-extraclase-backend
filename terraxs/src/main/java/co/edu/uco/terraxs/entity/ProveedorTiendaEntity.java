package co.edu.uco.terraxs.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class ProveedorTiendaEntity {
	

	private UUID id;
	private ProveedorEntity proveedor;
	private TiendaEntity tienda;
	private LocalDate fechaAsociacion;

	public ProveedorTiendaEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setProveedor(ProveedorEntity.obtenerValorDefecto());
		setTienda(TiendaEntity.obtenerValorDefecto());
		setFechaAsociacion(UtilFecha.getInstance().obtenerFechaActual());
	}
	
	public ProveedorTiendaEntity(final UUID id) {
		setId(id);
		setProveedor(ProveedorEntity.obtenerValorDefecto());
		setTienda(TiendaEntity.obtenerValorDefecto());
		setFechaAsociacion(UtilFecha.getInstance().obtenerFechaActual());
	}

	public ProveedorTiendaEntity(final UUID id, final ProveedorEntity proveedor, final TiendaEntity tienda, final LocalDate fechaAsociacion) {
		setId(id);
		setProveedor(proveedor);
		setTienda(tienda);
		setFechaAsociacion(fechaAsociacion);
	}

	public static ProveedorTiendaEntity obtenerValorDefecto() {
		return new ProveedorTiendaEntity();
	}

	public static ProveedorTiendaEntity obtenerValorDefecto(final ProveedorTiendaEntity proveedorTienda) {
		return UtilObjeto.getInstance().obtenerValorDefecto(proveedorTienda, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public void setProveedor(final ProveedorEntity proveedor) {
		this.proveedor = ProveedorEntity.obtenerValorDefecto(proveedor);
	}

	public TiendaEntity getTienda() {
		return tienda;
	}

	public void setTienda(final TiendaEntity tienda) {
		this.tienda = TiendaEntity.obtenerValorDefecto(tienda);
	}

	public LocalDate getFechaAsociacion() {
		return fechaAsociacion;
	}

	public void setFechaAsociacion(final LocalDate fechaAsociacion) {
		this.fechaAsociacion = UtilFecha.getInstance().obtenerValorDefecto(fechaAsociacion);
	}
}
