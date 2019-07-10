package com.ceiba.dominio.modelo;

public class Vehiculo {

	public static final String PLACA_SIN_VALOR = "Placa sin valor";
	public static final String TIPO_SIN_VALOR = "Tipo sin valor";
	public static final String VEHICULO_TIPO_MOTO_NECESITA_CILINDRAJE = "Vehiculo tipo moto necesita cilindraje";
	public static final String TIPO_VEHICULO_NO_EXISTE = "Tipo vehiculo no existe";
	
	private String placa;
	
	private String tipo;
	
	private int cilindraje;

	public Vehiculo(String placa, String tipo, int cilindraje) {
		ValidadorArgumento.validarObligatorio(placa, PLACA_SIN_VALOR);
		ValidadorArgumento.validarObligatorio(tipo, TIPO_SIN_VALOR);
		ValidadorArgumento.validarTipoVehiculo(tipo, TIPO_VEHICULO_NO_EXISTE);
		ValidadorArgumento.validarObligatorioCilindrajeSiEsMoto(cilindraje, tipo, VEHICULO_TIPO_MOTO_NECESITA_CILINDRAJE);
		this.placa = placa;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
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
