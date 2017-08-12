package com.laplataenbici.model.repository.tracking;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.tracking.AbstractTracking;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.utils.query.TrackingQuery;

public interface TrackingRepository<T extends AbstractTracking<?>> extends EntityRepository<T>{
	
	Page<T> findByQuery(TrackingQuery<? extends AbstractEntity> query,Pageable page) throws DBException;
}
