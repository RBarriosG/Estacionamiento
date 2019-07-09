package com.ceiba.dominio.modelo;

public class Vehiculo {

	private Long id;
	
	private String placa;
	
	private String tipo;
	
	private int cilindraje;
	
	public Vehiculo() {
	}

	public Vehiculo(Long id, String placa, String tipo, int cilindraje) {
		super();
		this.id = id;
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
