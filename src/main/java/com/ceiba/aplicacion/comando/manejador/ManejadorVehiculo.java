package com.ceiba.aplicacion.comando.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoVehiculo;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.servicio.ServicioVehiculo;

@Component
public class ManejadorVehiculo {

	private final ServicioVehiculo servicioVehiculo;
	
	@Autowired
	public ManejadorVehiculo(ServicioVehiculo servicioVehiculo) {
		this.servicioVehiculo = servicioVehiculo;
	}
	
	public void ejecutarGuardado(ComandoVehiculo comandoVehiculo) {
		this.servicioVehiculo
			.guardar(new Vehiculo(comandoVehiculo.getId(),
									comandoVehiculo.getPlaca(),
									comandoVehiculo.getTipo(),
									comandoVehiculo.getCilindraje()));
	}
	
	public void ejecutarEliminacion(ComandoVehiculo comandoVehiculo) {
		this.servicioVehiculo
			.eliminar(comandoVehiculo.getPlaca());
	}
	
	public List<Vehiculo> ejecularListado(){
		return this.servicioVehiculo.listar();
	}
	
}
