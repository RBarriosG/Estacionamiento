package com.ceiba.dominio.modelo;

public class Vehiculo {

	public static final String PLACA_SIN_VALOR = "Placa sin valor";
	public static final String TIPO_SIN_VALOR = "Tipo sin valor";
	public static final String CILINDRAJE_CON_VALOR_0 = "Cilindraje con valor 0";
	public static final String TIPO_VEHICULO_NO_EXISTE = "Tipo vehiculo no existe";
	
	private Long id;
	
	private String placa;
	
	private String tipo;
	
	private int cilindraje;

	public Vehiculo(Long id, String placa, String tipo, int cilindraje) {
		ValidadorArgumento.validarObligatorio(placa, PLACA_SIN_VALOR);
		ValidadorArgumento.validarObligatorio(tipo, TIPO_SIN_VALOR);
		ValidadorArgumento.validarTipoVehiculo(tipo, TIPO_VEHICULO_NO_EXISTE);
		ValidadorArgumento.validarObligatorioCilindraje(cilindraje, CILINDRAJE_CON_VALOR_0);
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
