package com.idat.ec2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.idat.ec2.dto.UsuarioDTORequest;
import com.idat.ec2.dto.UsuarioDTOResponse;
import com.idat.ec2.model.Usuario;
import com.idat.ec2.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void guardarUsuario(UsuarioDTORequest usuarioDTO) {
		// TODO Auto-generated method stub
		Usuario usuario=new Usuario();
		usuario.setUsuario(usuarioDTO.getDescUser());
		usuario.setPassword(usuarioDTO.getContrasenia());
		usuario.setRol(usuarioDTO.getRolUser());
		repository.save(usuario);	
	}

	@Override
	public void actualizarUsuario(UsuarioDTORequest usuarioDTO) {
		// TODO Auto-generated method stub
		Usuario usuario=new Usuario();
		usuario.setIdUsuarios(usuarioDTO.getIdUser());
		usuario.setUsuario(usuarioDTO.getDescUser());
		usuario.setPassword(usuarioDTO.getContrasenia());
		usuario.setRol(usuarioDTO.getRolUser());
		repository.saveAndFlush(usuario);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<UsuarioDTOResponse> listarUsuario() {
		// TODO Auto-generated method stub
		List<UsuarioDTOResponse> listar=new ArrayList<>();
		UsuarioDTOResponse dto=null;
		List<Usuario> u=repository.findAll();		
		for(Usuario usuario:u) {
			dto=new UsuarioDTOResponse();
			dto.setIdUser(usuario.getIdUsuarios());
			dto.setDescUser(usuario.getUsuario());
			dto.setContrasenia(usuario.getPassword());
			dto.setRolUser(usuario.getRol());			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public UsuarioDTOResponse obtenerUsuarioId(Integer id) {
		// TODO Auto-generated method stub
		Usuario usuario=repository.findById(id).orElse(null);
		UsuarioDTOResponse dto=null;
		dto=new UsuarioDTOResponse();
		dto.setIdUser(usuario.getIdUsuarios());
		dto.setDescUser(usuario.getUsuario());
		dto.setContrasenia(usuario.getPassword());
		dto.setRolUser(usuario.getRol());
		
		return dto;
	}

}
