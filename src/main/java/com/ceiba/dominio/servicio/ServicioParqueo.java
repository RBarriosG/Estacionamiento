package com.ceiba.dominio.servicio;

import java.util.List;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.Parqueo;
import com.ceiba.dominio.puerto.repositorio.RepositorioParqueo;

public class ServicioParqueo {

	private static final String PARQUEO_YA_EXISTE = "Parqueo ya existe";
	
	private RepositorioParqueo repositorioParqueo;
	
	public ServicioParqueo(RepositorioParqueo repositorioParqueo) {
		this.repositorioParqueo = repositorioParqueo;
	}
	
	public void guardar(Parqueo parqueo) {
		if (!validadExistencia(parqueo)) { 
			this.repositorioParqueo.save(parqueo);
			return;
		}
		throw new ExcepcionDuplicidad(PARQUEO_YA_EXISTE);
	}

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
