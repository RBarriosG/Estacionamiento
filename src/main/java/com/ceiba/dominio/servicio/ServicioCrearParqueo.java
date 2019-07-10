package com.ceiba.dominio.servicio;

import java.util.List;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.Parqueo;
import com.ceiba.dominio.puerto.repositorio.RepositorioParqueo;

public class ServicioCrearParqueo {

	private static final String PARQUEO_YA_EXISTE = "Parqueo ya existe";
	
	private RepositorioParqueo repositorioParqueo;
	
	public ServicioCrearParqueo(RepositorioParqueo repositorioParqueo) {
		this.repositorioParqueo = repositorioParqueo;
	}
	
	public void ejecutar(Parqueo parqueo) {
		if (validadExistencia(parqueo)) { 
			throw new ExcepcionDuplicidad(PARQUEO_YA_EXISTE);
		}
		this.repositorioParqueo.save(parqueo);
	}

	
	
	/**
	 * Por eliminar
	 * @param id
	 */
	public void eliminar(Long id) {
		this.repositorioParqueo.deleteById(id);
	}
	
	public List<Parqueo> listar(){
		return this.repositorioParqueo.findAll();
	}
	
	private boolean validadExistencia(Parqueo parqueo) {
		return this.repositorioParqueo.existsById(parqueo.getId());
	}
}
