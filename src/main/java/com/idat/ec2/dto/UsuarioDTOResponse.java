package com.idat.ec2.dto;

public class UsuarioDTOResponse {
	private Integer idUser;
	private String descUser;
	private String Contrasenia;
	private String rolUser;
	private String token;
	
	
	public UsuarioDTOResponse(String descUser) {
		super();
		this.descUser = descUser;
	}
	
	public UsuarioDTOResponse() {
	}
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getDescUser() {
		return descUser;
	}
	public void setDescUser(String descUser) {
		this.descUser = descUser;
	}
	public String getContrasenia() {
		return Contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
	public String getRolUser() {
		return rolUser;
	}
	public void setRolUser(String rolUser) {
		this.rolUser = rolUser;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
