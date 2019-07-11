package com.ceiba.insfraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.Vehiculo;
import com.ceiba.insfraestructura.adaptador.repositorio.entity.EntradaEntity;

@Repository
public interface JpaRepositorioEntrada extends JpaRepository<EntradaEntity, Long>{
	
	boolean existsByVehiculo(Vehiculo vehiculo);
	
	Long countByVehiculoTipoVehiculo(String tipoVehiculo);
	
}
