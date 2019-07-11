package com.ceiba.dominio.modelo;

import java.time.LocalDateTime;

public class Entrada {

	private Long id;

	private Vehiculo vehiculo;

	private LocalDateTime fechaEntrada;

	public Entrada(Long id, Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public LocalDateTime getFechaInicio() {
		return fechaEntrada;
	}

	public Long getId() {
		return id;
	}

}
