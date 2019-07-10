package com.ceiba.insfraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;
import com.ceiba.insfraestructura.conversores.ConversorEntrada;
import com.ceiba.insfraestructura.entity.EntradaEntity;

@Repository
public class JpaRepositorioEntradaImp implements RepositorioEntrada{

	JpaRepositorioEntrada jpaRepositortioEntrada;
	
	@Autowired
	public JpaRepositorioEntradaImp(JpaRepositorioEntrada jpaRepositortioEntrada) {
		this.jpaRepositortioEntrada = jpaRepositortioEntrada;
	}
	
	@Override
	public boolean existsById(Long id) {
		return jpaRepositortioEntrada.existsById(id);
	}

	@Override
	public void deleteById(Long id) {
		jpaRepositortioEntrada.deleteById(id);
	}

	@Override
	public void save(Entrada entrada) {
		jpaRepositortioEntrada.save(ConversorEntrada.convertirAEntity(entrada));
	}

	@Override
	public List<Entrada> findAll() {
		
		List<Entrada> entradas = new ArrayList<>();
		
		List<EntradaEntity> parqueoEntities = jpaRepositortioEntrada.findAll();
		
		for (int i = 0; i < parqueoEntities.size(); i++) {
			entradas.add(ConversorEntrada.convertirAModelo(parqueoEntities.get(i)));
		}
		
		return entradas;
	}

}
