package com.laplataenbici.controllers.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.laplataenbici.controllers.resource.utils.AppConstants.URI;
import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.services.UsuarioService;
import com.laplataenbici.security.SecurityUtils;

@Path(URI.ACCOUNT)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

	private final UsuarioService service = new UsuarioService();
	
	@POST
	public Response create(Usuario entity,@Context UriInfo uriInfo) throws LPBException{
		Usuario tmp = service.create(entity);
		return LPBResponse.created(tmp,uriInfo, "Usuario registrado");
	}
	
	@GET
	public Response getCurrentUser(@Context HttpServletRequest request) throws LPBException {
		return LPBResponse.ok(SecurityUtils.getCurrentUser());
	}
	
	@PUT
	public Response login(Usuario entity,@Context HttpServletRequest request) throws LPBException{
		Usuario tmp = service.login(entity);
		SecurityUtils.setCurrentUser(request,tmp);
		return LPBResponse.ok(tmp);
	}
}
