package com.idat.ec2.service;

import java.util.List;

import com.idat.ec2.dto.BodegaDTORequest;
import com.idat.ec2.dto.BodegaDTOResponse;


public interface BodegaService {
	void guardarBodega(BodegaDTORequest bodega);
	void actualizarBodega(BodegaDTORequest bodega);
	void eliminarBodega(Integer id);	
	List<BodegaDTOResponse>listarBodega();
	BodegaDTOResponse obtenerBodegaId(Integer id);
}
