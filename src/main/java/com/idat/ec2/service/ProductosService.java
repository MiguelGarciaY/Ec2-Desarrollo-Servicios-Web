package com.idat.ec2.service;

import java.util.List;

import com.idat.ec2.dto.ProductosDTORequest;
import com.idat.ec2.dto.ProductosDTOResponse;


public interface ProductosService {
	void guardarProductos(ProductosDTORequest productos);
	void actualizarProductos(ProductosDTORequest productos);
	void eliminarProductos(Integer id);	
	List<ProductosDTOResponse>listarProductos();
	ProductosDTOResponse obtenerProdcutosId(Integer id);
}
