package com.laplataenbici.security;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.utils.Rol;

public class SecurityFilter implements ContainerRequestFilter{
	
	private Rol[] roles;
	
	public SecurityFilter(Rol[] roles){
		this.roles = roles;
	}

	@Override
	public void filter(ContainerRequestContext ctx) {
		
		if(!SecurityUtils.isUserLoggedIn()){
			throw new WebApplicationException(LPBResponse.unauthorized());			
		}
		if(!SecurityUtils.isUserInRole(this.roles)){
			throw new WebApplicationException(LPBResponse.fordibben("No tiene permisos para acceder a esta acción"));			
		}
		System.out.printf("%nRoles :%s", roles[0]);
		

	}

	
	
	

}
