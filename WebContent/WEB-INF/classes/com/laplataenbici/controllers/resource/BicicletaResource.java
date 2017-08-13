package com.laplataenbici.controllers.resource;

import javax.servlet.http.HttpServletRequest;
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

import com.laplataenbici.controllers.resource.utils.AppConstants.QUERY;
import com.laplataenbici.controllers.resource.utils.AppConstants.URI;
import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.services.BicicletaService;
import com.laplataenbici.security.Secured;
import com.laplataenbici.security.SecurityUtils;

@Path(URI.BICICLETA)
@Produces(MediaType.APPLICATION_JSON)
public class BicicletaResource {
	
	private BicicletaService service = new BicicletaService();
	
	
	@POST
	@Secured
	public Response create(Bicicleta entity,@Context UriInfo uriInfo) throws LPBException{
		
		return LPBResponse.created(service.create(entity),uriInfo, "Bicicleta creada");
	}

	@GET
	@Secured
	public Response getAll(
			@QueryParam(QUERY.PAGE) @DefaultValue("0") Integer page,
			@QueryParam(QUERY.COUNT) @DefaultValue("25") Integer size,
			@QueryParam(QUERY.SORT) @DefaultValue("id") String sort,
			@QueryParam(QUERY.ASC) @DefaultValue("false") Boolean ascending) throws LPBException {
		return LPBResponse.ok(service.findAll(new Pageable(page, size,sort,ascending)));
	}
	
	@GET
	@Path("{id}")
	@Secured
	public Response get(@PathParam("id") Long id) throws LPBException {
		return LPBResponse.ok(service.get(id));
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Secured(Rol.ADMIN)
	public Response update(Bicicleta entity) throws LPBException{
		return LPBResponse.ok(service.update(entity),"Bicicleta actualizada");
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("retirar")
	@Secured
	public Response retirar(Bicicleta entity,@Context HttpServletRequest request) throws LPBException{
		return LPBResponse.ok(service.retirar(entity,SecurityUtils.getCurrentUser(request)),"Bicicleta retirada");
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("devolver")
	@Secured
	public Response devolver(Bicicleta entity,@Context HttpServletRequest request) throws LPBException{
		return LPBResponse.ok(service.devolver(entity,SecurityUtils.getCurrentUser(request)),"Bicicleta regresada");
	}
	
	@DELETE
	@Path("{id}")
	@Secured
	public Response delete(@PathParam("id") Long id) throws LPBException{
		service.delete(id);
		return LPBResponse.ok(null, "Bicicleta borrada");
	}
}
