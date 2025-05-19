package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.DetallePedidoBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.DetallePedidoBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.DetallePedidoFacade;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.dto.DetallePedidoDTO;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;

public class DetallePedidoFacadeImpl implements DetallePedidoFacade{
	
	private DAOFactory daoFactory;
	private DetallePedidoBusinessLogic detallePedidoBusinessLogic;
	
	
	public DetallePedidoFacadeImpl() throws TerraxsException {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		detallePedidoBusinessLogic = new DetallePedidoBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarNuevoDetallePedido(DetallePedidoDTO detallePedido) throws TerraxsException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetallePedidoDTO consultarDetallePedidoPorId(UUID id) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetallePedidoDTO> consultarDetallesPedido(DetallePedidoDTO filtro) throws TerraxsException{
		// TODO Auto-generated method stub
		return null;
	}

}
