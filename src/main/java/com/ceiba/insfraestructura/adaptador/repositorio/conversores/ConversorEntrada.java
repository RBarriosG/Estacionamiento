package com.ceiba.insfraestructura.adaptador.repositorio.conversores;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.insfraestructura.adaptador.repositorio.entity.EntradaEntity;

public final class ConversorEntrada {

	private ConversorEntrada() {}	

	public static Entrada convertirAModelo(EntradaEntity entradaEntity) {
		
		Entrada entrada = null;
		
		if (entradaEntity != null) {
			entrada = new Entrada(entradaEntity.getId(),
					ConversorVehiculo.convertirAModelo(entradaEntity.getVehiculo()),
					entradaEntity.getFechaEntrada());
		}
		
		return entrada;
		
	}
	
	public static EntradaEntity convertirAEntity(Entrada parqueo) {
		
		EntradaEntity parqueoEntity = null;
		
		if (parqueo != null) {
			parqueoEntity = new EntradaEntity(ConversorVehiculo.convertirAEntity(parqueo.getVehiculo()),
							parqueo.getFechaInicio());
		}
		
		return parqueoEntity;
		
	}
	
}
