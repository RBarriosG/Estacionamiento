package com.ceiba.insfraestructura.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "Parqueo")
@NoArgsConstructor
@Data
public class ParqueoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "placa", referencedColumnName = "placa")
	private VehiculoEntity vehiculo;
	
	@NotNull
	private Date fechaInicio;
	
	@NotNull
	private Date fechaFin;
	
	@NotNull
	private double valor;

	
	public ParqueoEntity(VehiculoEntity vehiculo, @NotNull Date fechaInicio, @NotNull Date fechaFin,
			@NotNull double valor) {
		super();
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public double getValor() {
		return valor;
	}
}
