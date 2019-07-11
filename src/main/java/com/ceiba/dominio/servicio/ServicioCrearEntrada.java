package com.ceiba.dominio.servicio;


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
		if (placaComienzaConLetraAYNoEsDomingoOLunes(entrada))
			throw new ExcepcionGuardarVehiculo(Constantes.NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL);

		this.repositorioEntrada.save(entrada);
	}

	/**
	 * Si existe una entrada con la misma placa no deja ingresar el vehiculo
	 * 
	 * @param entrada
	 * @return
	 */
	private boolean validadExistencia(Entrada entrada) {
		return this.repositorioEntrada.existsByPlaca(entrada.getVehiculo().getPlaca());
	}

	/**
	 * El parqueadero solo puede tener 20 carros
	 * 
	 * @param entrada
	 * @return
	 */
	private boolean maximo20Carros(Entrada entrada) {
		if (entrada.getVehiculo().getTipo().equals(Constantes.CARRO)
				&& repositorioEntrada.countByVehiculoTipoVehiculo(entrada.getVehiculo().getTipo()) >= 20)
			return true;

		return false;
	}

	/**
	 * El parqueadero solo puede tener 10 motos
	 * 
	 * @param entrada
	 * @return
	 */
	private boolean maximo10Motos(Entrada entrada) {
		if (entrada.getVehiculo().getTipo().equals(Constantes.MOTO)
				&& repositorioEntrada.countByVehiculoTipoVehiculo(entrada.getVehiculo().getTipo()) >= 10)
			return true;

		return false;
	}

	/**
	 * El parqueadero solo puede tener 20 carros y 10 motos simultáneamente Es decir
	 * un maximo de 30 vehiculos
	 * 
	 * @return
	 */
	private boolean maximo30Vehiculos() {
		if (repositorioEntrada.count() >= 30)
			return true;

		return false;
	}

	/**
	 * Las placas que inician por la letra "A" solo pueden ingresar al parqueadero
	 * los días lunes y domingos, de lo contrario debe mostrar un mensaje que no
	 * puede ingresar porque no está en un dia hábil
	 * 
	 * @param entrada
	 * @return
	 */
	public boolean placaComienzaConLetraAYNoEsDomingoOLunes(Entrada entrada) {
		if (entrada.getVehiculo().getPlaca().equals(Constantes.LETRA_INICIAL_PLACA_A))
			if (entrada.getFechaInicio().getDay() != Constantes.DOMINGO
					|| entrada.getFechaInicio().getDay() != Constantes.LUNES)
				return true;

		return false;
	}

}
