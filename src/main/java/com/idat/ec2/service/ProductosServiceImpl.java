package com.idat.ec2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.dto.ProductosDTORequest;
import com.idat.ec2.dto.ProductosDTOResponse;
import com.idat.ec2.model.Productos;
import com.idat.ec2.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService{
	
	@Autowired
	private ProductosRepository repository;
	
	@Override
	public void guardarProductos(ProductosDTORequest productosDTO) {
		// TODO Auto-generated method stub
		Productos productos=new Productos();
		productos.setProducto(productosDTO.getNombreProd());
		productos.setDescripcion(productosDTO.getDescProd());
		productos.setPrecio(productosDTO.getPrecProd());
		productos.setStock(productosDTO.getCantidadProducto());
		repository.save(productos);
	}

	@Override
	public void actualizarProductos(ProductosDTORequest productosDTO) {
		// TODO Auto-generated method stub
		Productos productos=new Productos();
		productos.setIdProducto(productosDTO.getIdProd());
		productos.setProducto(productosDTO.getNombreProd());
		productos.setDescripcion(productosDTO.getDescProd());
		productos.setPrecio(productosDTO.getPrecProd());
		productos.setStock(productosDTO.getCantidadProducto());
		repository.saveAndFlush(productos);
	}

	@Override
	public void eliminarProductos(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<ProductosDTOResponse> listarProductos() {
		// TODO Auto-generated method stub
		List<ProductosDTOResponse> listar=new ArrayList<>();
		ProductosDTOResponse dto=null;
		List<Productos> p=repository.findAll();
		
		for(Productos producto:p) {
			dto=new ProductosDTOResponse();
			dto.setIdProd(producto.getIdProducto());
			dto.setNombreProd(producto.getProducto());
			dto.setDescProd(producto.getDescripcion());
			dto.setPrecProd(producto.getPrecio());
			dto.setCantidadProducto(producto.getStock());
			listar.add(dto);
			
		}
		
		return listar;
	}

	@Override
	public ProductosDTOResponse obtenerProdcutosId(Integer id) {
		// TODO Auto-generated method stub
		Productos producto=repository.findById(id).orElse(null);
		ProductosDTOResponse dto=null;
		dto=new ProductosDTOResponse();
		dto.setIdProd(producto.getIdProducto());
		dto.setNombreProd(producto.getProducto());
		dto.setDescProd(producto.getDescripcion());
		dto.setPrecProd(producto.getPrecio());
		dto.setCantidadProducto(producto.getStock());
				
		return dto;
	}

}
