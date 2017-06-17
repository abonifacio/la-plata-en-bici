package com.laplataenbici.controllers.resource.utils;

import javax.ws.rs.core.Response;

public class LPBResponse {

	private static final String MSG_HEADER = "LPB-Message";
	
	public static Response ok(Object o){
		return Response.ok(o).build();
	}
	
	public static Response ok(Object o, String message){
		return Response.ok(o).header(MSG_HEADER, message).build();
	}
	
	public static Response error(String message){
		return Response.serverError().header(MSG_HEADER, message).build();
	}
	
	public static Response notFound(){
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	
}
