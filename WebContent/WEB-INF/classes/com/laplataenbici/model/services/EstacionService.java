package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.tracking.TrackingEstacion;
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

}
