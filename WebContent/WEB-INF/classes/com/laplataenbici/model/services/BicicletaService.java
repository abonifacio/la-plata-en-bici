package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.repository.BicicletaRepository;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.impl.BicicletaRepositoryImpl;

public class BicicletaService extends AbstractEntityService<Bicicleta>{
	
	private BicicletaRepository repo = new BicicletaRepositoryImpl();;
	

	@Override
	protected EntityRepository<Bicicleta> getRepo() {
		return repo;
	}
	

}
