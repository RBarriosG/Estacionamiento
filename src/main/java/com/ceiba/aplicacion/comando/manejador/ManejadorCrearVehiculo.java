package com.ceiba.aplicacion.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoVehiculo;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.servicio.ServicioCrearVehiculo;

@Component
public class ManejadorCrearVehiculo {

	private final ServicioCrearVehiculo servicioVehiculo;
	
	@Autowired
	public ManejadorCrearVehiculo(ServicioCrearVehiculo servicioVehiculo) {
		this.servicioVehiculo = servicioVehiculo;
	}
	
	public void ejecutar(ComandoVehiculo comandoVehiculo) {
		this.servicioVehiculo
			.ejecutar(new Vehiculo(comandoVehiculo.getPlaca(),
									comandoVehiculo.getTipo(),
									comandoVehiculo.getCilindraje()));
	}
	
}
