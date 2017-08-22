package com.laplataenbici.model.services;

import java.util.List;

import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.EstacionRepository;
import com.laplataenbici.model.repository.impl.EstacionRepositoryImpl;

public class EstacionService extends AbstractEntityService<Estacion>{

	
	private EstacionRepository repo = new EstacionRepositoryImpl();
	
	@Override
	protected EntityRepository<Estacion> getRepo() {
		return repo;
	}
	
	public List<Estacion> getAvailables() throws DBException {
		List<Estacion> estaciones = repo.findAvailables();
		return estaciones;
	}

	public List<Estacion> getConCapacidad() throws DBException {
		return repo.findConCapacidad();
	}
}
