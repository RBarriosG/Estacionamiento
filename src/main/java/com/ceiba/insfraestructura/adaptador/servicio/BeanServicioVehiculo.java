package com.ceiba.insfraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.servicio.ServicioVehiculo;
import com.ceiba.insfraestructura.adaptador.repositorio.JpaRepositorioVehiculoImp;

@Configuration
public class BeanServicioVehiculo {

	@Bean
	public ServicioVehiculo servicioVehiculo() {
		return new ServicioVehiculo(new JpaRepositorioVehiculoImp());
	}
	
}
