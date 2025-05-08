package co.edu.uco.terraxs.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.terraxs.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;

public final class ProveedorTiendaDTO {

	private UUID id;
	private ProveedorDTO proveedor;
	private TiendaDTO tienda;
	private LocalDate fechaAsociacion;

	public ProveedorTiendaDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setProveedor(ProveedorDTO.obtenerValorDefecto());
		setTienda(TiendaDTO.obtenerValorDefecto());
		setFechaAsociacion(UtilFecha.obtenerFechaActual());
	}
	
	public ProveedorTiendaDTO(final UUID id) {
		setId(id);
		setProveedor(ProveedorDTO.obtenerValorDefecto());
		setTienda(TiendaDTO.obtenerValorDefecto());
		setFechaAsociacion(UtilFecha.obtenerFechaActual());
	}

	public ProveedorTiendaDTO(final UUID id, final ProveedorDTO proveedor, final TiendaDTO tienda, final LocalDate fechaAsociacion) {
		setId(id);
		setProveedor(proveedor);
		setTienda(tienda);
		setFechaAsociacion(fechaAsociacion);
	}

	public static ProveedorTiendaDTO obtenerValorDefecto() {
		return new ProveedorTiendaDTO();
	}

	public static ProveedorTiendaDTO obtenerValorDefecto(final ProveedorTiendaDTO dto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public ProveedorTiendaDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public ProveedorTiendaDTO setProveedor(final ProveedorDTO proveedor) {
		this.proveedor = ProveedorDTO.obtenerValorDefecto(proveedor);
		return this;
	}

	public TiendaDTO getTienda() {
		return tienda;
	}

	public ProveedorTiendaDTO setTienda(final TiendaDTO tienda) {
		this.tienda = TiendaDTO.obtenerValorDefecto(tienda);
		return this;
	}

	public LocalDate getFechaAsociacion() {
		return fechaAsociacion;
	}

	public ProveedorTiendaDTO setFechaAsociacion(final LocalDate fechaAsociacion) {
		this.fechaAsociacion = UtilFecha.obtenerValorDefecto(fechaAsociacion);
		return this;
	}
}
