package com.ceiba.dominio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.modelo.Salida;
import com.ceiba.dominio.util.Constantes;

public class SalidaTestDataBuilder {
/**
 * PENDIENTE POR ARREGLAR
 */
	private static final Long ID = 16L;
	private static final Entrada ENTRADA = new EntradaTestDataBuilder().build();
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.of(2019,7,10,18,14);; // 2019-07-10 18:14
	//Como supera las 9 hora se cobra a valor día. es un valor quemado que tenemos que resolver
	private static final double VALOR = Constantes.VALOR_DIA_CARRO; 
	
	private Long id;
	
	private Entrada entrada;

	private LocalDateTime fechaSalida;

	private double valor;
	
	public SalidaTestDataBuilder() {
		this.id = ID;
		this.entrada = ENTRADA;
		this.fechaSalida = FECHA_SALIDA;
		this.valor = VALOR;
	}
	
	public SalidaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public SalidaTestDataBuilder conEntrada(Entrada entrada) {
		this.entrada = entrada;
		return this;
	}
	
	public SalidaTestDataBuilder conFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public SalidaTestDataBuilder conValor(double valor) {
		this.valor = valor;
		return this;
	}
	
	public Salida build() {
		return new Salida(this.id, this.entrada, this.fechaSalida, this.valor);
	}
	
}
