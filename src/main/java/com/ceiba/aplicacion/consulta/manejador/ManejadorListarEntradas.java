package com.ceiba.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;

@Component
public class ManejadorListarEntradas {

	private final RepositorioEntrada repositorioEntrada;
	
	public ManejadorListarEntradas(RepositorioEntrada repositorioEntrada) {
		this.repositorioEntrada = repositorioEntrada;
	}
	
	public List<Entrada> ejecutar(){
		return this.repositorioEntrada.findAll();
	}
	
}
