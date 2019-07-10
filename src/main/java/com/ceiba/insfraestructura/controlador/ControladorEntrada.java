package com.ceiba.insfraestructura.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.aplicacion.comando.ComandoEntrada;
import com.ceiba.aplicacion.comando.manejador.ManejadorCrearEntrada;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("webapi/entradas")
@Api(tags = {"Controlador entradas"})
public class ControladorEntrada {

	private final ManejadorCrearEntrada manejadorEntrada;
	
	@Autowired
	public ControladorEntrada(ManejadorCrearEntrada manejadorEntrada) {
		this.manejadorEntrada = manejadorEntrada;
	}
	
	@PostMapping
	@ApiOperation("guardar")
	public void ingresarVehiculoAlParqueadero(@RequestBody ComandoEntrada comandoEntrada) {
		this.manejadorEntrada.ejecutar(comandoEntrada);
	}
	
}
