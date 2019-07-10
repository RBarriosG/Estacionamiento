package com.ceiba.dominio.excepcion;

public class ExcepcionTipoCarro extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionTipoCarro(String mensaje) {
		super(mensaje);
	}
}
