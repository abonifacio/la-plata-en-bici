package com.laplataenbici.controllers.resource.utils;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.exceptions.FordibbenException;
import com.laplataenbici.model.domain.exceptions.LPBException;

@Provider
public class LPBExceptionMapper implements ExceptionMapper<LPBException>{

	@Override
	public Response toResponse(LPBException arg0) {
		if(arg0 instanceof DBException){
			return LPBResponse.internalError(arg0.getMessage());
		}else if(arg0 instanceof FordibbenException){
			return LPBResponse.error(arg0.getMessage());
		}else{
			return LPBResponse.error(arg0.getMessage());
		}
	}

}
