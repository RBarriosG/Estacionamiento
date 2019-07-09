package com.ceiba.insfraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.aplicacion.comando.ComandoVehiculo;
import com.ceiba.aplicacion.comando.manejador.ManejadorVehiculo;
import com.ceiba.dominio.modelo.Vehiculo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("webapi/vehiculos")
@Api(tags = {"Controlador Vehiculo"})
public class ControladorVehiculo {

	private final ManejadorVehiculo manejadorVehiculo;
	
	@Autowired
	public ControladorVehiculo(ManejadorVehiculo manejadorVehiculo) {
		this.manejadorVehiculo = manejadorVehiculo;
	}
	
	
	@GetMapping
	@ApiOperation("listar")
	public List<Vehiculo> listar(){
		return this.manejadorVehiculo.ejecularListado();
	}

	@PostMapping
	@ApiOperation("guardar")
	public void guardar(@RequestBody ComandoVehiculo comandoVehiculo) {
		this.manejadorVehiculo.ejecutarGuardado(comandoVehiculo);
	}
	
}
