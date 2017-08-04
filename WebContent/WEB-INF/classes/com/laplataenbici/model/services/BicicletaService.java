package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.repository.BicicletaRepository;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.impl.BicicletaRepositoryImpl;
import com.laplataenbici.model.services.tracking.AbstractTrackableService;
import com.laplataenbici.model.services.tracking.AbstractTrackingService;
import com.laplataenbici.model.services.tracking.TrackingBicicletaService;

public class BicicletaService extends AbstractTrackableService<Bicicleta,TrackingBicicleta>{

	
	private BicicletaRepository repo = new BicicletaRepositoryImpl();
	
	private TrackingBicicletaService trackingService = new TrackingBicicletaService();
		
	@Override
	protected EntityRepository<Bicicleta> getRepo() {
		return repo;
	}

	@Override
	public TrackingBicicleta createTracking() {
		return new TrackingBicicleta();
	}

	@Override
	public AbstractTrackingService<TrackingBicicleta> getTrackingService() {
		return trackingService;
	}

}
