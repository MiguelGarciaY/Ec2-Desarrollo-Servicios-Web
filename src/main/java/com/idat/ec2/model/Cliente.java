package com.idat.ec2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private String direccion;
	private String dni;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
				name="cliente_productos",
				joinColumns = @JoinColumn(
							name="id_cliente", 
							nullable = false,
							unique=true,
							foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references Cliente(id_cliente)")							
						),
				inverseJoinColumns = @JoinColumn(
							name="id_producto",
							nullable=false,
							unique=true,
							foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references Productos(id_producto)")							
						)
			)
	private List<Productos> productos=new ArrayList<>();
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
