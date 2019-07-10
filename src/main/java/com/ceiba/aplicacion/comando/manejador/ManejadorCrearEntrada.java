package com.ceiba.aplicacion.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoEntrada;
import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.servicio.ServicioCrearEntrada;

@Component
public class ManejadorCrearEntrada {

	private final ServicioCrearEntrada servicioEntrada;
	
	@Autowired
	public ManejadorCrearEntrada(ServicioCrearEntrada servicioEntrada) {
		this.servicioEntrada = servicioEntrada;
	}
	
	public void ejecutar(ComandoEntrada comandoEntrada) {
		this.servicioEntrada
			.ejecutar(new Entrada(comandoEntrada.getId(),
								comandoEntrada.getVehiculo(),
								comandoEntrada.getFechaEntrada()));
	}

}