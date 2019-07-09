package com.ceiba.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;

@Component
public class ServicioVehiculo {

	private static final String VEHICULO_YA_EXISTE = "Vehiculo ya existe";
	
	private RepositorioVehiculo repositorioVehiculo;
	
	public ServicioVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}
	
	public void guardar(Vehiculo vehiculo) {
		if (!validarExistencia(vehiculo)) {
			this.repositorioVehiculo.save(vehiculo);
			return;
		}
		throw new ExcepcionDuplicidad(VEHICULO_YA_EXISTE);
	}
	
	public void eliminar(String placa) {
		this.repositorioVehiculo.deleteByPlaca(placa);
	}
	
	public List<Vehiculo> listar(){
		return this.repositorioVehiculo.findAll();
	}
	
	private boolean validarExistencia(Vehiculo vehiculo) {
		return this.repositorioVehiculo.existsByPlaca(vehiculo.getPlaca());
	}
}
