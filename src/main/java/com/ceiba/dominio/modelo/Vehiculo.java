package com.ceiba.dominio.modelo;

import com.ceiba.dominio.util.Constantes;

public class Vehiculo {

	
	
	private String placa;
	
	private String tipo;
	
	private int cilindraje;

	public Vehiculo(String placa, String tipo, int cilindraje) {
		ValidadorArgumento.validarObligatorio(placa, Constantes.PLACA_SIN_VALOR);
		ValidadorArgumento.validarObligatorio(tipo, Constantes.TIPO_SIN_VALOR);
		ValidadorArgumento.validarTipoVehiculo(tipo, Constantes.TIPO_VEHICULO_NO_EXISTE);
		ValidadorArgumento.validarObligatorioCilindrajeSiEsMoto(cilindraje, tipo, Constantes.VEHICULO_TIPO_MOTO_NECESITA_CILINDRAJE);
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
