package com.ceiba.insfraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.insfraestructura.conversores.ConversorVehiculo;
import com.ceiba.insfraestructura.entity.VehiculoEntity;

@Repository
public class JpaRepositorioVehiculoImp implements RepositorioVehiculo{

	@Autowired
	JpaRepositorioVehiculo jpaRepositorioVehiculo;
	
	
	@Override
	public boolean existsByPlaca(String placa) {
		return jpaRepositorioVehiculo.existsByPlaca(placa);
	}

	@Override
	public void deleteByPlaca(String placa) {
		jpaRepositorioVehiculo.deleteByPlaca(placa);
	}

	@Override
	public void save(Vehiculo vehiculo) {
		jpaRepositorioVehiculo.save(ConversorVehiculo.convertirAEntity(vehiculo));
	}

	@Override
	public List<Vehiculo> findAll() {
		List<Vehiculo> vehiculos = new ArrayList<>();
		
		List<VehiculoEntity> vehiculosEntities = this.jpaRepositorioVehiculo.findAll();
		
		for (int i = 0; i < vehiculosEntities.size(); i++) {
			vehiculos.add(ConversorVehiculo.convertirAModelo(vehiculosEntities.get(i)));
		}
		
		return vehiculos; 
	}

}
