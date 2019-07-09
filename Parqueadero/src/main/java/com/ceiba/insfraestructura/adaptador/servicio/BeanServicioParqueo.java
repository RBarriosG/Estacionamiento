package com.ceiba.insfraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.servicio.ServicioParqueo;
import com.ceiba.insfraestructura.adaptador.repositorio.JpaRepositorioParqueoImp;

@Configuration
public class BeanServicioParqueo {

	@Bean
	public ServicioParqueo servicioParqueo() {
		return new ServicioParqueo(new JpaRepositorioParqueoImp());
	}
	
}
