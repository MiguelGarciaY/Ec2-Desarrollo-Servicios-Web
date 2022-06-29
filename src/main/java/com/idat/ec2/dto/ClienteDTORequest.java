package com.idat.ec2.dto;

public class ClienteDTORequest {
	private Integer idCli;
	private String nombreCli;
	private String direccionCli;
	private String identificadorCli;
	public Integer getIdCli() {
		return idCli;
	}
	public void setIdCli(Integer idCli) {
		this.idCli = idCli;
	}
	public String getNombreCli() {
		return nombreCli;
	}
	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}
	public String getDireccionCli() {
		return direccionCli;
	}
	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}
	public String getIdentificadorCli() {
		return identificadorCli;
	}
	public void setIdentificadorCli(String identificadorCli) {
		this.identificadorCli = identificadorCli;
	}
}
