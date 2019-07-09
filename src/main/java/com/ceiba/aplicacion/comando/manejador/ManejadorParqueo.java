package com.ceiba.aplicacion.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoParqueo;
import com.ceiba.dominio.modelo.Parqueo;
import com.ceiba.dominio.servicio.ServicioParqueo;

@Component
public class ManejadorParqueo {

	private final ServicioParqueo servicioParqueo;
	
	@Autowired
	public ManejadorParqueo(ServicioParqueo servicioParqueo) {
		this.servicioParqueo = servicioParqueo;
	}
	
	public void ejecutarGuardado(ComandoParqueo comandoParqueo) {
		this.servicioParqueo
			.guardar(new Parqueo(comandoParqueo.getId(),
								comandoParqueo.getVehiculo(),
								comandoParqueo.getFechaInicio(),
								comandoParqueo.getFechaFin(),
								comandoParqueo.getValor()));
	}
	
	public void ejecutarEliminacion(ComandoParqueo comandoParqueo) {
		this.servicioParqueo.eliminar(comandoParqueo.getId());
	}

}
