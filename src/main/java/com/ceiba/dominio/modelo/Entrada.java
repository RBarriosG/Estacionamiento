package com.ceiba.dominio.modelo;

import java.util.Date;

public class Entrada {

	private Long id;

	private Vehiculo vehiculo;

	private Date fechaEntrada;

	public Entrada() {
	}

	public Entrada(Long id, Vehiculo vehiculo, Date fechaEntrada) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Date getFechaInicio() {
		return fechaEntrada;
	}

	public Long getId() {
		return id;
	}

}
