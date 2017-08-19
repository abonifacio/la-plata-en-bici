package com.laplataenbici.security;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.Rol;

public class SecurityFilter implements ContainerRequestFilter{
	
	private Rol[] roles;
	
	public SecurityFilter(Rol[] roles){
		this.roles = roles;
	}

	@Override
	public void filter(ContainerRequestContext ctx) {
		
		if(!SecurityUtils.isUserLoggedIn(ctx)){
			throw new WebApplicationException(LPBResponse.unauthorized());			
		}
		try {
			if(!SecurityUtils.isUserInRole(this.roles,ctx)){
				throw new WebApplicationException(LPBResponse.fordibben("No tiene permisos para acceder a esta acción"));			
			}
		} catch (LPBException e) {
			e.printStackTrace();
			throw new WebApplicationException(LPBResponse.error(e.getMessage()));			
		}
		System.out.printf("%nRoles :%s", roles[0]);
		

	}

	
	
	

}
