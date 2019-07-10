package com.ceiba.dominio.excepcion;

public class ExcepcionTipoCarro extends RuntimeException {

	public ExcepcionTipoCarro(String mensaje) {
		super(mensaje);
	}
}
