package com.laplataenbici.model.services.tracking;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.tracking.AbstractTracking;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.tracking.TrackingRepository;
import com.laplataenbici.model.repository.utils.query.TrackingQuery;
import com.laplataenbici.model.services.AbstractEntityService;

public abstract class AbstractTrackingService<T extends AbstractTracking<?>> extends AbstractEntityService<T>{
	
	
	@Override
	protected abstract TrackingRepository<T> getRepo();
	

	public Page<T> findByQuery(TrackingQuery<? extends AbstractEntity> query,Pageable pageable) throws DBException{
		return getRepo().findByQuery(query, pageable);
	}
	
}