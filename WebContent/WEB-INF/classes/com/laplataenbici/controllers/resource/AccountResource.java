package com.laplataenbici.controllers.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.services.UsuarioService;
import com.laplataenbici.security.Secured;
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
	@Secured
	public Response getCurrentUser(@Context HttpServletRequest request,@Context ContainerRequestContext ctx) throws LPBException {
		return LPBResponse.ok(SecurityUtils.getCurrentUser(ctx));
	}
	
	@PUT
	public Response login(Usuario entity,@Context HttpServletResponse response) throws LPBException{
		Usuario tmp = service.login(entity);
		SecurityUtils.sendToken(response, tmp);
		return LPBResponse.ok(tmp);
	}
	
	@GET
	@Path("check/username/{username}")
	public Response checkUsername(@PathParam("username") String username) throws LPBException{
		return LPBResponse.ok(service.isUsernameAvailable(username));
	}
	
	@GET
	@Path("check/email/{email}")
	public Response checkEmail(@PathParam("email") String email) throws LPBException{
		return LPBResponse.ok(service.isEmailAvailable(email));
	}
}
