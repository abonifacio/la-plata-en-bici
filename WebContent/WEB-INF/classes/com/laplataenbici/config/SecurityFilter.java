package com.laplataenbici.config;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import com.laplataenbici.model.domain.utils.Rol;

public class SecurityFilter implements ContainerRequestFilter{
	
	private Rol[] roles;
	
	public SecurityFilter(Rol[] roles){
		this.roles = roles;
	}

	@Override
	public void filter(ContainerRequestContext ctx) throws IOException {
		
		System.out.printf("%nRoles :%s", roles.toString());
		

	}

	
	
	

}
