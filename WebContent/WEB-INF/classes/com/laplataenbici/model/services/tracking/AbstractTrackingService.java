package com.laplataenbici.model.services.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.AbstractTracking;
import com.laplataenbici.model.domain.tracking.OperacionTracking;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.tracking.TrackingRepository;
import com.laplataenbici.model.services.AbstractEntityService;

public abstract class AbstractTrackingService<T extends AbstractTracking<?>> extends AbstractEntityService<T>{
	
	
	@Override
	protected abstract TrackingRepository<T> getRepo();
	
	public Page<T> findByFecha(Date fecha, Pageable page){
		return getRepo().findByFecha(fecha, page);
	}
	
	public Page<T> findByOperacion(OperacionTracking operacion, Pageable page){
		return getRepo().findByOperacion(operacion, page);
	}
	
	public Page<T> findByUsuario(Usuario user, Pageable page){
		return getRepo().findByUsuario(user, page);
	}
}