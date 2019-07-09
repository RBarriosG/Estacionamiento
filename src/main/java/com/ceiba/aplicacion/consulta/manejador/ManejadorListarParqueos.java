package com.ceiba.aplicacion.consulta.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.dominio.puerto.repositorio.RepositorioParqueo;

@Component
public class ManejadorListarParqueos {

	private final RepositorioParqueo repositorioParqueo;
	
	public ManejadorListarParqueos(RepositorioParqueo repositorioParqueo) {
		this.repositorioParqueo = repositorioParqueo;
	}
	
}
