package com.laplataenbici.model.services;

import java.util.List;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.HistorialBicicleta;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.HistorialBicicletaRepository;
import com.laplataenbici.model.repository.impl.HistorialBicicletaRepositoryImpl;

public class HistorialBicicletaService extends AbstractEntityService<HistorialBicicleta> {

	private HistorialBicicletaRepository repo = new HistorialBicicletaRepositoryImpl();
	
	@Override
	protected EntityRepository<HistorialBicicleta> getRepo() {
		return repo;
	}
	
	public List<HistorialBicicleta> findAllFor(Bicicleta b) throws LPBException{
		return repo.findAllFor(b);
	}

}
