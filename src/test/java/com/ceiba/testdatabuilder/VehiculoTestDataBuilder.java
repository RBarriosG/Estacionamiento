package com.ceiba.testdatabuilder;

import com.ceiba.dominio.modelo.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final Long ID = 100L;
	private static final String PLACA = "EDC345";
	private static final String TIPO = "CARRO";
	private static final int CILINDRAJE = 1000;
	
	private Long id;
	private String placa;
	private String tipo;
	private int cilindraje;
	
	public VehiculoTestDataBuilder() {
		this.id = ID;
		this.placa = PLACA;
		this.tipo = TIPO;
		this.cilindraje = CILINDRAJE;
	}
	
	public VehiculoTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(this.id, this.placa, this.tipo, this.cilindraje);
	}
	
}
