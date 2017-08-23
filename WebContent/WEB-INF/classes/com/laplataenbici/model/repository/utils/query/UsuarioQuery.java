package com.laplataenbici.model.repository.utils.query;

import javax.ws.rs.core.MultivaluedMap;

public class UsuarioQuery extends BaseQuery {

	public UsuarioQuery(MultivaluedMap<String,String> params) {
		super(params);
	}

	@Override
	public String getQuery() {
		return "";
	}

}
