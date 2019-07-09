package com.ceiba.insfraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.insfraestructura.entity.ParqueoEntity;

@Repository
public interface JpaRepositorioParqueo extends JpaRepository<ParqueoEntity, Long>{

}
