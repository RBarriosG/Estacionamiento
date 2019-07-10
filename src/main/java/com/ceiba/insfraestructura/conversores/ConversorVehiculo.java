package com.ceiba.insfraestructura.conversores;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.insfraestructura.entity.VehiculoEntity;

public final class ConversorVehiculo {

	private ConversorVehiculo() {}
	
	public static Vehiculo convertirAModelo(VehiculoEntity vehiculoEntity) {
		
	Vehiculo vehiculo = null;
		
		if (vehiculoEntity != null) {
			vehiculo = new Vehiculo(vehiculoEntity.getPlaca(),
									vehiculoEntity.getTipo(),
									vehiculoEntity.getCilindraje());
		}
		
		return vehiculo;
	}

	public static VehiculoEntity convertirAEntity(Vehiculo vehiculo) {
		
		VehiculoEntity vehiculoEntity = null;
		
		if (vehiculo != null) {
			vehiculoEntity =  new VehiculoEntity(vehiculo.getPlaca(),
					vehiculo.getTipo(),
					vehiculo.getCilindraje());
		}
		
		return vehiculoEntity;
	}
	
}
