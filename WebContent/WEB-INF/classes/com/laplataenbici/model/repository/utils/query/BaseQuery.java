package com.laplataenbici.model.repository.utils.query;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import com.laplataenbici.config.AppConstants.QUERY;
import com.laplataenbici.model.domain.utils.Pageable;

public abstract class BaseQuery {

	protected Map<String,Object> params;
	
	private Pageable pageable;
	
	public BaseQuery(MultivaluedMap<String,String> params){
		pageable = new Pageable(params);
		this.params = new HashMap<>();
		params.remove(QUERY.ASC);
		params.remove(QUERY.COUNT);
		params.remove(QUERY.PAGE);
		params.remove(QUERY.SORT);
		for(String key : params.keySet()){
			Object tmp = this.parse(key,params.getFirst(key));
			this.params.put(key,tmp);
		}
	}

	private Object parse(String key, String first) {
		return null;
	}

	public Map<String,Object> getParams() {
		return params;
	}

	public void setParams(Map<String,Object> params) {
		this.params = params;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}
	
	public abstract String getQuery();
	
}
