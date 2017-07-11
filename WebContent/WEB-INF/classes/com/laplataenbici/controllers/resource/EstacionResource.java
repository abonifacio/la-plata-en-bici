package com.laplataenbici.controllers.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.laplataenbici.controllers.resource.utils.ApiConstants;
import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.services.EstacionService;

@Path(ApiConstants.ESTACION_URI)
@Produces(MediaType.APPLICATION_JSON)
public class EstacionResource {
	
	private EstacionService service = new EstacionService();
	
	
	@POST
	public Response create(Estacion entity,@Context UriInfo uriInfo) throws LPBException{
		
		return LPBResponse.created(service.create(entity),uriInfo, "Estación creada");
	}

	@GET
	public Response getAll(
			@QueryParam("page") @DefaultValue("0") Integer page,
			@QueryParam("size") @DefaultValue("25") Integer size,
			@QueryParam("sort") @DefaultValue("id") String sort,
			@QueryParam("ascending") @DefaultValue("false") Boolean ascending) throws LPBException {
		return LPBResponse.ok(service.findAll(new Pageable(page, size,sort,ascending)));
	}
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Long id) throws LPBException {
		return LPBResponse.ok(service.get(id));
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Estacion entity) throws LPBException{
		return LPBResponse.ok(service.update(entity),"Estación actualizada");
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) throws LPBException{
		service.delete(id);
		return LPBResponse.ok(null, "Estación borrada");
	}
}
