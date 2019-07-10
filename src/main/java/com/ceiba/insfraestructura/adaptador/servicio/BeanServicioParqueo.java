package com.ceiba.insfraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.servicio.ServicioCrearParqueo;
import com.ceiba.insfraestructura.adaptador.repositorio.JpaRepositorioParqueo;
import com.ceiba.insfraestructura.adaptador.repositorio.JpaRepositorioParqueoImp;

@Configuration
public class BeanServicioParqueo {

	@Bean
	public ServicioCrearParqueo servicioParqueo(JpaRepositorioParqueo jpaRepositortioParqueo) {
		return new ServicioCrearParqueo(new JpaRepositorioParqueoImp(jpaRepositortioParqueo));
	}
	
}
