package com.ceiba.insfraestructura.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "Vehiculo")
public class VehiculoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String placa;
	
	@NotNull
	private String tipo;
	
	@NotNull
	private int cilindraje;

	public VehiculoEntity(@NotNull String placa, @NotNull String tipo, @NotNull int cilindraje) {
		super();
		this.placa = placa;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}
	
	
}
