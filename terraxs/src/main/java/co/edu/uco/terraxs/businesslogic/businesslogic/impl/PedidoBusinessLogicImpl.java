package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.PedidoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.PedidoDomain;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;

public class PedidoBusinessLogicImpl implements PedidoBusinessLogic{

	private DAOFactory factory;
	
	public PedidoBusinessLogicImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public void realizarPedido(PedidoDomain pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double consultarCostoPedido(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EstadoDomain consultarEstadoPedido(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoDomain ActualizarEstadoPedido(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void cancelarPedido(UUID id) {
		// TODO Auto-generated method stub
		
	}


}
