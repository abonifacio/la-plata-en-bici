package com.laplataenbici.model.repository.utils.query;

import javax.ws.rs.core.MultivaluedMap;

public class BicicletaQuery extends BaseQuery {

	public BicicletaQuery(MultivaluedMap<String,String> params) {
		super(params);
	}

	@Override
	public String getQuery() {
		return "";
	}

}
