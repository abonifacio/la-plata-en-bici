package com.laplataenbici.model.services.tracking;

import com.laplataenbici.model.domain.tracking.TrackingEstacion;
import com.laplataenbici.model.repository.impl.tracking.TrackingEstacionRepositoryImpl;
import com.laplataenbici.model.repository.tracking.TrackingEstacionRepository;
import com.laplataenbici.model.repository.tracking.TrackingRepository;

public class TrackingEstacionService extends AbstractTrackingService<TrackingEstacion>{
	
	private TrackingEstacionRepository repo = new TrackingEstacionRepositoryImpl();

	@Override
	protected TrackingRepository<TrackingEstacion> getRepo() {
		return repo;
	}


}