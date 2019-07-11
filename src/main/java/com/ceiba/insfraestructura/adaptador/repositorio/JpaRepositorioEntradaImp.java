package com.ceiba.insfraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.Entrada;
import com.ceiba.dominio.puerto.repositorio.RepositorioEntrada;
import com.ceiba.insfraestructura.adaptador.repositorio.conversores.ConversorEntrada;
import com.ceiba.insfraestructura.adaptador.repositorio.entity.EntradaEntity;

@Repository
public class JpaRepositorioEntradaImp implements RepositorioEntrada {

	JpaRepositorioEntrada jpaRepositortioEntrada;

	@Autowired
	public JpaRepositorioEntradaImp(JpaRepositorioEntrada jpaRepositortioEntrada) {
		this.jpaRepositortioEntrada = jpaRepositortioEntrada;
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

	@Override
	public boolean existsByPlaca(String placa) {
		return jpaRepositortioEntrada.existsByPlaca(placa);
	}

	@Override
	public Long count() {
		return jpaRepositortioEntrada.count();
	}

	@Override
	public Long countByVehiculoTipoVehiculo(String tipoVehiculo) {
		return jpaRepositortioEntrada.countByVehiculoTipoVehiculo(tipoVehiculo);
	}


}
