package com.ceiba.dominio.servicio;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;
import com.ceiba.dominio.testdatabuilder.EntradaTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.dominio.util.Constantes;

public class ServicioCrearEntradaTest {

	private static final Date FECHA_DOMINGO = new Date(2019,7,7,06,10);
	private static final Date FECHA_LUNES = new Date(2019,7,8);
	private static final Date FECHA_MARTES = new Date(2019,7,9);
	
	private static final String PLACA_COMIENZA_CON_A = "ABC456";
	
	@Test
	public void validarExistenciaEntradaTest() {
		// arrange
		Entrada entrada = new EntradaTestDataBuilder().build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		Mockito.when(repositorioEntrada.existsByPlaca(Mockito.any())).thenReturn(true);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);
		// Act
		try {
			servicioCrearEntrada.ejecutar(entrada);
			fail();
		} catch (Exception e) {
			// Assert
			assertEquals(Constantes.VEHICULO_YA_EXISTE_EN_EL_PARQUEADERO, e.getMessage());
		}

	}

	@Test
	public void maximo30VehiculosTest() {
		// arrange
		Entrada entrada = new EntradaTestDataBuilder().build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		Mockito.when(repositorioEntrada.count()).thenReturn(30L);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);
		// Act
		try {
			servicioCrearEntrada.ejecutar(entrada);
			fail();
		} catch (Exception e) {
			// Assert
			assertEquals(Constantes.MAXIMO_NUMERO_DE_VEHICULOS_EN_EL_PARQUEADERO, e.getMessage());
		}

	}

	@Test
	public void maximo20VehiculosTipoCarroTest() {
		// arrange
		Entrada entrada = new EntradaTestDataBuilder().build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		Mockito.when(repositorioEntrada.countByVehiculoTipoVehiculo(Constantes.CARRO)).thenReturn(20L);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);
		// Act
		try {
			servicioCrearEntrada.ejecutar(entrada);
			fail();
		} catch (Exception e) {
			// Assert
			assertEquals(Constantes.MAXIMO_NUMERO_DE_CARROS_EN_EL_PARQUEADERO, e.getMessage());
		}

	}

	@Test
	public void maximo10VehiculosTipoMotoTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo(Constantes.MOTO).build();
		Entrada entrada = new EntradaTestDataBuilder().conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		Mockito.when(repositorioEntrada.countByVehiculoTipoVehiculo(Constantes.MOTO)).thenReturn(10L);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);
		// Act
		try {
			servicioCrearEntrada.ejecutar(entrada);
			fail();
		} catch (Exception e) {
			// Assert
			assertEquals(Constantes.MAXIMO_NUMERO_DE_MOTOS_EN_EL_PARQUEADERO, e.getMessage());
		}

	}
/*
	@Test
	public void placaComienzaConAYEsDomingoTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder()
				.conFechaEntrada(FECHA_DOMINGO)
				.conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);
		servicioCrearEntrada.placaComienzaConLetraAYNoEsDomingoOLunes(entrada);
		// Act
		try {
			servicioCrearEntrada.ejecutar(entrada);
			fail();
		} catch (Exception e) {
			// Assert
			assertEquals(Constantes.NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL, e.getMessage());
		}

	}
	*/
	
}
