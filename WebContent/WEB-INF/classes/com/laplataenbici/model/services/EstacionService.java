package com.laplataenbici.model.services;

import java.util.List;

import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.tracking.TrackingEstacion;
import com.laplataenbici.model.domain.utils.EstadoEstacion;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.EstacionRepository;
import com.laplataenbici.model.repository.impl.EstacionRepositoryImpl;
import com.laplataenbici.model.services.tracking.AbstractTrackableService;
import com.laplataenbici.model.services.tracking.AbstractTrackingService;
import com.laplataenbici.model.services.tracking.TrackingEstacionService;

public class EstacionService extends AbstractTrackableService<Estacion,TrackingEstacion>{

	
	private EstacionRepository repo = new EstacionRepositoryImpl();
	
	private TrackingEstacionService trackingService = new TrackingEstacionService();
		
	@Override
	protected EntityRepository<Estacion> getRepo() {
		return repo;
	}

	@Override
	public TrackingEstacion createTracking() {
		return new TrackingEstacion();
	}

	@Override
	public AbstractTrackingService<TrackingEstacion> getTrackingService() {
		return trackingService;
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
