package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.PedidoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.PedidoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.PedidoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.EstadoDTO;
import co.edu.uco.terraxs.dto.PedidoDTO;

public class PedidoFacadeImpl implements PedidoFacade{
	
	private DAOFactory daoFactory;
	private PedidoBusinessLogic pedidoBusinessLogic;
	
	
	public PedidoFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		pedidoBusinessLogic = new PedidoBusinessLogicImpl(daoFactory);
	}


	@Override
	public void realizarPedido(PedidoDTO pedido) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}


	@Override
	public double consultarCostoPedido(UUID id) throws TerraxsException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public PedidoDTO consultarEstadoPedido(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void actualizarEstadoPedido(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
	}


	@Override
	public void cancelarPedido(UUID id) {
		// TODO Auto-generated method stub
		
	}


}
