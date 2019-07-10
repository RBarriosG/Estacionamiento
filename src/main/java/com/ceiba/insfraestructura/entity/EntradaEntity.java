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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "Entrada")
@NoArgsConstructor
@Data
public class EntradaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "placa", referencedColumnName = "placa")
	private VehiculoEntity vehiculo;

	@NotNull
	private Date fechaEntrada;

	public EntradaEntity(VehiculoEntity vehiculo, @NotNull Date fechaEntrada) {
		super();
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
	}
}
