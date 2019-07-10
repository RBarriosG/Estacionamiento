package com.ceiba.dominio.servicio;

import java.util.List;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionGuardarVehiculo;
import com.ceiba.dominio.excepcion.ExcepcionTipoCarro;
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
		if (validarTipoCarro(entrada))
			throw new ExcepcionTipoCarro(Constantes.TIPO_VEHICULO_NO_EXISTE);
		if (maximo30Vehiculos())
			throw new ExcepcionGuardarVehiculo(Constantes.MAXIMO_NUMERO_DE_VEHICULOS_EN_EL_PARQUEADERO);
		if (maximo20Carros(entrada))
			throw new ExcepcionGuardarVehiculo(Constantes.MAXIMO_NUMERO_DE_CARROS_EN_EL_PARQUEADERO);
		if (maximo10Motos(entrada))
			throw new ExcepcionGuardarVehiculo(Constantes.MAXIMO_NUMERO_DE_MOTOS_EN_EL_PARQUEADERO);

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
	 * El parqueadero recibe carros y motos
	 * 
	 * @param entrada
	 * @return
	 */
	private boolean validarTipoCarro(Entrada entrada) {
		if (entrada.getVehiculo().getTipo().equals(Constantes.CARRO)
				|| entrada.getVehiculo().getTipo().equals(Constantes.MOTO))
			return false;

		return true;
	}

	/**
	 * El parqueadero solo puede tener 20 carros
	 * 
	 * @param entrada
	 * @return
	 */
	private boolean maximo20Carros(Entrada entrada) {
		if (entrada.getVehiculo().getTipo().equals(Constantes.CARRO) && numeroDeCarrosEnEntradas() >= 20)
			return true;

		return false;
	}

	private int numeroDeCarrosEnEntradas() {
		int numeroCarros = 0;

		List<Entrada> entradas = repositorioEntrada.findAll();

		for (int i = 0; i < entradas.size(); i++) {
			if (entradas.get(i).getVehiculo().getTipo().equals(Constantes.CARRO)) {
				numeroCarros++;
			}
		}

		return numeroCarros;
	}

	/**
	 * El parqueadero solo puede tener 10 motos
	 * 
	 * @param entrada
	 * @return
	 */
	private boolean maximo10Motos(Entrada entrada) {
		if (entrada.getVehiculo().getTipo().equals(Constantes.MOTO) && numeroDeMotosEnEntradas() >= 10)
			return true;

		return false;
	}

	private int numeroDeMotosEnEntradas() {
		int numeroMotos = 0;

		List<Entrada> entradas = repositorioEntrada.findAll();

		for (int i = 0; i < entradas.size(); i++) {
			if (entradas.get(i).getVehiculo().getTipo().equals(Constantes.MOTO)) {
				numeroMotos++;
			}
		}

		return numeroMotos;
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
	 * Las placas que inician por la letra "A" solo pueden ingresar al parqueadero los días lunes y domingos,
	 *  de lo contrario debe mostrar un mensaje que no puede ingresar porque no está en un dia hábil
	 * @param entrada
	 * @return
	 */
	private boolean placaComienzaConLetraA(Entrada entrada) {
		return false;
	}
	
}
