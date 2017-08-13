package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.HistorialBicicleta;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.HistorialBicicletaRepository;
import com.laplataenbici.model.repository.impl.HistorialBicicletaRepositoryImpl;

public class HistorialBicicletaService extends AbstractEntityService<HistorialBicicleta> {

	private HistorialBicicletaRepository repo = new HistorialBicicletaRepositoryImpl();
	
	@Override
	protected EntityRepository<HistorialBicicleta> getRepo() {
		return repo;
	}

}
