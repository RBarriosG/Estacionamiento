package com.ceiba.dominio.servicio;

import java.util.List;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {

	public static final String VEHICULO_YA_EXISTE = "Vehiculo ya existe";
	
	private RepositorioVehiculo repositorioVehiculo;
	
	public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}
	
	public void ejecutar(Vehiculo vehiculo) {
		if (validarExistencia(vehiculo)) 
			throw new ExcepcionDuplicidad(VEHICULO_YA_EXISTE);
		
		this.repositorioVehiculo.save(vehiculo);
	}
	
	private boolean validarExistencia(Vehiculo vehiculo) {
		return this.repositorioVehiculo.existsByPlaca(vehiculo.getPlaca());
	}
	
	/**
	 * Pendiente por eliminar
	 * @return
	 */
	
	public List<Vehiculo> listar(){
		return this.repositorioVehiculo.findAll();
	}
	
	
}
