package com.laplataenbici.security;

import javax.servlet.http.HttpServletRequest;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.utils.Rol;

public class SecurityUtils {

	private static final String SESSION_ID = "user_id";
	
	
	private static Usuario cUser = null;
	
	public static boolean isUserLoggedIn(){
		return true;
	}
	
	public static boolean isUserInRole(Rol[] roles){
		for(Rol r : roles){
			if(isUserInRole(r)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isUserInRole(Rol rol){
		return true;
	}
	
	public static Usuario getCurrentUser(){
		if(cUser==null){
//			throw new RuntimeException("No hay current user");
		}
		return cUser;
	}
	
	
	public static void setCurrentUser(HttpServletRequest request, Usuario user){
		request.getSession().setAttribute(SESSION_ID,user.getId());
		cUser = user;
	}

}
