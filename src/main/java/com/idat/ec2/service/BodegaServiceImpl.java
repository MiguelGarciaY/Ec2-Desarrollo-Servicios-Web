package com.idat.ec2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.idat.ec2.dto.BodegaDTORequest;
import com.idat.ec2.dto.BodegaDTOResponse;
import com.idat.ec2.model.Bodega;
import com.idat.ec2.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService{
	@Autowired
	private BodegaRepository repository;

	@Override
	public void guardarBodega(BodegaDTORequest bodegaDTO) {
		// TODO Auto-generated method stub
		Bodega bodega=new Bodega();
		bodega.setNombre(bodegaDTO.getNombreTienda());
		bodega.setDireccion(bodegaDTO.getDirTienda());
		repository.save(bodega);
	}

	@Override
	public void actualizarBodega(BodegaDTORequest bodegaDTO) {
		// TODO Auto-generated method stub
		Bodega bodega=new Bodega();
		bodega.setIdBodega(bodegaDTO.getIdTienda());
		bodega.setNombre(bodegaDTO.getNombreTienda());
		bodega.setDireccion(bodegaDTO.getDirTienda());
		repository.saveAndFlush(bodega);
	}

	@Override
	public void eliminarBodega(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<BodegaDTOResponse> listarBodega() {
		// TODO Auto-generated method stub
		List<BodegaDTOResponse> listar=new ArrayList<>();
		BodegaDTOResponse dto=null;
		List<Bodega> b=repository.findAll();
		
		for(Bodega bodega:b) {
			dto=new BodegaDTOResponse();
			dto.setIdTienda(bodega.getIdBodega());
			dto.setNombreTienda(bodega.getNombre());
			dto.setDirTienda(bodega.getDireccion());

			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {
		// TODO Auto-generated method stub
		Bodega bodega=repository.findById(id).orElse(null);
		BodegaDTOResponse dto=null;
		dto=new BodegaDTOResponse();
		dto.setIdTienda(bodega.getIdBodega());
		dto.setNombreTienda(bodega.getNombre());
		dto.setDirTienda(bodega.getDireccion());
		return dto;
	}
}
