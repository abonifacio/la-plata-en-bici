package com.laplataenbici.security;

import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.services.UsuarioService;

public class SecurityUtils {

	public static final String SESSION_ID = "user_id";
	public static final String SESSION_PROPERTY = "Session";
	
	private static final UsuarioService usuarios = new UsuarioService();
	
	public static boolean isUserLoggedIn(HttpServletRequest req){
		return req.getSession(true).getAttribute(SESSION_ID)!=null;
	}
	
	public static boolean isUserLoggedIn(ContainerRequestContext ctx){
		return ctx.getProperty(SESSION_PROPERTY)!=null;
	}
	
	public static boolean isUserInRole(Rol[] roles,ContainerRequestContext ctx) throws LPBException{
		Usuario u = usuarios.get((Long) (ctx.getProperty(SESSION_PROPERTY)));
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
	
	
	public static Usuario getCurrentUser(HttpServletRequest req) throws LPBException{
		if(!isUserLoggedIn(req)){
			throw new BusinessException("El usuario no está loggeado");
		}
		Long id = (Long) req.getSession(true).getAttribute(SESSION_ID);
		return usuarios.get(id);
	}
	
	public static Long getCurrentUserId(HttpServletRequest req) throws LPBException{
		if(!isUserLoggedIn(req)){
			throw new BusinessException("El usuario no está loggeado");
		}
		return (Long) req.getSession(true).getAttribute(SESSION_ID);
		
	}

	public static void setCurrentUser(HttpServletRequest request, Usuario tmp) {
		request.getSession(true).setAttribute(SESSION_ID, tmp.getId());
	}
	
	public static String generateToken(){
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		return bytes.toString();
	}

}
