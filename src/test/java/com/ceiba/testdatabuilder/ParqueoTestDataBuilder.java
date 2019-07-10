package com.ceiba.testdatabuilder;

import java.util.Date;

import com.ceiba.dominio.modelo.Vehiculo;

public class ParqueoTestDataBuilder {


	
	private static final Long ID = 10L;
	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();
	private static final Date FECHA_INICIO = new Date(2019, 07, 10, 06, 05);
	
	private Long id;

	private Vehiculo vehiculo;

	private Date fechaInicio;

	private Date fechaFin;

	private Double valor;

}
