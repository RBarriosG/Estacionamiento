package com.ceiba.dominio.modelo;

import com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public final class ValidadorArgumento {

	public static final String CARRO = "CARRO";
	public static final String MOTO = "MOTO";
	
	private ValidadorArgumento() {
	}
	
	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null)
			throw new ExcepcionValorObligatorio(mensaje);
	}
	
	public static void validarObligatorioCilindrajeSiEsMoto(int cilindraje, String tipo, String mensaje) {
		if (cilindraje == 0 && tipo.equals(MOTO)) 
			throw new ExcepcionValorObligatorio(mensaje);
	}
	
	public static void validarTipoVehiculo(Object valor, String mensaje) {
		if (!(valor.toString().equals(CARRO) || valor.toString().equals(MOTO)))
			throw new ExcepcionTipoVehiculo(mensaje);
	}
	
	public static void validarObligatorioValor(double valor, String mensaje) {
		if(valor == 0.0)
			throw new ExcepcionValorObligatorio(mensaje);
	}
	
}
