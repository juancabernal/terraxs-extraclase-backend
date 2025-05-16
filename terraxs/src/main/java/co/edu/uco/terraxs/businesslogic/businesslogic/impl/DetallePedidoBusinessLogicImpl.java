package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.DetallePedidoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.DetallePedidoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class DetallePedidoBusinessLogicImpl implements DetallePedidoBusinessLogic{
	
	private DAOFactory factory;
	
	public DetallePedidoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}


	@Override
	public void registrarNuevoDetallePedido(DetallePedidoDomain detallePedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetallePedidoDomain consultarDetallePedidoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetallePedidoDomain> consultarDetallesPedido(DetallePedidoDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
