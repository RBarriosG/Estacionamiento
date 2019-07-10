package com.ceiba.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.dominio.modelo.Salida;

public interface RepositorioSalida {

	boolean existsById(Long id);

	void deleteById(Long id);

	void save(Salida salida);

	List<Salida> findAll();

}
