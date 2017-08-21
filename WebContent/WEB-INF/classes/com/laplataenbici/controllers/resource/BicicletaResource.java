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
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.laplataenbici.config.AppConstants.QUERY;
import com.laplataenbici.config.AppConstants.URI;
import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.services.BicicletaService;
import com.laplataenbici.model.services.HistorialBicicletaService;
import com.laplataenbici.security.Secured;
import com.laplataenbici.security.SecurityUtils;

@Path(URI.BICICLETA)
@Produces(MediaType.APPLICATION_JSON)
public class BicicletaResource {
	
	private BicicletaService service = new BicicletaService();
	
	private HistorialBicicletaService historial = new HistorialBicicletaService();
	
	
	@POST
	@Secured(Rol.ADMIN)
	public Response create(Bicicleta entity,@Context UriInfo uriInfo) throws LPBException{
		
		return LPBResponse.created(service.create(entity),uriInfo, "Bicicleta creada");
	}

	@GET
	@Secured(Rol.ADMIN)
	public Response getAll(
			@QueryParam(QUERY.PAGE) @DefaultValue("0") Integer page,
			@QueryParam(QUERY.COUNT) @DefaultValue("25") Integer size,
			@QueryParam(QUERY.SORT) @DefaultValue("id") String sort,
			@QueryParam(QUERY.ASC) @DefaultValue("false") Boolean ascending) throws LPBException {
		return LPBResponse.ok(service.findAll(new Pageable(page, size,sort,ascending)));
	}
	
	@GET
	@Path("mis-bicicletas")
	@Secured(Rol.USER)
	public Response getAlquiladas(@Context ContainerRequestContext ctx) throws LPBException {
		return LPBResponse.ok(service.getAlquiladas(SecurityUtils.getCurrentUser(ctx)));
	}
	
	@GET
	@Path("{id}")
	@Secured
	public Response get(@PathParam("id") Long id) throws LPBException {
		return LPBResponse.ok(service.get(id));
	}
	
	@GET
	@Path("{id}/historial")
	@Secured
	public Response getHistorial(@PathParam("id") Long id) throws LPBException {
		return LPBResponse.ok(historial.findAllFor(new Bicicleta(id)));
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
	@Secured(Rol.USER)
	public Response retirar(Estacion entity,@Context ContainerRequestContext ctx) throws LPBException{
		return LPBResponse.ok(service.retirar(entity,SecurityUtils.getCurrentUser(ctx)),"Bicicleta retirada");
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("devolver")
	@Secured(Rol.USER)
	public Response devolver(Bicicleta entity,@Context ContainerRequestContext ctx) throws LPBException{
		return LPBResponse.ok(service.devolver(entity,SecurityUtils.getCurrentUser(ctx)),"Bicicleta regresada");
	}
	
	@DELETE
	@Path("{id}")
	@Secured(Rol.ADMIN)
	public Response delete(@PathParam("id") Long id) throws LPBException{
		service.delete(id);
		return LPBResponse.ok(null, "Bicicleta borrada");
	}
}
