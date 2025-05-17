package co.edu.uco.terraxs.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.impl.ClienteBusinessLogicImpl;
import co.edu.uco.terraxs.businesslogic.facade.ClienteFacade;
import co.edu.uco.terraxs.data.dao.factory.DAOFactory;
import co.edu.uco.terraxs.data.dao.factory.Factory;
import co.edu.uco.terraxs.dto.ClienteDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;
import co.edu.uco.terraxs.dto.TokenConfirmacionDTO;

public class ClienteFacadeImpl implements ClienteFacade {
	
	private DAOFactory daoFactory;
	private ClienteBusinessLogic clienteBusinessLogic;
	
	
	public ClienteFacadeImpl() {
		daoFactory=DAOFactory.getFactory(Factory.POSTGRE_SQL);
		clienteBusinessLogic = new ClienteBusinessLogicImpl(daoFactory);
	}

	@Override
	public void registrarCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean confirmarDatosCliente(ClienteDTO cliente, TokenConfirmacionDTO token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDTO> tipoDocumento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteDTO consultarClientePorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> consultarClientes(ClienteDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDatosCliente(UUID id, ClienteDTO cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elegirMunicipio(List<ClienteDTO> ciudad) {
		// TODO Auto-generated method stub
		
	}

}
