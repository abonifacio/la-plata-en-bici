package com.laplataenbici.controllers.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.services.UsuarioService;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

	@Context
	UriInfo uriInfo;

	@Context
	Request request;

	private UsuarioService service;

	public UsuarioResource(){
		this.service = new UsuarioService();
	}
	
	public UsuarioResource(UriInfo uriInfo, Request request) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
	}
	
	
	@POST
	public Response createUsuario(Usuario user){
		return LPBResponse.ok(user,"Usuario creado");
	}

	@GET
	@Path("{id}")
	public Response getUsuario(@PathParam("id") Long id) throws LPBException {
//		return Response.ok(service.get(id)).build();
		Usuario u = new Usuario();
		u.setId(id);
		u.setNombre("Augusto");
		return LPBResponse.ok(u);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUsuario(String user){
		return LPBResponse.ok(user);
	}
	
}
