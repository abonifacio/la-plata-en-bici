package com.laplataenbici.model.repository.utils.query;

import javax.ws.rs.core.MultivaluedMap;

public class EstacionQuery extends BaseQuery{

	public EstacionQuery(MultivaluedMap<String,String> params) {
		super(params);
	}

	@Override
	public String getQuery() {
		return "";
	}

}
