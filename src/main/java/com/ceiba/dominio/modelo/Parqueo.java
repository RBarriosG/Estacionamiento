package com.ceiba.dominio.modelo;

import java.util.Date;

public class Parqueo {

	private Long id;
	
	private Vehiculo vehiculo;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private Double valor;
	
	public Parqueo() {
	}

	public Parqueo(Long id, Vehiculo vehiculo, Date fechaInicio, Date fechaFin, Double valor) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valor = valor;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public Double getValor() {
		return valor;
	}
	
	public Long getId() {
		return id;
	}
	
}
