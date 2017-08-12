package com.laplataenbici.model.repository.impl.tracking;

import java.util.HashMap;
import java.util.Map;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.tracking.AbstractTracking;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.impl.EntityRepositoryImpl;
import com.laplataenbici.model.repository.tracking.TrackingRepository;
import com.laplataenbici.model.repository.utils.FindAllHelper;
import com.laplataenbici.model.repository.utils.query.TrackingQuery;

public abstract class AbstractTrackingRepositoryImpl<T extends AbstractTracking<?>> extends EntityRepositoryImpl<T> implements TrackingRepository<T>{
	
	@Override
	public Page<T> findByQuery(TrackingQuery<? extends AbstractEntity> query, Pageable pageable) throws DBException {
		FindAllHelper<T> fh = new FindAllHelper<>(this.getTabla(),this.getAllowedFields());
		StringBuilder sb = new StringBuilder();
		Map<String,Object> params = new HashMap<>();
		sb.append(" 1=1");
		if(query.getDesde()!=null && query.getHasta()!=null){
			sb.append(" and fecha >= :desde");
			params.put("desde", query.getDesde());
			sb.append(" and fecha <= :hasta");
			params.put("hasta", query.getHasta());
		}
		if(query.getOperacion()!=null){
			sb.append(" and operacion = :operacion");
			params.put("operacion",query.getOperacion());
		}
		if(query.getUser()!=null){
			sb.append(" and modificadorPor = :user");
			params.put("user", query.getUser());
		}
		if(query.getEntidad()!=null){
			sb.append(" and entity = :entidad");
			params.put("entidad", query.getEntidad());
		}
		return fh.go(pageable,sb.toString(),params);
	}

}
