package com.ceiba.dominio.modelo;

import com.ceiba.dominio.excepcion.ExcepcionTipoCarro;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {

	public static final String CARRO = "CARRO";
	public static final String MOTO = "MOTO";
	
	private ValidadorArgumento() {
	}
	
	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}
	
	public static void validarObligatorioCilindraje(int cilindraje, String mensaje) {
		if (cilindraje == 0) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}
	
	public static void validarTipoVehiculo(Object valor, String mensaje) {
		if (!(valor.toString().equals(CARRO) || valor.toString().equals(MOTO))) {
			throw new ExcepcionTipoCarro(mensaje);
		}
	}
	
}
