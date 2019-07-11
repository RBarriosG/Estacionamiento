package com.ceiba.dominio.servicio;

import java.time.DayOfWeek;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionGuardarVehiculo;
import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;
import com.ceiba.dominio.util.Constantes;

public class ServicioCrearEntrada {

	private RepositorioEntrada repositorioEntrada;

	public ServicioCrearEntrada(RepositorioEntrada repositorioEntrada) {
		this.repositorioEntrada = repositorioEntrada;
	}

	public void ejecutar(Entrada entrada) {

		if (validadExistencia(entrada))
			throw new ExcepcionDuplicidad(Constantes.VEHICULO_YA_EXISTE_EN_EL_PARQUEADERO);
		if (maximo30Vehiculos())
			throw new ExcepcionGuardarVehiculo(Constantes.MAXIMO_NUMERO_DE_VEHICULOS_EN_EL_PARQUEADERO);
		if (maximo20Carros(entrada))
			throw new ExcepcionGuardarVehiculo(Constantes.MAXIMO_NUMERO_DE_CARROS_EN_EL_PARQUEADERO);
		if (maximo10Motos(entrada))
			throw new ExcepcionGuardarVehiculo(Constantes.MAXIMO_NUMERO_DE_MOTOS_EN_EL_PARQUEADERO);
		if (placaComienzaConLetraAYEsDiaHabil(entrada))
			throw new ExcepcionGuardarVehiculo(Constantes.NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL);

		this.repositorioEntrada.save(entrada);
	}

	private boolean validadExistencia(Entrada entrada) {
		return this.repositorioEntrada.existsByVehiculo(entrada.getVehiculo());
	}

	private boolean maximo20Carros(Entrada entrada) {
		if (entrada.getVehiculo().getTipo().equals(Constantes.CARRO)
				&& repositorioEntrada.countByVehiculoTipoVehiculo(entrada.getVehiculo().getTipo()) >= 20)
			return true;

		return false;
	}

	private boolean maximo10Motos(Entrada entrada) {
		if (entrada.getVehiculo().getTipo().equals(Constantes.MOTO)
				&& repositorioEntrada.countByVehiculoTipoVehiculo(entrada.getVehiculo().getTipo()) >= 10)
			return true;

		return false;
	}

	private boolean maximo30Vehiculos() {
		if (repositorioEntrada.count() >= 30)
			return true;

		return false;
	}

	public boolean placaComienzaConLetraAYEsDiaHabil(Entrada entrada) {
		if (!(entrada.getVehiculo().getPlaca().startsWith(Constantes.LETRA_INICIAL_PLACA_A) && esDiaHabil(entrada)))
			return true;

		return false;
	}

	private boolean esDiaHabil(Entrada entrada) {
		if (entrada.getFechaInicio().getDayOfWeek() == DayOfWeek.SUNDAY
				|| entrada.getFechaInicio().getDayOfWeek() == DayOfWeek.MONDAY)
			return true;
		return false;
	}

}
