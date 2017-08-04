package com.laplataenbici.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.laplataenbici.security.SecurityBinding;

public class LPBResourceConfig extends ResourceConfig{
	
	public LPBResourceConfig() {
		super(SecurityBinding.class);
	}

}
