package com.idat.ec2.dto;

public class ProductosDTORequest {
	private Integer idProd;
	private String nombreProd;
	private String DescProd;
	private Double PrecProd;
	private Integer CantidadProducto;
	public Integer getIdProd() {
		return idProd;
	}
	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}
	public String getNombreProd() {
		return nombreProd;
	}
	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}
	public Double getPrecProd() {
		return PrecProd;
	}
	public void setPrecProd(Double precProd) {
		PrecProd = precProd;
	}

	public Integer getCantidadProducto() {
		return CantidadProducto;
	}
	public void setCantidadProducto(Integer cantidadProducto) {
		CantidadProducto = cantidadProducto;
	}
	public String getDescProd() {
		return DescProd;
	}
	public void setDescProd(String descProd) {
		DescProd = descProd;
	}
	
}
