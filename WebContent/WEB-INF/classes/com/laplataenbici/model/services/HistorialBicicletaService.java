package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.HistorialBicicleta;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.HistorialBicicletaRepository;
import com.laplataenbici.model.repository.impl.HistorialBicicletaRepositoryImpl;

public class HistorialBicicletaService extends AbstractEntityService<HistorialBicicleta> {

	private HistorialBicicletaRepository repo = new HistorialBicicletaRepositoryImpl();
	
	@Override
	protected EntityRepository<HistorialBicicleta> getRepo() {
		return repo;
	}
	
	public Page<HistorialBicicleta> findAllFor(Pageable pageable,Bicicleta b) throws LPBException{
		return repo.findAllFor(pageable,b);
	}
	
	@Override
	public void checkDelete(HistorialBicicleta e) throws LPBException {
		throw new BusinessException("El historial no se puede borrar");
	}

}
