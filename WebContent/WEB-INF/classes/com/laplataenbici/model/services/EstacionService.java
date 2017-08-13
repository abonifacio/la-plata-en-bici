package com.laplataenbici.model.services;

import java.util.List;

import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.EstadoEstacion;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.EstacionRepository;
import com.laplataenbici.model.repository.impl.EstacionRepositoryImpl;

public class EstacionService extends AbstractEntityService<Estacion>{

	
	private EstacionRepository repo = new EstacionRepositoryImpl();
	
	@Override
	protected EntityRepository<Estacion> getRepo() {
		return repo;
	}
	
	@Override
	public Page<Estacion> findAll(Pageable pageable) throws DBException {
		Page<Estacion> tmp = super.findAll(pageable);
		for(Estacion e : tmp.getItems()){
			e.setOcupacion(e.getBicicletas().size());
		}
		return tmp;
	}

	public List<Estacion> getAvailables() throws DBException {
		List<Estacion> estaciones = repo.findAllByEstado(EstadoEstacion.OPERATIVA);
//		estaciones.removeIf((e)->{
//			e.getBicicletas().removeIf((b)-> !EstadoBicicleta.APTA.equals(b.getEstado()));
//			return e.getBicicletas().size()==0;
//		});
		return estaciones;
	}
	
}
