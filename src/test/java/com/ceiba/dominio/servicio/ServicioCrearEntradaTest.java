package com.ceiba.dominio.servicio;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;
import com.ceiba.dominio.testdatabuilder.EntradaTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.dominio.util.Constantes;

public class ServicioCrearEntradaTest {

	private static final LocalDateTime FECHA_DOMINGO = LocalDateTime.of(2019, 7, 7, 10, 0);
	private static final LocalDateTime FECHA_LUNES = LocalDateTime.of(2019, 7, 8, 0, 0);
	private static final LocalDateTime FECHA_MARTES = LocalDateTime.of(2019, 7, 9, 0, 0);

	private static final String PLACA_COMIENZA_CON_A = "ABC456";
	private static final String PLACA_NO_COMIENZA_CON_A = "CFR097";

	@Test
	public void validarExistenciaEntradaTest() {
		// arrange
		Entrada entrada = new EntradaTestDataBuilder().build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		Mockito.when(repositorioEntrada.existsByVehiculo(Mockito.any())).thenReturn(true);
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

	@Test
	public void placaComienzaConAYNoEsDDiaHabilTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder().conFechaEntrada(FECHA_MARTES).conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);
		servicioCrearEntrada.placaComienzaConLetraAYEsDiaHabil(entrada);
		// Act
		try {
			servicioCrearEntrada.ejecutar(entrada);
			fail();
		} catch (Exception e) {
			// Assert
			assertEquals(Constantes.NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL, e.getMessage());
		}

	}

	@Test
	public void placaComienzaConAYEsDiaHabilDomingoTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder().conFechaEntrada(FECHA_DOMINGO).conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);

		// Act
		boolean pasaSiFalso = servicioCrearEntrada.placaComienzaConLetraAYEsDiaHabil(entrada);
		// assert
		assertFalse(pasaSiFalso);
	}

	@Test
	public void placaComienzaConAYEsDiaHabilLunesTest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder().conFechaEntrada(FECHA_LUNES).conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);

		// Act
		boolean pasaSiFalso = servicioCrearEntrada.placaComienzaConLetraAYEsDiaHabil(entrada);
		// assert
		assertFalse(pasaSiFalso);
	}

	@Test
	public void placaNComienzaConATest() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_NO_COMIENZA_CON_A).build();
		Entrada entrada = new EntradaTestDataBuilder().conVechiculo(vehiculo).build();
		RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
		ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);
		servicioCrearEntrada.placaComienzaConLetraAYEsDiaHabil(entrada);
		// Act
		try {
			servicioCrearEntrada.ejecutar(entrada);
			fail();
		} catch (Exception e) {
			// Assert
			assertEquals(Constantes.NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL, e.getMessage());
		}

	}

}
