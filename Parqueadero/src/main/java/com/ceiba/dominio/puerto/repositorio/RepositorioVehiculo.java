package com.ceiba.dominio.puerto.repositorio;

import java.util.List;


import com.ceiba.dominio.modelo.Vehiculo;

public interface RepositorioVehiculo  {

	boolean existsByPlaca(String placa);
	
	void deleteByPlaca(String placa);
	
	void save(Vehiculo vehiculo);
	
	List<Vehiculo> findAll();
	
	
	
}
