package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.CarritoComprasBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CarritoComprasDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ProductoDomain;

public class CarritoComprasBusinessLogicImpl implements CarritoComprasBusinessLogic{

	@Override
	public void crearCarritoCompras(CarritoComprasDomain carritoCompras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CarritoComprasDomain consultarCarritoComprasPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarritoComprasDomain> consultarCarritosCompras(CarritoComprasDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarProductoCarrito(UUID id, ProductoDomain producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarProductoCarrito(UUID id, ProductoDomain producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vaciarCarrito(UUID id, CarritoComprasDomain carritoCompras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCarrito(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEstadoCarrito(List<EstadoDomain> estado) {
		// TODO Auto-generated method stub
		
	}

}
