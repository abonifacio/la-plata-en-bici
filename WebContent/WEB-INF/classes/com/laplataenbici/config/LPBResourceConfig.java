package com.laplataenbici.config;

import org.glassfish.jersey.server.ResourceConfig;

public class LPBResourceConfig extends ResourceConfig{
	
	public LPBResourceConfig() {
		super(SecurityBinding.class);
	}

}
