package com.laplataenbici.security;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.exceptions.UnauthorizedException;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.services.UsuarioService;

public class SecurityUtils {

	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";

	private static final UsuarioService usuarios = new UsuarioService();
	
	public static boolean isUserLoggedIn(ContainerRequestContext ctx){
		return ctx.getHeaderString(AUTHORIZATION_HEADER)!=null;
	}
	
	public static boolean isUserInRole(Rol[] roles,ContainerRequestContext ctx) throws LPBException{
		Usuario u = usuarios.get(getCurrentUserId(ctx));
		for(Rol r : roles){
			if(isUserInRole(r,u)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isUserInRole(Rol rol,Usuario u){
		return rol.equals(u.getRol());
	}
	
	public static Usuario getCurrentUser(ContainerRequestContext ctx) throws LPBException{
		return usuarios.get(getCurrentUserId(ctx));
	}
	
	private static Long getCurrentUserId(ContainerRequestContext ctx) throws LPBException{
		String token = ctx.getHeaderString(AUTHORIZATION_HEADER);
		Long id = CryptoUtils.getInstance().getUserId(token.substring(TOKEN_PREFIX.length()));
		if(id==null){
			throw new UnauthorizedException();
		}
		return id;
	}

	
	public static boolean isCurrentUser(ContainerRequestContext ctx,Usuario user) throws LPBException{
		return getCurrentUserId(ctx).equals(user.getId());
	}
	
	public static void sendToken(HttpServletResponse res,Usuario u){
		res.addHeader(AUTHORIZATION_HEADER, TOKEN_PREFIX + CryptoUtils.getInstance().generateToken(u));
	}

}
