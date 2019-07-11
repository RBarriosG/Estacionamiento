package com.ceiba.dominio.modelo;

import java.time.LocalDateTime;

public class Salida {

	public static final String ID_NULO = "Id nulo";
	public static final String ENTRADA_NULA = "Entrada nula";
	public static final String FECHA_SALIDA_NULA = "Fecha salida nula";
	public static final String VALOR_IGUAL_A_0 = "Valor igual a 0";
	
	private Long id;
	
	private Entrada entrada;

	private LocalDateTime fechaSalida;

	private double valor;

	public Salida(Long id, Entrada entrada, LocalDateTime fechaSalida, double valor) {
		ValidadorArgumento.validarObligatorio(id, ID_NULO);
		ValidadorArgumento.validarObligatorio(entrada, ENTRADA_NULA);
		ValidadorArgumento.validarObligatorio(fechaSalida, FECHA_SALIDA_NULA);
		ValidadorArgumento.validarObligatorioValor(valor, VALOR_IGUAL_A_0);
		this.id = id;
		this.entrada = entrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}
	
	public Entrada getEntrada() {
		return entrada;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public double getValor() {
		return valor;
	}

}
