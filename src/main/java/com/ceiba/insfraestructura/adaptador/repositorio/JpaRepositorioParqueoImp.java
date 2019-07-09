package com.ceiba.insfraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.Parqueo;
import com.ceiba.dominio.puerto.repositorio.RepositorioParqueo;
import com.ceiba.insfraestructura.conversores.ConversorParqueo;
import com.ceiba.insfraestructura.entity.ParqueoEntity;

@Repository
public class JpaRepositorioParqueoImp implements RepositorioParqueo{

	JpaRepositorioParqueo jpaRepositortioParqueo;
	
	@Autowired
	public JpaRepositorioParqueoImp(JpaRepositorioParqueo jpaRepositortioParqueo) {
		this.jpaRepositortioParqueo = jpaRepositortioParqueo;
	}
	
	@Override
	public boolean existsById(Long id) {
		return jpaRepositortioParqueo.existsById(id);
	}

	@Override
	public void deleteById(Long id) {
		jpaRepositortioParqueo.deleteById(id);
	}

	@Override
	public void save(Parqueo parqueo) {
		jpaRepositortioParqueo.save(ConversorParqueo.convertirAEntity(parqueo));
	}

	@Override
	public List<Parqueo> findAll() {
		
		List<Parqueo> parqueos = new ArrayList<>();
		
		List<ParqueoEntity> parqueoEntities = jpaRepositortioParqueo.findAll();
		
		for (int i = 0; i < parqueoEntities.size(); i++) {
			parqueos.add(ConversorParqueo.convertirAModelo(parqueoEntities.get(i)));
		}
		
		return parqueos;
	}

}
