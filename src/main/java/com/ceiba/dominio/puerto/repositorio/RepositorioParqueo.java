package com.ceiba.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.dominio.modelo.Parqueo;

public interface RepositorioParqueo {

	boolean existsById(Long id);
	
	void deleteById(Long id);
	
	void save(Parqueo parqueo);
	
	List<Parqueo> findAll();
	
}
