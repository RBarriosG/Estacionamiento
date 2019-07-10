package com.ceiba.insfraestructura.conversores;

import com.ceiba.dominio.modelo.Parqueo;
import com.ceiba.insfraestructura.entity.ParqueoEntity;

public final class ConversorParqueo {

	private ConversorParqueo() {}	

	public static Parqueo convertirAModelo(ParqueoEntity parqueoEntity) {
		
		Parqueo parqueo = null;
		
		if (parqueoEntity != null) {
			parqueo = new Parqueo(parqueoEntity.getId(),
					ConversorVehiculo.convertirAModelo(parqueoEntity.getVehiculo()),
					parqueoEntity.getFechaInicio(),
					parqueoEntity.getFechaFin(),
					parqueoEntity.getValor());
		}
		
		return parqueo;
		
	}
	
	public static ParqueoEntity convertirAEntity(Parqueo parqueo) {
		
		ParqueoEntity parqueoEntity = null;
		
		if (parqueo != null) {
			parqueoEntity = new ParqueoEntity(ConversorVehiculo.convertirAEntity(parqueo.getVehiculo()),
							parqueo.getFechaInicio(),
							parqueo.getFechaFin(),
							parqueo.getValor());
		}
		
		return parqueoEntity;
		
	}
	
}
