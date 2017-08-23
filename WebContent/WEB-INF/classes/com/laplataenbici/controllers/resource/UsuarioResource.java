package com.laplataenbici.controllers.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.laplataenbici.config.AppConstants.URI;
import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.EstadoUsuario;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.repository.utils.query.UsuarioQuery;
import com.laplataenbici.model.services.UsuarioService;
import com.laplataenbici.security.Secured;
import com.laplataenbici.security.SecurityUtils;


@Path(URI.USUARIO)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {


	private UsuarioService service = new UsuarioService();
	

	@GET
	@Secured(Rol.ADMIN)
	public Response getAll(@Context UriInfo uri) throws LPBException {
		return LPBResponse.ok(service.findAll(new UsuarioQuery(uri.getQueryParameters())));
	}
	
	@GET
	@Path("{id}")
	@Secured(Rol.ADMIN)
	public Response get(@PathParam("id") Long id) throws LPBException {
		return LPBResponse.ok(service.get(id));
	}
	

	@PUT
	@Path("activar/{id}")
	@Secured(Rol.ADMIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response activar(EstadoUsuario estado,@PathParam("id")Long id) throws LPBException{
		return LPBResponse.ok(service.setActivo(id,estado),"Usuario " + estado.getValue().toLowerCase());
	}
	
	@PUT
	@Path("rol/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Secured(Rol.ADMIN)
	public Response setRol(Rol rol,@PathParam("id") Long id, @Context ContainerRequestContext ctx) throws LPBException{
		Usuario u = new Usuario(id);
		if(SecurityUtils.isCurrentUser(ctx, u)){
			throw new BusinessException("El usuario no puede cambiar su propio rol");
		}
		return LPBResponse.ok(service.setRol(id, rol),"El usuario tiene ahora rol "+rol.name());
	}
	
}
