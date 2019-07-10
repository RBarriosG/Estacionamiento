package com.ceiba.dominio.excepcion;

public class ExcepcionGuardarVehiculo extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionGuardarVehiculo(String mensaje) {
		super(mensaje);
	}
	
}
