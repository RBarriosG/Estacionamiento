package com.ceiba.insfraestructura.controlador;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.aplicacion.comando.ComandoParqueo;
import com.ceiba.aplicacion.comando.manejador.ManejadorParqueo;
import com.ceiba.dominio.modelo.Parqueo;
import com.ceiba.dominio.modelo.Vehiculo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("webapi/parqueos")
@Api(tags = {"Controlador Parqueos"})
public class ControladorParqueo {

	private final ManejadorParqueo manejadorParqueo;
	
	@Autowired
	public ControladorParqueo(ManejadorParqueo manejadorParqueo) {
		this.manejadorParqueo = manejadorParqueo;
	}
	
	@PostMapping
	@ApiOperation("guardar")
	public void ingresarVehiculoAlParqueadero(@RequestBody ComandoParqueo comandoParqueo) {
		this.manejadorParqueo.ejecutarGuardado(comandoParqueo);
	}
	
	@GetMapping
	public Parqueo probar() {
		
		Date dia = new Date();
		
		return new Parqueo(1L,
				new Vehiculo(1L, "RTT-566", "CARRO", 1000),
				dia,
				dia,
				20000d);
	}
	
}
