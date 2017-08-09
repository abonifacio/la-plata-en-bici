package com.laplataenbici.controllers.resource.utils;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.laplataenbici.model.domain.AbstractEntity;

public class LPBResponse {

	private static final String MSG_HEADER = "LPB-Message";
	
	public static Response ok(Object o){
		return Response.ok(o).build();
	}
	
	public static Response ok(Object o,String message){
		return Response.ok(o).header(MSG_HEADER, message).build();
	}
	
	public static Response created(AbstractEntity o,UriInfo location, String message){
		UriBuilder ub = location.getAbsolutePathBuilder();
		ub.path(String.valueOf(o.getId()));
		
		return Response.created(ub.build()).header(MSG_HEADER, message).entity(o).build();
	}
	
	public static Response internalError(String message){
		return Response.serverError().header(MSG_HEADER, message).build();
	}
	
	public static Response error(String message){
		return Response.status(Response.Status.BAD_REQUEST).header(MSG_HEADER, message).build();
	}
	
	public static Response fordibben(String message){
		return Response.status(Response.Status.FORBIDDEN).header(MSG_HEADER, message).build();
	}
	
	public static Response unauthorized(){
		return Response.status(Response.Status.UNAUTHORIZED).header(MSG_HEADER, "El usuario no está logeado").build();
	}
	
	public static Response notFound(){
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	
}
