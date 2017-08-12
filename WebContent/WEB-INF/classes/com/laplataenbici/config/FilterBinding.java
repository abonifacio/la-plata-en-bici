package com.laplataenbici.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.security.Secured;
import com.laplataenbici.security.SecurityFilter;

public class FilterBinding implements DynamicFeature	{
	
	
	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		Method m = resourceInfo.getResourceMethod();
		
		if(m.isAnnotationPresent(Secured.class)){
			Annotation annotation = m.getAnnotation(Secured.class);
			Rol[] roles = ((Secured) annotation).value();
			context.register(new SecurityFilter(roles));

		}
		
    }

}
