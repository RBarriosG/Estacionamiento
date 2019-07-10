package com.ceiba.insfraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.servicio.ServicioCrearEntrada;
import com.ceiba.insfraestructura.adaptador.repositorio.JpaRepositorioEntrada;
import com.ceiba.insfraestructura.adaptador.repositorio.JpaRepositorioEntradaImp;

@Configuration
public class BeanServicioEntrada {

	@Bean
	public ServicioCrearEntrada servicioParqueo(JpaRepositorioEntrada jpaRepositortioParqueo) {
		return new ServicioCrearEntrada(new JpaRepositorioEntradaImp(jpaRepositortioParqueo));
	}
	
}
