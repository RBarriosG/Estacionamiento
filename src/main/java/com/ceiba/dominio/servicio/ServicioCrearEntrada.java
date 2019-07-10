package com.ceiba.dominio.servicio;

import java.util.List;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;

public class ServicioCrearEntrada {

	private static final String PARQUEO_YA_EXISTE = "Parqueo ya existe";
	
	private RepositorioEntrada repositorioParqueo;
	
	public ServicioCrearEntrada(RepositorioEntrada repositorioParqueo) {
		this.repositorioParqueo = repositorioParqueo;
	}
	
	public void ejecutar(Entrada parqueo) {
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
	
	public List<Entrada> listar(){
		return this.repositorioParqueo.findAll();
	}
	
	private boolean validadExistencia(Entrada parqueo) {
		return this.repositorioParqueo.existsById(parqueo.getId());
	}
}
