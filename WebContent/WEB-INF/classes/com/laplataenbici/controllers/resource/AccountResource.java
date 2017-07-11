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

import com.laplataenbici.controllers.resource.utils.ApiConstants;
import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.FordibbenException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.services.UsuarioService;

@Path(ApiConstants.ACCOUNT_URI)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

	private static final String SESSION_ID = "user_id";
	private final UsuarioService service = new UsuarioService();
	
	@POST
	public Response create(Usuario entity,@Context UriInfo uriInfo) throws LPBException{
		Usuario tmp = service.create(entity);
		return LPBResponse.created(tmp,uriInfo, "Usuario registrado");
	}
	
	@GET
	public Response getCurrentUser(@Context HttpServletRequest request) throws LPBException {
		Long id = (Long) request.getSession().getAttribute(SESSION_ID);
		if(id==null) throw new FordibbenException("Usuario no logeado");
		return LPBResponse.ok(service.get(id));
	}
	
	@PUT
	public Response login(Usuario entity,@Context HttpServletRequest request) throws LPBException{
		Usuario tmp = service.login(entity);
		request.getSession().setAttribute(SESSION_ID, tmp.getId());
		return LPBResponse.ok(tmp);
	}
}
