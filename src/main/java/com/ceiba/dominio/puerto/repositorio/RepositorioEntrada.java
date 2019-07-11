package com.ceiba.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.modelo.Vehiculo;

public interface RepositorioEntrada {

	boolean existsByVehiculo(Vehiculo vehiculo);
	
	void deleteById(Long id);
	
	void save(Entrada entrada);
	
	List<Entrada> findAll();
	
	Long count();
	
	Long countByVehiculoTipoVehiculo(String tipoVehiculo);
	
}
