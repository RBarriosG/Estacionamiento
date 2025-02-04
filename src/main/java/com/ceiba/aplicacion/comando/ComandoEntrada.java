package com.ceiba.aplicacion.comando;

import java.time.LocalDateTime;

import com.ceiba.dominio.modelo.Vehiculo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEntrada {

	private Long id;

	private Vehiculo vehiculo;

	private LocalDateTime fechaEntrada;

}
