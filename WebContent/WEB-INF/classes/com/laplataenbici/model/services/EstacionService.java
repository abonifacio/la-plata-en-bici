package com.laplataenbici.model.services;

import java.util.List;

import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.exceptions.LPBException;
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
	
	@Override
	public void checkDelete(Estacion e) throws LPBException {
		if(e.getOcupacion()>0){
			throw new BusinessException("La estación no se puede borrar porque tiene bicicletas");
		}
	}
}
