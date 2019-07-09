package com.ceiba.insfraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.servicio.ServicioCrearVehiculo;
import com.ceiba.insfraestructura.adaptador.repositorio.JpaRepositorioVehiculo;
import com.ceiba.insfraestructura.adaptador.repositorio.JpaRepositorioVehiculoImp;

@Configuration
public class BeanServicioVehiculo {

	@Bean
	public ServicioCrearVehiculo servicioVehiculo(JpaRepositorioVehiculo jpaRepositorioVehiculo) {
		return new ServicioCrearVehiculo(new JpaRepositorioVehiculoImp(jpaRepositorioVehiculo));
	}
	
}
