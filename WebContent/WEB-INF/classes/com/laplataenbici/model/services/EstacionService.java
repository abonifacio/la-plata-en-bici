package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.EstacionRepository;
import com.laplataenbici.model.repository.impl.EstacionRepositoryImpl;

public class EstacionService extends AbstractEntityService<Estacion>{

	
	private EstacionRepository repo = new EstacionRepositoryImpl();
		
	@Override
	protected EntityRepository<Estacion> getRepo() {
		return repo;
	}

}
