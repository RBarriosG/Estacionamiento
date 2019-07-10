package com.ceiba.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.dominio.modelo.Entrada;

public interface RepositorioEntrada {

	boolean existsById(Long id);
	
	void deleteById(Long id);
	
	void save(Entrada entrada);
	
	List<Entrada> findAll();
	
}
