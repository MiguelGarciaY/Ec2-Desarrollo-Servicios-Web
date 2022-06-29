package com.idat.ec2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.dto.ClienteDTORequest;
import com.idat.ec2.dto.ClienteDTOResponse;
import com.idat.ec2.model.Cliente;
import com.idat.ec2.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteDTORequest clienteDTO) {
		// TODO Auto-generated method stub
		Cliente cliente=new Cliente();
		cliente.setNombre(clienteDTO.getNombreCli());
		cliente.setDni(clienteDTO.getIdentificadorCli());
		cliente.setDireccion(clienteDTO.getDireccionCli());		
		repository.save(cliente);	
	}

	@Override
	public void actualizarCliente(ClienteDTORequest clienteDTO) {
		// TODO Auto-generated method stub
		Cliente cliente=new Cliente();
		cliente.setIdCliente(clienteDTO.getIdCli());
		cliente.setNombre(clienteDTO.getNombreCli());
		cliente.setDni(clienteDTO.getIdentificadorCli());
		cliente.setDireccion(clienteDTO.getDireccionCli());	
		repository.saveAndFlush(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);	
	}

	@Override
	public List<ClienteDTOResponse> listarCliente() {
		// TODO Auto-generated method stub
		List<ClienteDTOResponse> listar=new ArrayList<>();
		ClienteDTOResponse dto=null;
		List<Cliente> p=repository.findAll();
		for(Cliente cliente:p) {
			dto=new ClienteDTOResponse();
			dto.setIdCli(cliente.getIdCliente());
			dto.setNombreCli(cliente.getNombre());
			dto.setIdentificadorCli(cliente.getDni());
			dto.setDireccionCli(cliente.getDireccion());
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente=repository.findById(id).orElse(null);
		ClienteDTOResponse dto=null;
		dto=new ClienteDTOResponse();
		dto.setIdCli(cliente.getIdCliente());
		dto.setNombreCli(cliente.getNombre());
		dto.setIdentificadorCli(cliente.getDni());
		dto.setDireccionCli(cliente.getDireccion());
		
		return dto;
	}

}
