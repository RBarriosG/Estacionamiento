package com.ceiba.insfraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.insfraestructura.entity.EntradaEntity;

@Repository
public interface JpaRepositorioEntrada extends JpaRepository<EntradaEntity, Long>{
	
	boolean existsByPlaca(String placa);
	
	Long countByVehiculoTipoVehiculo(String tipoVehiculo);
	
}
