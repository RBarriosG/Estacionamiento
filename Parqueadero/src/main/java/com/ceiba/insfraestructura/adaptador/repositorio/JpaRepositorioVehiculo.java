package com.ceiba.insfraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.insfraestructura.entity.VehiculoEntity;

@Repository
public interface JpaRepositorioVehiculo extends JpaRepository<VehiculoEntity, Long>{

	boolean existsByPlaca(String placa);
	
	void deleteByPlaca(String placa);
	
}
