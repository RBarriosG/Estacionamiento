package com.ceiba.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.dominio.modelo.Entrada;

public interface RepositorioEntrada {

	boolean existsByPlaca(String placa);
	
	void deleteById(Long id);
	
	void save(Entrada entrada);
	
	List<Entrada> findAll();
	
	Long count();
	
	Long countByVehiculoTipoVehiculo(String tipoVehiculo);
	
}
