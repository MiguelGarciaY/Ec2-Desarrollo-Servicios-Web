package com.idat.ec2.dto;

public class BodegaDTORequest {
	private Integer idTienda;
	private String nombreTienda;
	private String dirTienda;
	public Integer getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}
	public String getNombreTienda() {
		return nombreTienda;
	}
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	public String getDirTienda() {
		return dirTienda;
	}
	public void setDirTienda(String dirTienda) {
		this.dirTienda = dirTienda;
	}
}
