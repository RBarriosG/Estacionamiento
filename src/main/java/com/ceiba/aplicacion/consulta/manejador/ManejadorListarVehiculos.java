package com.ceiba.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;

@Component
public class ManejadorListarVehiculos {

	private final RepositorioVehiculo repositorioVehiculo;
	
	public ManejadorListarVehiculos(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}
	
	public List<Vehiculo> ejecutar(){
		return this.repositorioVehiculo.findAll();
	}
	
}
