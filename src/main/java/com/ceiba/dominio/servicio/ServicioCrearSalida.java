package com.ceiba.dominio.servicio;

import com.ceiba.dominio.modelo.Salida;
import com.ceiba.dominio.puerto.repositorio.RepositorioSalida;

public class ServicioCrearSalida {

	public static final String ALGO = "";
	
	private RepositorioSalida repositorioSalida;
	
	public ServicioCrearSalida(RepositorioSalida repositorioSalida) {
		this.repositorioSalida = repositorioSalida;
	}
	
	public void ejecutar(Salida salida) {
		
		this.repositorioSalida.save(salida);
	}
	
}
