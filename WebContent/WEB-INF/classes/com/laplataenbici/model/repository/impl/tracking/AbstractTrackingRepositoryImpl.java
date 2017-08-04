package com.laplataenbici.model.repository.impl.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.AbstractTracking;
import com.laplataenbici.model.domain.tracking.OperacionTracking;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.impl.EntityRepositoryImpl;
import com.laplataenbici.model.repository.tracking.TrackingRepository;

public abstract class AbstractTrackingRepositoryImpl<T extends AbstractTracking<?>> extends EntityRepositoryImpl<T> implements TrackingRepository<T>{

	@Override
	public Page<T> findByUsuario(Usuario user, Pageable page) {
		return null;
	}

	@Override
	public Page<T> findByFecha(Date fecha, Pageable page) {
		return null;
	}

	@Override
	public Page<T> findByOperacion(OperacionTracking operacion, Pageable page) {
		return null;
	}

}
