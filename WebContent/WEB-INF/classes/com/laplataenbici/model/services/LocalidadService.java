package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Localidad;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.LocalidadRepository;
import com.laplataenbici.model.repository.impl.LocalidadRepositoryImpl;

public class LocalidadService extends AbstractEntityService<Localidad> {

	private LocalidadRepository repo = new LocalidadRepositoryImpl();
	
	@Override
	protected EntityRepository<Localidad> getRepo() {
		return repo;
	}

}
