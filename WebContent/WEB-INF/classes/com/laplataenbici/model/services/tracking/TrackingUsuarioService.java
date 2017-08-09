package com.laplataenbici.model.services.tracking;

import com.laplataenbici.model.domain.tracking.TrackingUsuario;
import com.laplataenbici.model.repository.impl.tracking.TrackingUsuarioRepositoryImpl;
import com.laplataenbici.model.repository.tracking.TrackingRepository;
import com.laplataenbici.model.repository.tracking.TrackingUsuarioRepository;

public class TrackingUsuarioService extends AbstractTrackingService<TrackingUsuario>{
	
	private TrackingUsuarioRepository repo = new TrackingUsuarioRepositoryImpl();

	@Override
	protected TrackingRepository<TrackingUsuario> getRepo() {
		return repo;
	}


}
