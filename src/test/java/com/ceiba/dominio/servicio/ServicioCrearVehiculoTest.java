package com.ceiba.dominio.servicio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioCrearVehiculoTest {

	@Test
	public void validarExistenciaVehiculoTest() {
		//arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
		Mockito.when(repositorioVehiculo.existsByPlaca(Mockito.any())).thenReturn(true);
		ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
		//Act
		try {
			servicioCrearVehiculo.ejecutar(vehiculo);
			fail();
		} catch (Exception e) {
			//Assert
			assertEquals(ServicioCrearVehiculo.VEHICULO_YA_EXISTE, e.getMessage());
		}
	}

}
