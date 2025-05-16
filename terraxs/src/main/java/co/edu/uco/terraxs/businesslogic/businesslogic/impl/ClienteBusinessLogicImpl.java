package co.edu.uco.terraxs.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TipoDocumentoDomain;
import co.edu.uco.terraxs.businesslogic.businesslogic.domain.TokenConfirmacionDomain;

public class ClienteBusinessLogicImpl implements ClienteBusinessLogic{

	@Override
	public void registrarCliente(ClienteDomain cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean confirmarDatosCliente(ClienteDomain cliente, TokenConfirmacionDomain token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void elegirTipoDocumento(List<TipoDocumentoDomain> tipoDocumento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteDomain consultarClientePorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDomain> consultarClientes(ClienteDomain filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDatosCliente(UUID id, ClienteDomain cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elegirMunicipio(List<CiudadDomain> ciudad) {
		// TODO Auto-generated method stub
		
	}

}
