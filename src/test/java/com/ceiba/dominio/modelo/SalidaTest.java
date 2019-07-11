package com.ceiba.dominio.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ceiba.dominio.testdatabuilder.SalidaTestDataBuilder;


public class SalidaTest {

	private static final double VALOR_0 = 0;


	@Test
	public void validarIdObligatorioTest() {
		// Arrenge
		SalidaTestDataBuilder salidaTestDataBuilder = new SalidaTestDataBuilder();
		salidaTestDataBuilder.conId(null);

		// Act
		try {
			salidaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Salida.ID_NULO, e.getMessage());
		}
	}
	
	@Test
	public void validarEntradaObligatoriaTest() {
		// Arrenge
		SalidaTestDataBuilder salidaTestDataBuilder = new SalidaTestDataBuilder();
		salidaTestDataBuilder.conEntrada(null);

		// Act
		try {
			salidaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Salida.ENTRADA_NULA, e.getMessage());
		}
	}
	
	
	@Test
	public void validarFechaSalidaObligatoriaTest() {
		// Arrenge
		SalidaTestDataBuilder salidaTestDataBuilder = new SalidaTestDataBuilder();
		salidaTestDataBuilder.conFechaSalida(null);

		// Act
		try {
			salidaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Salida.FECHA_SALIDA_NULA, e.getMessage());
		}
	}
	
	
	@Test
	public void validarValorObligatoriaTest() {
		// Arrenge
		SalidaTestDataBuilder salidaTestDataBuilder = new SalidaTestDataBuilder();
		salidaTestDataBuilder.conValor(VALOR_0);

		// Act
		try {
			salidaTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			// assert
			assertEquals(Salida.VALOR_IGUAL_A_0, e.getMessage());
		}
	}

}
