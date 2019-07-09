package com.ceiba.aplicacion.comando;

import java.util.Date;

import com.ceiba.dominio.modelo.Vehiculo;

public class ComandoParqueo {

	private Long id;
	
	private Vehiculo vehiculo;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private Double valor;
	
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
	
	public Long getID() {
		return id;
	}
	
}
