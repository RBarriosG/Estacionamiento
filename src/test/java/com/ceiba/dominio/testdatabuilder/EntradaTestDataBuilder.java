package com.ceiba.dominio.testdatabuilder;

import java.util.Date;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.modelo.Vehiculo;

public class EntradaTestDataBuilder {


	
	private static final Long ID = 10L;
	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();
	private static final Date FECHA_ENTTRADA = new Date(2019, 07, 10, 06, 05);// 2019-07-10 06:05
	
	private Long id;

	private Vehiculo vehiculo;

	private Date fechaEntrada;
	
	public EntradaTestDataBuilder() {
		this.id = ID;
		this.vehiculo = VEHICULO;
		this.fechaEntrada = FECHA_ENTTRADA;
	}
	
	public EntradaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public EntradaTestDataBuilder conVechiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public EntradaTestDataBuilder conFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}

	public Entrada build() {
		return new Entrada(this.id, this.vehiculo, this.fechaEntrada);
	}
	
}
