package com.laplataenbici.model.services.tracking;

import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.repository.impl.tracking.TrackingBicicletaRepositoryImpl;
import com.laplataenbici.model.repository.tracking.TrackingBicicletaRepository;
import com.laplataenbici.model.repository.tracking.TrackingRepository;

public class TrackingBicicletaService extends AbstractTrackingService<TrackingBicicleta>{
	
	private TrackingBicicletaRepository repo = new TrackingBicicletaRepositoryImpl();

	@Override
	protected TrackingRepository<TrackingBicicleta> getRepo() {
		return repo;
	}


}