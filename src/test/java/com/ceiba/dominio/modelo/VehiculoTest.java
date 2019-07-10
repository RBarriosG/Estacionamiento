package com.ceiba.dominio.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ceiba.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {

	private static final String TIPO_VEHICULO_INVALIDO = "Tipo vehiculo invalido";
	private static final int CILINDRAJE_VALOR_0 = 0;

	@Test
	public void validarPlacaObligatoriaTest() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conPlaca(null);

		// Act
		try {
			vehiculoTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Vehiculo.PLACA_SIN_VALOR, e.getMessage());
		}
	}

	@Test
	public void validarTipoObligatorioTest() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conTipo(null);

		// Act
		try {
			vehiculoTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Vehiculo.TIPO_SIN_VALOR, e.getMessage());
		}
	}

	@Test
	public void validarCilindrajeObligatorioMotoTest() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conCilindraje(CILINDRAJE_VALOR_0);
		vehiculoTestDataBuilder.conTipo(ValidadorArgumento.MOTO);

		// Act
		try {
			vehiculoTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Vehiculo.VEHICULO_TIPO_MOTO_NECESITA_CILINDRAJE, e.getMessage());
		}
	}

	@Test
	public void validarTipoVehiculoCarro() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		// Act
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		// asseert
		assertEquals(ValidadorArgumento.CARRO, vehiculo.getTipo());
	}

	@Test
	public void validarTipoVehiculoMoto() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conTipo("MOTO");
		// Act
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		// asseert
		assertEquals(ValidadorArgumento.MOTO, vehiculo.getTipo());
	}

	@Test
	public void validarTipoVehiculoExcepcion() {
		// Arrenge
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conTipo(TIPO_VEHICULO_INVALIDO);
		// Act
		try {
			vehiculoTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Vehiculo.TIPO_VEHICULO_NO_EXISTE , e.getMessage());
		}
	}
}
